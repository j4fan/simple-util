package com.j4fan.simpleutils.controller;

import com.j4fan.simpleutils.common.Result;
import com.j4fan.simpleutils.common.ResultGenerator;
import com.j4fan.simpleutils.domin.Goods;
import com.j4fan.simpleutils.repository.GoodRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@Controller
@RestController
@RequestMapping("/goods")
public class MockController {

    @Autowired
    GoodRepository goodRepository;

    @PostMapping("/insert")
    public Result insertNewGoods(@RequestBody Goods goods) {
        goodRepository.save(goods);
        return ResultGenerator.genSuccessResult();
    }
}
