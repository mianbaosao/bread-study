package com.mianbao.subject.infrastructure.rpc;

import com.mianbao.auth.api.UserFeignService;
import com.mianbao.auth.entity.AuthUserDTO;
import com.mianbao.auth.entity.Result;
import com.mianbao.subject.infrastructure.entity.UserInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: 用户rpc
 * @Author:bread
 * @Date: 2024-09-24 20:34
 */
@Component
public class UserRpc {
    @Resource
    private UserFeignService userFeignService;

    public UserInfo getUserInfo(String userName) {
        AuthUserDTO authUserDTO = new AuthUserDTO();
        authUserDTO.setUserName(userName);
        Result<AuthUserDTO> result = userFeignService.getUserInfo(authUserDTO);
        UserInfo userInfo = new UserInfo();
        if (!result.getSuccess()) {
            return userInfo;
        }
        AuthUserDTO data = result.getData();
        userInfo.setUserName(data.getUserName());
        userInfo.setNickName(data.getNickName());
        userInfo.setAvatar(data.getAvatar());
        return userInfo;
    }

}
