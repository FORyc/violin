package com.blogs.xuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blogs.xuan.entity.SysPermission;
import com.blogs.xuan.entity.SysUser;
import com.blogs.xuan.mapper.SysPermissionMapper;
import com.blogs.xuan.mapper.SysUserMapper;
import com.blogs.xuan.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 后台用户表--管理员 服务实现类
 * </p>
 *
 * @author 9527
 * @since 2020-04-22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", s);
        SysUser sysUser = sysUserMapper.selectOne(userQueryWrapper);
        if(sysUser == null){
            throw new UsernameNotFoundException("未找到用户名 [ "+ s + " ] 相关的用户信息");
        }
        Set<SysPermission> permission = sysPermissionMapper.getPermissionByUid(sysUser.getId());
        sysUser.setAuthorities(permission);
        return sysUser;
    }
}
