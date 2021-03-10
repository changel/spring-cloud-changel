package com.changel.major.support;

import lombok.Data;

/**
 * describe:
 *      统一返回实体
 * @author changel
 * @date 2019/08/04
 */
@Data
public class ResponseEntity<T> {

    private Integer code;

    private String msg;

    private T data;


    public ResponseEntity(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public ResponseEntity(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public ResponseEntity(ResultEnums resultEnums) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
    }

    public ResponseEntity(ResultEnums resultEnums, T data) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
        this.data = data;
    }

    public ResponseEntity() {
    }
}
