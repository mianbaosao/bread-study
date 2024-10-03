package com.mianbao.subject.infrastructure.basic.service.impl;


import com.mianbao.subject.common.entity.PageResult;
import com.mianbao.subject.common.enums.SubjectInfoTypeEnum;
import com.mianbao.subject.infrastructure.basic.entity.EsSubjectFields;
import com.mianbao.subject.infrastructure.basic.entity.SubjectInfoEs;
import com.mianbao.subject.infrastructure.basic.es.EsIndexInfo;
import com.mianbao.subject.infrastructure.basic.es.EsRestClient;
import com.mianbao.subject.infrastructure.basic.es.EsSearchRequest;
import com.mianbao.subject.infrastructure.basic.es.EsSourceData;
import com.mianbao.subject.infrastructure.basic.service.SubjectEsService;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections4.MapUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
@Slf4j
public class SubjectEsServiceImpl implements SubjectEsService {

    @Override
    public boolean insert(SubjectInfoEs subjectInfoEs) {
        EsSourceData esSourceData = new EsSourceData();
        Map<String, Object> data = convert2EsSourceData(subjectInfoEs);
        esSourceData.setDocId(subjectInfoEs.getDocId().toString());
        esSourceData.setData(data);
        return EsRestClient.insertDoc(getEsIndexInfo(), esSourceData);
    }

    private Map<String, Object> convert2EsSourceData(SubjectInfoEs subjectInfoEs) {
        Map<String, Object> data = new HashMap<>();
        data.put(EsSubjectFields.SUBJECT_ID, subjectInfoEs.getSubjectId());
        data.put(EsSubjectFields.DOC_ID, subjectInfoEs.getDocId());
        data.put(EsSubjectFields.SUBJECT_NAME, subjectInfoEs.getSubjectName());
        data.put(EsSubjectFields.SUBJECT_ANSWER, subjectInfoEs.getSubjectAnswer());
        data.put(EsSubjectFields.SUBJECT_TYPE, subjectInfoEs.getSubjectType());
        data.put(EsSubjectFields.CREATE_USER, subjectInfoEs.getCreateUser());
        data.put(EsSubjectFields.CREATE_TIME, subjectInfoEs.getCreateTime());
        return data;
    }

