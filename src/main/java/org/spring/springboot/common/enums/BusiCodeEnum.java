package org.spring.springboot.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum BusiCodeEnum {

    PARAM_ERROR("1", "参数错误"),

    BUSINESS_ERROR("2", "业务异常"),

    LOGIN_ERROR("3", "未登录，请重新登录！"),

    REGISTER_ERROR("4", "注册失败"),

    LOGIN_OUT_OF_TIME("5", "登录过期，请重新登录！");
    private String code;
    private String msg;


    private static Map<String, BusiCodeEnum>  busiCodeEnumMap = new HashMap<>();

    static {
        for (BusiCodeEnum value : BusiCodeEnum.values()) {
            busiCodeEnumMap.put(value.getCode(), value);
        }
    }

    public static BusiCodeEnum getBusiCodeEnum(String code) {
        return busiCodeEnumMap.get(code);
    }

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
