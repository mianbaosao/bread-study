package com.bread.oss.entity;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(500,"失败");

    public int code;

    public String desc;

    ResultCodeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static com.bread.oss.entity.ResultCodeEnum getByCode(int codeVal){
        for(com.bread.oss.entity.ResultCodeEnum resultCodeEnum : com.bread.oss.entity.ResultCodeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
