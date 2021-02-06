package com.changel.major.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Chang.Tong
 * @Date 2021/2/6 15:49
 * @Version 1.0
 */
@Data
public class TestVo {

    @ApiModelProperty(
            value = "年龄",
            example = "1"
    )
    private Integer age;

    @ApiModelProperty(
            value = "姓名",
            example = "张三"
    )
    private String name;
}
