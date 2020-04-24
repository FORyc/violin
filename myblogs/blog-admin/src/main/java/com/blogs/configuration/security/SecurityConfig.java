package com.blogs.configuration.security;

import com.blogs.configuration.security.filter.JwtAuthenticationTokenFilter;
import com.blogs.configuration.security.handler.MyAccessDeniedHandler;
import com.blogs.configuration.security.handler.MyAuthenticationEntryPoint;
import com.blogs.xuan.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] IGNORE_URL = {"/api/getToken", "/admin/login", "/test/user/**"};

    @Autowired
    private ISysUserService sysUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截路径
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 允许所有得OPTIONS请求
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                // 不需要保护的资源路径允许访问
                .antMatchers(IGNORE_URL).permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                //自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler())
                .authenticationEntryPoint(myAuthenticationEntryPoint())
                // 自定义权限拦截器JWT过滤器
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MyAccessDeniedHandler myAccessDeniedHandler(){
        return new MyAccessDeniedHandler();
    }

    @Bean
    public MyAuthenticationEntryPoint myAuthenticationEntryPoint(){
        return new MyAuthenticationEntryPoint();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }
}
