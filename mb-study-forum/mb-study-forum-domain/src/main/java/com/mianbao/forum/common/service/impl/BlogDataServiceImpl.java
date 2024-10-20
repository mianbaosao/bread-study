package com.mianbao.forum.common.service.impl;

import com.mianbao.forum.common.convert.BlogDataBoConvertToPo;
import com.mianbao.forum.common.entity.BlogDataBO;
import com.mianbao.forum.common.handler.recommend.RecommendType;
import com.mianbao.forum.common.handler.recommend.RecommendTypeFactory;
import com.mianbao.forum.common.service.BlogDataService;
import com.mianbao.forum.infa.basic.entity.ForumBlogdata;
import com.mianbao.forum.infa.basic.service.ForumBlogdataService;
import com.mianbao.subject.common.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: impl
 * @Author:bread
 * @Date: 2024-10-17 19:24
 */
@Service
@Slf4j
public class BlogDataServiceImpl implements BlogDataService {

    @Resource
    private ForumBlogdataService forumBlogdataService;

    @Resource
    private RecommendTypeFactory recommendTypeFactory;
    @Override
    public ForumBlogdata findSingleBLog(BlogDataBO blogDataBO) {
        ForumBlogdata blogdata= BlogDataBoConvertToPo.INSTANCE.BlogDataTOPo(blogDataBO);
        int blogId=blogdata.getBlogid();
      ForumBlogdata po =  forumBlogdataService.queryById(blogId);
      return po;
    }

    @Override
    public void queryByUserId(int userId) {
        String a="CB";
        RecommendType recommendType=recommendTypeFactory.getType(a);
        String loginId= LoginUtil.getLoginId();
        System.out.println("现在的loginId是："+loginId);
        System.out.println(recommendType.query(userId));
    }

}
