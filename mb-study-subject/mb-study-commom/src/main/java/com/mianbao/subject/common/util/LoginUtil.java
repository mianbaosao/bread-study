package com.mianbao.subject.common.util;


import com.mianbao.subject.common.context.LoginContextHolder;

/**
 * 用户登录util
 *
 * @author: bread
 * @date: 2024/9/29
 */
public class LoginUtil {

    public static String getLoginId() {
        return LoginContextHolder.getLoginId();
    }


}
