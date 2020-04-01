package com.blogs.configuration.security.util;

import com.blogs.entity.AdminUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 95271
 * Jwt工具类，用于管理token相关的操作
 */
@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.tokenHeader}")
    private String jwtTokenHeader;

    @Value("${jwt.tokenPrefix}")
    private String jwtTokenPrefix;

    @Value("${jwt.expiration}")
    private Long jwtTokenExpiration;


    public String createAccessToken(AdminUser user) {
        if (user ==null || user.getUsername() == null) {
            return null;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("rol", "rol");

        return Jwts
                .builder()
                .setSubject(user.getUsername())
                .setClaims(map)
                .claim("name", user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtTokenExpiration))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public Claims parseAccessToken(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
