package com.changel.blog.controller;

import com.alibaba.fastjson.JSON;
import com.changel.blog.dto.TestDTO;
import com.changel.blog.service.MajorFeignService;
import com.changel.blog.support.R;
import com.changel.blog.vo.TestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, TestDTO> kafkaTemplateEntity;
    @ApiOperation(
            value = "测试获取姓名年龄",
            notes = "随机返回姓名和年龄"
    )
    @GetMapping("/test")
    public R<TestVO> createTask() {
        log.info("访问blog的测试接口...");
        R<TestVO>  r = majorFeignService.test();
        return r;
    }

    @ApiOperation(
            value = "输入用户信息",
            notes = "输入用户信息"
    )
    @PostMapping("/test-kafka")
    public R testKafka(@RequestBody TestDTO testDto) {
        log.info("访问blog的kafka测试接口...");
        ListenableFuture<SendResult<String,Object>> resultListenableFuture = kafkaTemplate.send("testTopic", JSON.toJSONString(testDto));
        R<TestVO> result = new R<>();
        result.setCode("1");
        result.setMessage("保存成功");
        return result;
    }

    @ApiOperation(
            value = "输入用户信息",
            notes = "输入用户信息"
    )
    @PostMapping("/test-kafka-entity")
    public R testKafkaEntity(@RequestBody TestDTO testDto) {
        log.info("访问blog的kafka测试接口...");
        ListenableFuture<SendResult<String,TestDTO>> resultListenableFuture = kafkaTemplateEntity.send("testTopic-entity", testDto);
        R<TestVO> result = new R<>();
        result.setCode("1");
        result.setMessage("保存成功");
        return result;
    }
}
