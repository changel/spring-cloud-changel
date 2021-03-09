package com.changel.blog.service;

import com.changel.blog.support.R;
import com.changel.blog.vo.TestVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @Author Chang.Tong
 * @Date 2021/2/22 17:31
 * @Version 1.0
 */
@FeignClient(name = "changel-major",fallback=MajorFeignServiceFallBack.class)
public interface MajorFeignService {

    @ApiOperation(
            value = "测试获取姓名年龄",
            notes = "随机返回姓名和年龄"
    )
    @GetMapping("/api/major/test")
    public R<TestVO> test() ;
}
