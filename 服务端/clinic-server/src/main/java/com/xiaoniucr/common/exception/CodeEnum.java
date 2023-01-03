package com.xiaoniucr.common.exception;

/**
 * 业务状态码
 */
public enum CodeEnum {

    /**
     * OK[GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）
     */
    C200(200, "Success"),

    /**
     * Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）
     */
    C401(401, "Unauthorized"),

    /**
     * Forbidden - [*]：表示用户得到授权（与401错误相对），但是访问是被禁止的
     */
    C403(403, "Forbidden"),

    /**
     * INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功
     */
    C500(500, "Internal Server Error");


    /**
     * Code 状态码
     */
    private Integer code;


    /**
     * desc 描述
     */
    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
