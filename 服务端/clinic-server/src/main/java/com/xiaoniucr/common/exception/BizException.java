package com.xiaoniucr.common.exception;

/**
 * 业务异常
 */
public class BizException extends Exception {

    private Integer code;
    private String message;


    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
