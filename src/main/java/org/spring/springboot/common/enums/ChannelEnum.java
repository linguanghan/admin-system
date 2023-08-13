package org.spring.springboot.common.enums;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-08-13 19:05
 */
public enum ChannelEnum {

    APP(0, "APP");

    private Integer code;
    private String msg;

    ChannelEnum() {
    }

    ChannelEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
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
}
