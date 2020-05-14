package com.blogs.xuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blogs.configuration.security.util.JwtUtils;
import com.blogs.xuan.entity.SysPermission;
import com.blogs.xuan.entity.SysRole;
import com.blogs.xuan.entity.SysUser;
import com.blogs.xuan.entity.UserRole;
import com.blogs.xuan.mapper.SysPermissionMapper;
import com.blogs.xuan.mapper.SysRoleMapper;
import com.blogs.xuan.mapper.SysUserMapper;
import com.blogs.xuan.mapper.UserRoleMapper;
import com.blogs.xuan.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public SysUser loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", s);
        SysUser sysUser = sysUserMapper.selectOne(userQueryWrapper);
        if(sysUser == null){
            throw new UsernameNotFoundException("未找到用户名 [ "+ s + " ] 相关的用户信息");
        }
        Set<SysPermission> permission = sysPermissionMapper.findAdminPermissionByUid(sysUser.getId());
        sysUser.setAuthorities(permission);
        Set<SysRole> sysRoles = sysRoleMapper.getRoleBySysUid(sysUser.getId());
        sysUser.setSysRoles(sysRoles);
        return sysUser;
    }

    @Override
    public String login(String username, String password) {
        SysUser userDetails = loadUserByUsername(username);
        if(userDetails == null){
            log.warn("用户名[{}]未找到", username);
            return null;
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            log.warn("用户[{}]密码错误", username);
            return null;
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtils.generateToken(userDetails);
    }

    @Override
    public Boolean saveAdmin(SysUser sysUser, Long roleId) {
        if(roleId == null){
            roleId = 1L;
        }
        String password = passwordEncoder.encode(sysUser.getPassword());
        sysUser.setPassword(password);
        sysUserMapper.insert(sysUser);
        UserRole userRole = new UserRole();
        userRole.setUserId(sysUser.getId());
        userRole.setRoleId(roleId);
        userRoleMapper.insert(userRole);
        return sysUser.getId() > 0;
    }
}
