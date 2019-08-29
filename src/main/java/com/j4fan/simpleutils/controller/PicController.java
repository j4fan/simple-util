package com.j4fan.simpleutils.controller;

import com.j4fan.simpleutils.annotations.CheckToken;
import com.j4fan.simpleutils.annotations.SysLog;
import com.j4fan.simpleutils.common.Result;
import com.j4fan.simpleutils.common.ResultGenerator;
import com.j4fan.simpleutils.domin.PicInfo;
import com.j4fan.simpleutils.service.PicInfoService;
import com.j4fan.simpleutils.service.PicService;
import com.j4fan.simpleutils.service.TokenService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api
@RestController
@RequestMapping("/pic")
public class PicController {

    @Autowired
    PicService picService;

    @Autowired
    PicInfoService picInfoService;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        PicInfo picInfo = picService.saveFile(file);
        picInfoService.savePic(picInfo);
        return ResultGenerator.genSuccessResult(picInfo);
    }

    @GetMapping("{userId}/{token}/{id}")
    @CheckToken
    public Result getById(@PathVariable(value = "userId") long userId,
                          @PathVariable(value = "token") String token,
                          @PathVariable(value = "id") int id) {
        tokenService.checkToken(userId, token);
        PicInfo picInfo = picInfoService.getPicByName(id);
        return ResultGenerator.genSuccessResult(picInfo);
    }

    @DeleteMapping("{userId}/{token}/{id}")
    public Result deleteById(@PathVariable(value = "userId") long userId,
                             @PathVariable(value = "token") String token,
                             @PathVariable(value = "id") int id) {
        tokenService.checkToken(userId, token);
        picInfoService.deletePicById(id);
        return ResultGenerator.genSuccessResult();
    }
}
