package org.spring.springboot.common.enums;

/**
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-08 10:18
 */
public enum SysCodeEnum {
    Success("0", "成功"),
    ParamError("1", "参数错误"),
    MethodNotExist("2", "方法不存在"),
    SysError("3", "系统异常"),
    BusinessError("4", "业务异常");
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

    SysCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
