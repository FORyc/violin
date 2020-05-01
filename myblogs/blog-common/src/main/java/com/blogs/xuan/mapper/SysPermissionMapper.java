package com.blogs.xuan.mapper;

import com.blogs.xuan.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 * 后台用户权限表 Mapper 接口
 * </p>
 *
 * @author 9527
 * @since 2020-04-30
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    @Select("SELECT " +
            "sys_permission.* " +
            "FROM " +
            "sys_permission " +
            "LEFT JOIN role_permission ON role_permission.permission_id = sys_permission.id " +
            "LEFT JOIN user_role ON user_role.role_id = role_permission.role_id " +
            "LEFT JOIN sys_user ON sys_user.id = user_role.user_id " +
            "WHERE sys_user.id = #{userId}")
    Set<SysPermission> getPermissionByUid(@Param("userId") Long uid);

}
