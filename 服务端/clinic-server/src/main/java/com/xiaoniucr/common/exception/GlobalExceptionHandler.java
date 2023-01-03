package com.xiaoniucr.common.exception;

import com.xiaoniucr.common.vo.JSONReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 异常全局处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //日志
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    //自定义异常
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public JSONReturn<?> customer(HttpServletRequest request, BizException e) {
        logger.error("自定义异常：", e);
        return JSONReturn.build(e.getCode(),e.getMessage());
    }

    //系统未知异常
    @ExceptionHandler(Exception.class)
    @ResponseBody//返回json串
    public JSONReturn<?> error(HttpServletRequest request, Exception e) {
        logger.error("系统内部未知异常：", e);
        return JSONReturn.failed("服务器异常");
    }
}
