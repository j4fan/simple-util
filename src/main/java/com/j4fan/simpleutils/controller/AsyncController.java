package com.j4fan.simpleutils.controller;

import com.j4fan.simpleutils.common.Result;
import com.j4fan.simpleutils.common.ResultGenerator;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/async")
public class AsyncController {

    @GetMapping("/test")
    public Result notifyAsync() {
        System.out.println("请求执行");
        new Thread(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运行完毕");
        }).start();
        System.out.println("请求结束");
        return ResultGenerator.genSuccessResult();
    }
}
