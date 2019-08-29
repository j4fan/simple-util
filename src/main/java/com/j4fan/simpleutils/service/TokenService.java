package com.j4fan.simpleutils.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenService {

    private static Map<Long, String> tokenMap = new HashMap<>();

    public String getToken(Long userId) {
        UUID uuid = UUID.randomUUID();
        tokenMap.put(userId, uuid.toString());
        return uuid.toString();
    }

    public boolean checkToken(Long userId, String token) {
        String existToken = tokenMap.get(userId);
        if (StringUtils.isEmpty(existToken)) {
            throw new RuntimeException("token不存在");
        } else if (!existToken.equals(token)) {
            throw new RuntimeException("token错误");
        }
        return true;
    }

    public boolean clearToken(Long userId) {
        if (tokenMap.containsKey(userId)) {
            tokenMap.remove(userId);
        }
        return true;
    }
}
