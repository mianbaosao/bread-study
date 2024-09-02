package com.qihang.subject.common.enums;

/**
 * @Description: 题目类型的枚举
 * @Author:bread
 * @Date: 2024-08-26 19:48
 */
public enum SubjectInfoTypeEnum {
    RADIO(1, "单选"),
    MULTIPLE(2, "多选"),
    JUDGE(3, "判断"),
    BRIEF(4, "简答");

    public int code;
    public String desc;

    SubjectInfoTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SubjectInfoTypeEnum getBycode(int codeVal) {
        SubjectInfoTypeEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SubjectInfoTypeEnum resultCodeEnum = var1[var3];
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
