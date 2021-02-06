package com.changel.major.api;


import com.changel.major.support.R;
import com.changel.major.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

/**
 * @Author Chang.Tong
 * @Date 2021/2/6 15:33
 * @Version 1.0
 */
@Api(tags="测试网关接口")
@RestController
@RequestMapping(value = "/frontend/api/gateway")
public class TestApi {

    @ApiOperation(
            value = "测试获取姓名年龄",
            notes = "随机返回姓名和年龄"
    )
    @GetMapping("/test/call-name-test")
    public R<TestVo> createTask() {
        R<TestVo> result = new R<>();
        TestVo vo = new TestVo();
        Random random =
                new Random();
        vo.setAge(random.nextInt(50));
        vo.setName(UUID.randomUUID().toString().substring(1, 8) + vo.getAge());
        result.setCode("1");
        result.setData(vo);
        return result;
    }
}
