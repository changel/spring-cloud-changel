package com.changel.major.support;



/**
 * describe:
 *      返回实体组装工具类
 * @author changel
 * @date 2019/08/04
 */
public class ResponseEntityUtils {
    /**
     * 带实体的统一返回
     *
     * @param data 实体
     * @param <T>  实体类型
     * @return
     */
    public static <T> ResponseEntity buildSuccess(T data) {
        return new ResponseEntity<T>(ResultEnums.SUCCESS, data);
    }

    public static ResponseEntity buildSuccess() {
        return new ResponseEntity(ResultEnums.SUCCESS);
    }

    public static ResponseEntity buildSuccess(String msg) {
        return new ResponseEntity(ResultEnums.SUCCESS.getCode(), msg);
    }

    public static ResponseEntity buildResponseData(Integer code, String msg) {
        return new ResponseEntity(code, msg);
    }


    public static <T> ResponseEntity buildResponseData(Integer code, String msg, T data) {
        return new ResponseEntity<T>(code, msg, data);
    }

    public static ResponseEntity buildResponseData(ResultEnums resultEnums) {
        return new ResponseEntity(resultEnums);
    }

    public static <T> ResponseEntity buildError(T data) {
        return new ResponseEntity<T>(ResultEnums.ERROR, data);
    }

    public static ResponseEntity buildError() {
        return new ResponseEntity(ResultEnums.ERROR);
    }

    public static ResponseEntity buildError(String msg) {
        return new ResponseEntity(ResultEnums.ERROR.getCode(), msg);
    }

    public static ResponseEntity buildOK(String msg) {
        return new ResponseEntity(ResultEnums.OK.getCode(), msg);
    }
    public static ResponseEntity buildOK() {
        return buildOK("");
    }

    public static ResponseEntity buildFail(String msg) {
        return new ResponseEntity(ResultEnums.FAIL.getCode(), msg);
    }
}
