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

}
