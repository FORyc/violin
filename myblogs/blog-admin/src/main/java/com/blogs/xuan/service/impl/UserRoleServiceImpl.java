package com.blogs.xuan.service.impl;

import com.blogs.xuan.entity.UserRole;
import com.blogs.xuan.mapper.UserRoleMapper;
import com.blogs.xuan.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员-角色 关联表 服务实现类
 * </p>
 *
 * @author 9527
 * @since 2020-04-23
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
