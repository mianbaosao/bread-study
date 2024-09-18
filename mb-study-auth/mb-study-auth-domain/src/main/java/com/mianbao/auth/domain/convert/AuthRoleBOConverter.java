package com.mianbao.auth.domain.convert;


import com.mianbao.auth.domain.entity.AuthRoleBO;
import com.mianbao.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色bo转换器
 *
 * @author: bread
 * @date: 2024/09/18
 */
@Mapper
public interface AuthRoleBOConverter {

    AuthRoleBOConverter INSTANCE = Mappers.getMapper(AuthRoleBOConverter.class);

    AuthRole convertBOToEntity(AuthRoleBO authRoleBO);

}
