package com.education.config;

import com.education.exception.RRException;
import com.education.framework.ApiResponse;
import com.education.framework.ApiStatusCode;
import com.education.framework.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Carl
 * @Description
 * @date 2019-10-13 20:38
 * @Param
 * @return
 **/
@ControllerAdvice
public class GlobalDefultExceptionHandler extends BaseController {

    private static Logger Log = LoggerFactory.getLogger(GlobalDefultExceptionHandler.class);

    //声明要捕获的异常
    @ExceptionHandler(RRException.class)
    @ResponseBody
    public ApiResponse defultExcepitonHandler(RRException e) {
        Log.info(e.getMessage(), e);
        return wrapApiResponse(ApiStatusCode.SERVICE_BIZ_EXCEPTION, null, e.getMessage(), e.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponse handleException(Exception e){
        Log.error("系统错误", e);
        return wrapApiResponse(ApiStatusCode.SYSTEM_ERROR, null, "系统错误");
    }
}
	
