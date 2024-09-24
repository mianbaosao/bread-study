package com.mianbao.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.mianbao.auth.api.UserFeignService;
import com.mianbao.subject.application.convert.SubjectLabelDTOConverter;
import com.mianbao.subject.application.dto.SubjectLabelDTO;
import com.mianbao.subject.common.entity.Result;
import com.mianbao.subject.domain.entity.SubjectLabelBO;
import com.mianbao.subject.infrastructure.entity.UserInfo;
import com.mianbao.subject.infrastructure.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: test
 * @Author:bread
 * @Date: 2024-09-24 20:41
 */
@RestController
@Slf4j
public class TestFeignController {


    @Resource
    private UserRpc userRpc;


    @GetMapping("/testFeign")
    public void update(){
        UserInfo userInfo=userRpc.getUserInfo("1623666966");
       log.info("testfeign.userinfo{}:",userInfo);
    }
}
