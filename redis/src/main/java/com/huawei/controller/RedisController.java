package com.huawei.controller;

import com.huawei.pojo.Result;
import com.huawei.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: sun
 * @date: 2020年12月11日 20:23
 */
@RestController
@RequestMapping("/rediscontroller")
@Api(tags = "数据缓存到redis",value = "RedisController")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/setredis")
    @ApiOperation(value="新增品牌", notes="新增一个品牌的数据")
    public Result setRedis(){
        redisService.setRedis();
        return new Result(true,200,"数据存到redis");
    }
}
