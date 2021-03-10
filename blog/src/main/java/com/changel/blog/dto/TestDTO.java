package com.changel.blog.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * @Author Chang.Tong
 * @Date 2021/2/6 15:52
 * @Version 1.0
 */
@Data
public class TestDTO implements Serializable {
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
