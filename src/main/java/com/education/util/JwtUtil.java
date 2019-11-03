package com.education.util;

import com.alibaba.fastjson.JSONObject;
import com.education.center.user.entity.SysUserDO;
import com.education.center.user.vo.UserVO;
import com.education.common.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    static final String SECRET = "ThisIsASecret";

    public static String generateToken(SysUser sysUserDO) {

        Map<String,Object> param = new HashMap<String,Object>();
        param.put("openId",sysUserDO.getOpenId());
        param.put("userName",sysUserDO.getUserName());
        param.put("phone",sysUserDO.getPhone());
        param.put("userId",sysUserDO.getId());
        param.put("account",sysUserDO.getAccount());
        String jwt = Jwts.builder()
                .setSubject(JSONObject.toJSONString(param))
                .setHeader(param)
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return "Bearer "+jwt;
    }

    public static Claims validateToken(String token) {
        try {
            // parse the token.
            return  Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
        }catch (Exception e){
            throw new IllegalStateException("Invalid Token. "+e.getMessage());
        }
    }
}