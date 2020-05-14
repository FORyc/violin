package com.blogs.xuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blogs.configuration.security.util.JwtUtils;
import com.blogs.xuan.entity.User;
import com.blogs.xuan.mapper.UserMapper;
import com.blogs.xuan.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 9527
 * @since 2020-05-13
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", s);
        return userMapper.selectOne(userQueryWrapper);
    }

    @Override
    public String login(String username, String password) {
        User user = null;
        try {
           user = loadUserByUsername(username);
           if(passwordEncoder.matches(password, user.getPassword())){
               return jwtUtils.generateToken(user);
           }
           return null;
        } catch (Exception e){
            log.warn("用户名[ " + username + " ]未找到。", e);
            e.printStackTrace();
            return null;
        }
    }
}
