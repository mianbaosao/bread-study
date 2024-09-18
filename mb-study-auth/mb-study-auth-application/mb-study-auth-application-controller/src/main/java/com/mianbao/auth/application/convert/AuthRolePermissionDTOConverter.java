package com.mianbao.auth.application.convert;


import com.mianbao.auth.application.dto.AuthRolePermissionDTO;
import com.mianbao.auth.domain.entity.AuthRolePermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 权限dto转换器
 *
 * @author: bread
 * @date: 2024/09/18
 */
@Mapper
public interface AuthRolePermissionDTOConverter {

   AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);

    AuthRolePermissionBO convertDTOToBO(AuthRolePermissionDTO authRolePermissionDTO);

}
