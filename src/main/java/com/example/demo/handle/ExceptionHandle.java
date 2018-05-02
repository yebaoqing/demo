package com.example.demo.handle;

import com.example.demo.domain.Result;
import com.example.demo.exception.DemoException;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private  final  static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof DemoException){
            DemoException demoException = (DemoException) e;
            return  ResultUtil.error(demoException.getCode(),demoException.getMessage());
        }else {
            logger.error("[系统异常]",e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
