package com.bread.oss.controller;

import com.bread.oss.adapter.impl.MinioAdapterImpl;
import com.bread.oss.util.MinioUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 文件控制器
 * @Author:bread
 * @Date: 2024-09-11 19:39
 */
@RestController
public class FileController {
    @Resource
    private MinioAdapterImpl minioAdapter;

    @RequestMapping("/test")
    public String test()throws Exception{
        List<String> allBucket = minioAdapter.getAllBucket();
        return  allBucket.get(0);
    }
    @RequestMapping("/test2")
    public String test2()throws Exception{

        return  "ssssssss";
    }
}
