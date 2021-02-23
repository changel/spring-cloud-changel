package com.changel.blog.service;

import com.changel.blog.support.R;
import com.changel.blog.vo.TestVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

/**
 * @Author Chang.Tong
 * @Date 2021/2/22 17:31
 * @Version 1.0
 */
@FeignClient(name = "changel-major")
public interface MajorFeignService {

    @ApiOperation(
            value = "测试获取姓名年龄",
            notes = "随机返回姓名和年龄"
    )
    @GetMapping("/api/major/test")
    public R<TestVo> test() ;
}
