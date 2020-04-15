package com.blogs.service.impl;

import com.blogs.entity.AdminUser;
import com.blogs.service.SysUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author liu
 * 用户认证类，正式应从数据库中查询，目前先本地模拟
 */
@Service
public class SysUserDetailsServiceImpl implements SysUserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername("小红");
        return adminUser;
    }
}
