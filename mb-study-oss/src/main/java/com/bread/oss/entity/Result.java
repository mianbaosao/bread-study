package com.bread.oss.entity;

import lombok.Data;

@Data
public class Result<T> {

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static com.bread.oss.entity.Result ok(){
        com.bread.oss.entity.Result result = new com.bread.oss.entity.Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        return result;
    }

    public static <T> com.bread.oss.entity.Result ok(T data){
        com.bread.oss.entity.Result result = new com.bread.oss.entity.Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        result.setData(data);
        return result;
    }

    public static com.bread.oss.entity.Result fail(){
        com.bread.oss.entity.Result result = new com.bread.oss.entity.Result();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getDesc());
        return result;
    }

    public static <T> com.bread.oss.entity.Result fail(T data){
        com.bread.oss.entity.Result result = new com.bread.oss.entity.Result();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getDesc());
        result.setData(data);
        return result;
    }

}
