package org.spring.springboot.common.enums;

public enum BusiCodeEnum {

    PARAM_ERROR("1", "参数错误"),

    BUSINESS_ERROR("2", "业务异常"),

    LOGIN_ERROR("3", "登录失败"),

    REGISTER_ERROR("4", "注册失败"),

    LOGIN_OUT_OF_TIME("5", "登录过期，请重新登录");
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    BusiCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
