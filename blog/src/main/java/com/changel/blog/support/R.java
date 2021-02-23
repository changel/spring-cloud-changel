package com.changel.blog.support;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * @Author Chang.Tong
 * @Date 2021/2/6 15:35
 * @Version 1.0
 */
public class R<T> {
    private String message = null;
    private String code = null;
    private T data = null;

    public R() {
        this.code = "0";
    }

    public R(T data) {
        this.code = "0";
        this.data = data;
    }

    public R(String code, MessageSource messageSource) {
        this.message = messageSource.getMessage(code, new Object[0], Locale.CHINA);
        this.code = code;
    }

    public R(String code, MessageSource messageSource, T data) {
        this.message = messageSource.getMessage(code, new Object[0], Locale.CHINA);
        this.code = code;
        this.data = data;
    }

    @ApiModelProperty(
            value = "提示信息",
            example = "操作成功"
    )
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @ApiModelProperty(
            value = "响应代码",
            example = "0"
    )
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @ApiModelProperty("数据")
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
