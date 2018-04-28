package com.example.demo.utils;

import com.example.demo.domain.Result;

public class ResultUtil {

    public  static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setDate(object);
        return  result;
    }
    public  static Result success(){
        return  success(null);
    }
    public  static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return  result;
    }
}
