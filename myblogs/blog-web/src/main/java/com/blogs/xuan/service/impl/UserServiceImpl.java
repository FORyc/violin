package com.blogs.xuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blogs.xuan.entity.User;
import com.blogs.xuan.mapper.UserMapper;
import com.blogs.xuan.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", s);
        return userMapper.selectOne(userQueryWrapper);
    }
}
