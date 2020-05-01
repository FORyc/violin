package com.blogs.xuan.mapper;

import com.blogs.xuan.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 * 后台用户角色表 Mapper 接口
 * </p>
 *
 * @author 9527
 * @since 2020-04-30
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("SELECT sys_role.* " +
            "from sys_role " +
            "LEFT JOIN user_role ON user_role.role_id = sys_role.id "+
            "WHERE user_role.user_id = #{userId}")
    Set<SysRole> getRoleBySysUid(@Param("userId") Long userId);

}
