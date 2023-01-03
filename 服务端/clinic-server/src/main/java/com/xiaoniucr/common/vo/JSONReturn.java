package com.xiaoniucr.common.vo;

/**
 * 统一JSON返回
 */
public class JSONReturn<T> {

    //返回状态码
    private Integer code;

    //响应消息
    private String msg;

    //返回数据
    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 原始构造
     */
    public JSONReturn() {
    }

    /**
     * 带参构造
     * @param code
     * @param msg
     */
    public JSONReturn(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    /**
     * 带参构造
     * @param code
     * @param msg
     * @param data
     */
    public JSONReturn(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



    /**
     * 根据状态码和内容返回消息
     * @param code  状态码
     * @param message 消息
     * @return
     */
    public static JSONReturn build(Integer code, String message){
        return new JSONReturn(code,message);
    }



    /**
     * 根据状态码和内容返回消息
     * @param code  状态码
     * @param message 消息
     * @param data  消息主体
     * @return
     */
    public static <T> JSONReturn<T> build(Integer code, String message, T data){
        return new JSONReturn(code,message,data);
    }



    /**
     * 简单返回成功消息
     * @return
     */
    public static JSONReturn success(){
        return new JSONReturn(200,"操作成功！");
    }

    /**
     * 构建返回成功消息
     * @param message 消息
     * @return
     */
    public static JSONReturn success(String message){
        return new JSONReturn(200,message);
    }



    /**
     * 构建返回成功消息
     * @param body 数据
     * @return
     */
    public static <T> JSONReturn<T> success(T body){
        return new JSONReturn(200,"操作成功",body);
    }




    /**
     * 构建返回成功消息，带数据
     * @param message 消息
     * @param body 成功消息主体
     * @return
     */
    public static <T> JSONReturn<T> success(String message, T body){
        return new JSONReturn(200,message,body);
    }



    /**
     * 简单返回失败消息
     * @return
     */
    public static JSONReturn failed(){
        return new JSONReturn(500,"操作失败！");
    }


    /**
     * 构建返回失败消息
     * @param message 消息
     * @return
     */
    public static JSONReturn failed(String message){
        return new JSONReturn(500,message);
    }






}
