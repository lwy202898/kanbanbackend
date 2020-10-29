package com.kanbanboard.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kanbanboard.entity.Hruser;
import com.kanbanboard.service.HruserService;
import com.kanbanboard.common.dto.LoginDto;
import com.kanbanboard.common.lang.Result;
import com.kanbanboard.service.HruserService;
import com.kanbanboard.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

    @Autowired
    HruserService hruserService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {

        Hruser user = hruserService.getOne(new QueryWrapper<Hruser>().eq("email", loginDto.getEmail()));
        Assert.notNull(user, "email not existed");

        if(!SecureUtil.md5(user.getPassword()).equals(SecureUtil.md5(loginDto.getPassword()))){
            return Result.fail("password wrong!");
        }
        String jwt = jwtUtils.generateToken(user.getEmail());

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return Result.succ(MapUtil.builder()
                .put("email", user.getEmail())
                .put("firstname", user.getFirstname())
                .put("lastname", user.getLastname())
                .map()
        );
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }

}
