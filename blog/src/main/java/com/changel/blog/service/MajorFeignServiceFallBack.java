package com.changel.blog.service;

import com.changel.blog.support.R;
import com.changel.blog.vo.TestVO;
import org.springframework.stereotype.Component;


/**
 * @Author Chang.Tong
 * @Date 2021/2/24 17:15
 * @Version 1.0
 */
@Component
public class MajorFeignServiceFallBack implements MajorFeignService{

    @Override
    public R<TestVO> test() {
        R<TestVO> result = new R<>();
        TestVO vo = new TestVO();
        vo.setAge(-1);
        vo.setName("未知用户");
        result.setCode("1");
        result.setData(vo);
        return result;
    }
}
