package com.blogs.xuan.service.impl;

import com.blogs.xuan.entity.SysPermission;
import com.blogs.xuan.mapper.SysPermissionMapper;
import com.blogs.xuan.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author 9527
 * @since 2020-04-23
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public Set<SysPermission> getPermissionByUid(Long uid) {
        return sysPermissionMapper.getPermissionByUid(uid);
    }
}
