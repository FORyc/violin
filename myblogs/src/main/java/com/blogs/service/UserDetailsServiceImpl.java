package com.blogs.service;

import com.blogs.entity.AdminUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author liu
 * 用户认证类，正式应从数据库中查询，目前先本地模拟
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername("小红");
        return adminUser;
    }
}
