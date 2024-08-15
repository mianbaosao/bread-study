package com.qihang.subject.common.enums;

/**
 * @Description: 删除状态枚举
 * @Author:bread
 * @Date: 2024-07-29 19:48
 */
public enum IsDeleteEnum {
    DELETED(1, "已删除"),
    UN_DELETED(0, "未删除");

    public int code;
    public String desc;

    IsDeleteEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static IsDeleteEnum getBycode(int codeVal) {
        IsDeleteEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            IsDeleteEnum resultCodeEnum = var1[var3];
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }

        return null;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
