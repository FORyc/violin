package com.blogs.xuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blogs.xuan.entity.SysPermission;
import com.blogs.xuan.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import top.api.CommonPageParams;
import top.api.CommonResult;

import java.time.LocalDateTime;

/**
 * <p>
 * 后台用户权限表 前端控制器
 * </p>
 *
 * @author 9527
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/admin/sys-permission")
public class SysPermissionController {

    @Autowired
    private ISysPermissionService iSysPermissionService;

    @GetMapping(value = "/list")
    public CommonResult<IPage<SysPermission>> list(@RequestBody CommonPageParams commonPageParams){
        Page<SysPermission> page = new Page<>(commonPageParams.getPageNum(), commonPageParams.getPageSize());
        QueryWrapper<SysPermission> permissionQueryWrapper = new QueryWrapper<>();
        permissionQueryWrapper.allEq(commonPageParams.getPageParams());
        return CommonResult.success(iSysPermissionService.page(page, permissionQueryWrapper));
    }

    @PostMapping(value = "/add")
    public CommonResult add(@RequestBody SysPermission sysPermission){
        sysPermission.setCreateTime(LocalDateTime.now());
        boolean save = iSysPermissionService.save(sysPermission);
        return save ? CommonResult.success() : CommonResult.error();
    }

    @PostMapping(value = "/view/{permissionId}")
    public CommonResult<SysPermission> view(@PathVariable Long permissionId){
        return CommonResult.success(iSysPermissionService.getById(permissionId));
    }

    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody SysPermission sysPermission){
        boolean update = iSysPermissionService.updateById(sysPermission);
        return update ? CommonResult.success() : CommonResult.error();
    }

}

