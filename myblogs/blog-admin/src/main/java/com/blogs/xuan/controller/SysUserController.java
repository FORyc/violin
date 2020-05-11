package com.blogs.xuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blogs.configuration.security.util.JwtUtils;
import com.blogs.dto.LoginDto;
import com.blogs.xuan.entity.SysUser;
import com.blogs.xuan.entity.UserRole;
import com.blogs.xuan.service.ISysUserService;
import com.blogs.xuan.service.IUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.api.CommonResult;
import top.exception.BusinessException;
import top.exception.EmBusinessException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户表--管理员 前端控制器
 * </p>
 *
 * @author 9527
 * @since 2020-04-22
 */
@Api(value = "sysUser接口")
@Slf4j
@RestController
@RequestMapping("/admin/sys-user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private IUserRoleService iUserRoleService;
    @Autowired
    private JwtUtils jwtUtils;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenPrefix}")
    private String jwtPrefix;


    @ApiOperation(value = "注册用户")
    @PostMapping(value = "/register")
    public CommonResult register(@RequestBody SysUser sysUser){
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("username", sysUser.getUsername());
        SysUser one = sysUserService.getOne(sysUserQueryWrapper, true);
        if(one != null){
            return CommonResult.error("用户名 [" + sysUser.getUsername() + "] 已被使用");
        }
        boolean save = sysUserService.saveAdmin(sysUser, null);
        return save ? CommonResult.success(sysUser) : CommonResult.error("注册失败，请联系管理员");
    }

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody LoginDto loginDto){
        String login = sysUserService.login(loginDto.getUsername(), loginDto.getPassword());
        if(StringUtils.isEmpty(login)){
            throw new BusinessException(EmBusinessException.USER_NOT_FOUND);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("token", jwtPrefix + login);
        return CommonResult.success(map);
    }

    @GetMapping(value = "/getInfo")
    public CommonResult getInfo(HttpServletRequest request){
        Map<String, Object> resultMap = new HashMap<>();
        String token = request.getHeader(tokenHeader);
        String substring = token.substring(jwtPrefix.length());
        String username = jwtUtils.getUserNameFromToken(substring);
        SysUser sysUser = sysUserService.loadUserByUsername(username);
        resultMap.put("roles", sysUser.getAuthorities().stream().map(SimpleGrantedAuthority::getAuthority).toArray(String[]::new));
        resultMap.put("name", sysUser.getUsername());
        resultMap.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return CommonResult.success(resultMap);
    }

    @PostMapping(value = "/delete/{userId}")
    public CommonResult delete(@PathVariable Long userId){
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.lambda().eq(UserRole::getUserId, userId);
        iUserRoleService.remove(userRoleQueryWrapper);
        return CommonResult.success(sysUserService.removeById(userId));
    }

    @PostMapping(value = "/logout")
    public CommonResult logout(HttpServletRequest request){
        // TODO 缓存登出的token，避免已登出的token再次访问
        return CommonResult.success("登出成功");
    }


}

