package com.bread.oss.service;

import com.bread.oss.adapter.StorageAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

/**
 * @Description: 文件存储
 * @Author:bread
 * @Date: 2024-09-11 20:11
 */
@Service
public class FileService {

    private final StorageAdapter storageAdapter;

    public FileService(@Qualifier("storageService") StorageAdapter storageAdapter) {
        this.storageAdapter = storageAdapter;
    }

    /**
     * 列出所有桶
     * @return
     */

    public List<String> getAllBucket() {
        return storageAdapter.getAllBucket();
    }

    /**
     * 获取文件路径
     * @param bucketName
     * @param objectName
     * @return
     */

    public String getUrl(String bucketName,String objectName) {
        return storageAdapter.getUrl(bucketName,objectName);
    }

    /**
     * 上传文件
     * @param uploadFile
     * @param bucket
     * @param objectName
     * @return
     */

    public String uploadFile(MultipartFile uploadFile, String bucket, String objectName){
        storageAdapter.uploadFile(uploadFile,bucket,objectName);
        objectName = objectName + "/" + uploadFile.getOriginalFilename();
        return storageAdapter.getUrl(bucket, objectName);
    }
}