    @Override
    public PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs req) {
        PageResult<SubjectInfoEs> pageResult = new PageResult<>();
        EsSearchRequest esSearchRequest = createSearchListQuery(req);
        SearchResponse searchResponse = EsRestClient.searchWithTermQuery(getEsIndexInfo(), esSearchRequest);

        List<SubjectInfoEs> subjectInfoEsList = new LinkedList<>();
        SearchHits searchHits = searchResponse.getHits();
        if (searchHits == null || searchHits.getHits() == null) {
            pageResult.setPageNo(req.getPageNo());
            pageResult.setPageSize(req.getPageSize());
            pageResult.setResult(subjectInfoEsList);
            pageResult.setTotal(0);
            return pageResult;
        }
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            SubjectInfoEs subjectInfoEs = convertResult(hit);
            if (Objects.nonNull(subjectInfoEs)) {
                subjectInfoEsList.add(subjectInfoEs);
            }
        }
        pageResult.setPageNo(req.getPageNo());
        pageResult.setPageSize(req.getPageSize());
        pageResult.setResult(subjectInfoEsList);
        pageResult.setTotal(Long.valueOf(searchHits.getTotalHits().value).intValue());
        return pageResult;
    }

    private SubjectInfoEs convertResult(SearchHit hit) {
        Map<String, Object> sourceAsMap = hit.getSourceAsMap();
        if (CollectionUtils.isEmpty(sourceAsMap)) {
            return null;
        }
        SubjectInfoEs result = new SubjectInfoEs();
        result.setSubjectId(MapUtils.getLong(sourceAsMap, EsSubjectFields.SUBJECT_ID));
        result.setSubjectName(MapUtils.getString(sourceAsMap, EsSubjectFields.SUBJECT_NAME));

        result.setSubjectAnswer(MapUtils.getString(sourceAsMap, EsSubjectFields.SUBJECT_ANSWER));

        result.setDocId(MapUtils.getLong(sourceAsMap, EsSubjectFields.DOC_ID));
        result.setSubjectType(MapUtils.getInteger(sourceAsMap, EsSubjectFields.SUBJECT_TYPE));
        result.setScore(new BigDecimal(String.valueOf(hit.getScore())).multiply(new BigDecimal("100.00")
                .setScale(2, RoundingMode.HALF_UP)));

        //处理name的高亮
        Map<String, HighlightField> highlightFields = hit.getHighlightFields();
        HighlightField subjectNameField = highlightFields.get(EsSubjectFields.SUBJECT_NAME);
        if(Objects.nonNull(subjectNameField)){
            Text[] fragments = subjectNameField.getFragments();
            StringBuilder subjectNameBuilder = new StringBuilder();
            for (Text fragment : fragments) {
                subjectNameBuilder.append(fragment);
            }
            result.setSubjectName(subjectNameBuilder.toString());
        }

        //处理答案高亮
        HighlightField subjectAnswerField = highlightFields.get(EsSubjectFields.SUBJECT_ANSWER);
        if(Objects.nonNull(subjectAnswerField)){
            Text[] fragments = subjectAnswerField.getFragments();
            StringBuilder subjectAnswerBuilder = new StringBuilder();
            for (Text fragment : fragments) {
                subjectAnswerBuilder.append(fragment);
            }
            result.setSubjectAnswer(subjectAnswerBuilder.toString());
        }

        return result;
    }

    private EsSearchRequest createSearchListQuery(SubjectInfoEs req) {
        EsSearchRequest esSearchRequest = new EsSearchRequest();

        // 创建布尔查询构建器
        BoolQueryBuilder bq = new BoolQueryBuilder();

        // 匹配 subjectName 字段
        MatchQueryBuilder subjectNameQueryBuilder =
                QueryBuilders.matchQuery(EsSubjectFields.SUBJECT_NAME, req.getKeyWord());
        bq.should(subjectNameQueryBuilder);
        subjectNameQueryBuilder.boost(2); // 提高 subjectName 字段的权重

        // 匹配 subjectAnswer 字段
        MatchQueryBuilder subjectAnswerQueryBuilder =
                QueryBuilders.matchQuery(EsSubjectFields.SUBJECT_ANSWER, req.getKeyWord());
        bq.should(subjectAnswerQueryBuilder);

        // 匹配 subjectType 字段
        MatchQueryBuilder subjectTypeQueryBuilder =
                QueryBuilders.matchQuery(EsSubjectFields.SUBJECT_TYPE, SubjectInfoTypeEnum.BRIEF.getCode());
        bq.must(subjectTypeQueryBuilder);

        // 设置至少需要匹配一个 should 条件
        bq.minimumShouldMatch(1);

        // 配置高亮显示
        HighlightBuilder highlightBuilder = new HighlightBuilder()
                .field("*") // 高亮所有字段
                .requireFieldMatch(false); // 不要求字段完全匹配
        highlightBuilder.preTags("<span style = \"color:red\">"); // 设置高亮前缀
        highlightBuilder.postTags("</span>"); // 设置高亮后缀

        // 设置搜索请求参数
        esSearchRequest.setBq(bq);
        esSearchRequest.setHighlightBuilder(highlightBuilder);
        esSearchRequest.setFields(EsSubjectFields.FIELD_QUERY);
        esSearchRequest.setFrom((req.getPageNo() - 1) * req.getPageSize()); // 计算 from 参数
        esSearchRequest.setSize(req.getPageSize()); // 设置 size 参数
        esSearchRequest.setNeedScroll(false); // 设置是否需要滚动查询

        return esSearchRequest;
    }
    private EsIndexInfo getEsIndexInfo() {
        EsIndexInfo esIndexInfo = new EsIndexInfo();
        esIndexInfo.setClusterName("bf5cd64ef90f");
        esIndexInfo.setIndexName("subject_index");
        return esIndexInfo;
    }
}
