package com.j4fan.simpleutils.controller;

import com.j4fan.simpleutils.common.Result;
import com.j4fan.simpleutils.common.ResultGenerator;
import com.j4fan.simpleutils.domin.UserInfo;
import com.j4fan.simpleutils.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PutMapping("/register")
    public Result register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("mobile") String mobile) {
        UserInfo userInfo = loginService.register(username, password, mobile, email);
        return ResultGenerator.genSuccessResult(userInfo);
    }

    @PutMapping("/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        String token = loginService.login(username, password);
        return ResultGenerator.genSuccessResult(token);
    }

    @PostMapping("/logout")
    public Result logout(@RequestParam("userId") Long userId) {
        loginService.logout(userId);
        return ResultGenerator.genSuccessResult("登出成功");
    }
}
