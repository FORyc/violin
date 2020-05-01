package com.blogs.xuan.service;

import com.blogs.xuan.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 * 后台用户表--管理员 服务类
 * </p>
 *
 * @author 9527
 * @since 2020-04-22
 */
public interface ISysUserService extends IService<SysUser>, UserDetailsService {

    /**
     *  管理员登录操作
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    String login(String username, String password);

    /**
     *  新增管理员
     * @param sysUser 管理员实体
     * @param roleId 角色ID
     * @return true/false
     */
    Boolean saveAdmin(SysUser sysUser, Long roleId);

}
