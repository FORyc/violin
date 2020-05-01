package com.blogs.xuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blogs.xuan.entity.SysRole;
import com.blogs.xuan.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.api.CommonPageParams;
import top.api.CommonResult;

/**
 * <p>
 * 后台用户角色表 前端控制器
 * </p>
 *
 * @author 9527
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/admin/sys-role")
public class SysRoleController {

    @Autowired
    private ISysRoleService iSysRoleService;

    @GetMapping(value = "/list")
    public CommonResult<IPage<SysRole>> list(@RequestBody CommonPageParams commonPageParams){
        Page<SysRole> page = new Page<>(commonPageParams.getPageNum(), commonPageParams.getPageSize());
        QueryWrapper<SysRole> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.allEq(commonPageParams.getPageParams());
        return CommonResult.success(iSysRoleService.page(page, roleQueryWrapper));
    }

    @PostMapping(value = "/add")
    public CommonResult add(@RequestBody SysRole sysRole){
        boolean save = iSysRoleService.save(sysRole);
        return save ? CommonResult.success() : CommonResult.error();
    }

    @PostMapping(value = "/view/{roleId}")
    public CommonResult<SysRole> view(@PathVariable Long roleId){
        return CommonResult.success(iSysRoleService.getById(roleId));
    }

    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody SysRole sysRole){
        boolean update = iSysRoleService.updateById(sysRole);
        return update ? CommonResult.success() : CommonResult.error();
    }


}

