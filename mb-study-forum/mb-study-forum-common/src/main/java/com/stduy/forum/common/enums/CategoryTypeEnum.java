package com.stduy.forum.common.enums;

/**
 * @Description: 分类状态枚举
 * @Author:bread
 * @Date: 2024-08-15 19:48
 */
public enum CategoryTypeEnum {
    PRIMAY(1, "岗位大类"),
    SECOND(2, "二级分类");

    public int code;
    public String desc;

    CategoryTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CategoryTypeEnum getBycode(int codeVal) {
        CategoryTypeEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            CategoryTypeEnum resultCodeEnum = var1[var3];
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
