package com.j4fan.simpleutils.service;

import com.j4fan.simpleutils.domin.UserInfo;
import com.j4fan.simpleutils.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenService tokenService;

    public UserInfo register(String userName, String password, String mobile, String email) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfo.setEmail(email);
        userInfo.setMobile(mobile);
        userRepository.save(userInfo);
        return userInfo;
    }

    public String login(String userName, String password) {
        UserInfo userInfo = userRepository.getByUserName(userName);
        if (userInfo == null) {
            throw new RuntimeException("用户名不存在");
        }
        if (!userInfo.getPassword().equals(password)) {
            throw new RuntimeException("密码不正确");
        }

        String token = tokenService.getToken(userInfo.getId());
        return token;
    }

    public boolean logout(Long userId) {
        return tokenService.clearToken(userId);
    }

}
