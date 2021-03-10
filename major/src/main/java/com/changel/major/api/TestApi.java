package com.changel.major.api;


import com.changel.major.support.R;
import com.changel.major.vo.TestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @Author Chang.Tong
 * @Date 2021/2/6 15:33
 * @Version 1.0
 */
@Api(tags="测试主应用接口")
@RestController
@RequestMapping(value = "/api/major")
@Slf4j
public class TestApi {

    @ApiOperation(
            value = "测试获取姓名年龄",
            notes = "随机返回姓名和年龄"
    )
    @GetMapping("/test")
    public R<TestVO> test() {
        log.info("访问主应用的测试接口...");
        R<TestVO> result = new R<>();

        TestVO vo = new TestVO();
        Random random =
                new Random();
        vo.setAge(random.nextInt(50));
        vo.setName("主应用Server:"+vo.getAge());
        result.setCode("1");
        result.setData(vo);
        return result;
    }
}
