package com.changel.blog.controller;

import com.changel.blog.service.MajorFeignService;
import com.changel.blog.support.R;
import com.changel.blog.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Chang.Tong
 * @Date 2021/2/22 17:39
 * @Version 1.0
 */
@Api(tags="Blog-Server测试接口")
@RestController
@RequestMapping(value = "/api/blog")
@Slf4j
public class TestController {
    @Resource
    private MajorFeignService majorFeignService;

    @ApiOperation(
            value = "测试获取姓名年龄",
            notes = "随机返回姓名和年龄"
    )
    @GetMapping("/test")
    public R<TestVo> createTask() {
        log.info("访问blog的测试接口...");
        R<TestVo>  r = majorFeignService.test();
        return r;
    }
}
