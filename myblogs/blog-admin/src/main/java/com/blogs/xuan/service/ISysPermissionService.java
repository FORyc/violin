package com.blogs.xuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blogs.xuan.entity.SysPermission;

import java.util.Set;

/**
 * <p>
 * 后台用户权限表 服务类
 * </p>
 *
 * @author 9527
 * @since 2020-04-23
 */
public interface ISysPermissionService extends IService<SysPermission> {

    Set<SysPermission> getPermissionByUid(Long uid);

}
