package org.spring.springboot.common.enums;

public enum BusiCodeEnum {

    ParamError("1", "参数错误"),

    LoginError("2", "登录失败"),

    RegisterError("3", "注册失败");
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
