package com.blogs.xuan.service;

import com.blogs.xuan.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 9527
 * @since 2020-05-13
 */
public interface IUserService extends IService<User>, UserDetailsService {

    /**
     *  根据用户名查询用户
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    User loadUserByUsername(String s) throws UsernameNotFoundException;
}
