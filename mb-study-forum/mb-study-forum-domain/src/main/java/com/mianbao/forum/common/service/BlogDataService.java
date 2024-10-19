package com.mianbao.forum.common.service;


import com.mianbao.forum.common.entity.BlogDataBO;
import com.mianbao.forum.infa.basic.entity.ForumBlogdata;

/**
 * @Description: blog
 * @Author:bread
 * @Date: 2024-10-17 19:23
 */

public interface BlogDataService {


    ForumBlogdata findSingleBLog(BlogDataBO blogDataBO);

    void queryByUserId(int userId);
}
