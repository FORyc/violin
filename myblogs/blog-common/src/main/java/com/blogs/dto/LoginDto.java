package com.blogs.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author 9527
 *  登录实体类
 */
@Data
public class LoginDto {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "用户名不能为空")
    private String password;
}
