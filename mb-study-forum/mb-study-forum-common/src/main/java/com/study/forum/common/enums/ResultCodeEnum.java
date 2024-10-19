package com.study.forum.common.enums;

/**
 * @Description: 枚举类
 * @Author:bread
 * @Date: 2024-07-29 19:48
 */
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    public int code;
    public String desc;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getBycode(int codeVal) {
        ResultCodeEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ResultCodeEnum resultCodeEnum = var1[var3];
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
