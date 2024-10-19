package com.mianbao.forum.application.controller;

import com.mianbao.forum.application.convert.BlogDataDtoConverToBo;
import com.mianbao.forum.application.dto.BlogDataDTO;
import com.mianbao.forum.common.entity.BlogDataBO;
import com.mianbao.forum.common.service.BlogDataService;
import com.mianbao.forum.infa.basic.entity.ForumBlogdata;
import com.study.forum.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * @Description: 博客控制类
 * @Author:bread
 * @Date: 2024-10-17 15:58
 */
@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class BlogDataController {

    @Resource
    private BlogDataService blogDataService;

    @PostMapping("/test")
    public Result<String> test(@RequestBody BlogDataDTO blogDataDTO){
        BlogDataBO blogDataBO = BlogDataDtoConverToBo.INSTANCE.converBlogDataDtoToBo(blogDataDTO);
        ForumBlogdata data = blogDataService.findSingleBLog(blogDataBO);
        return Result.success(data);
    }

    @PostMapping("/a")
    public String a() {
        log.info("Received request on /a");
        return "success";
    }

    @PostMapping("/queryByUserId")
    public Result<ForumBlogdata> queryByUserId(@RequestParam int userId){
        blogDataService.queryByUserId(userId);
        return null;
    }
}
