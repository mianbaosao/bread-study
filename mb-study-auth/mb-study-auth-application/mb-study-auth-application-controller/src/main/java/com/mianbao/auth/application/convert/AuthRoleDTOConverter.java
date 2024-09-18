package com.mianbao.auth.application.convert;


import com.mianbao.auth.application.dto.AuthRoleDTO;
import com.mianbao.auth.domain.entity.AuthRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色dto转换器
 *
 * @author: bread
 * @date: 2024/09/18
 */
@Mapper
public interface AuthRoleDTOConverter {

    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleBO convertDTOToBO(AuthRoleDTO authRoleDTO);

}
