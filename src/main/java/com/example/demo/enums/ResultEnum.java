package com.example.demo.enums;

public enum ResultEnum {
    UNKONW_ERROE(-1,"位置错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"毛都没长齐"),
    MIDDLE_SCHOOL(101,"小嫩逼"),
    HIGH_SCHOOL(102,"加钱"),
    ;

    private Integer code;

    private  String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
