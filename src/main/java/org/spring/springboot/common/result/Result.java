package org.spring.springboot.common.result;

import org.spring.springboot.common.enums.BusiCodeEnum;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-08 10:17
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -5301664067165538826L;

    /**
     * 返回code
     */
    private String code = SysCodeEnum.Success.getCode();

    /**
     * 客户端判断是否调用成功标识
     */
    private Boolean success;

    /**
     * 返回的业务信息
     */
    private String errorMsg;

    /**
     * 业务码
     */
    private Integer busiCode;

    /**
     * 返回内容
     */
    private Map<String, Object> result = new HashMap<>();

    public Result() {
    }

    private Result(boolean isSuccess) {
        this.success = true;
        this.busiCode = Integer.parseInt(SysCodeEnum.Success.getCode());
        this.errorMsg = SysCodeEnum.Success.getMsg();
    }

    private Result(boolean isSuccess, SysCodeEnum sysCodeEnum) {
        if (isSuccess) {
            this.success = true;
            this.busiCode = Integer.parseInt(SysCodeEnum.Success.getCode());
            this.errorMsg = SysCodeEnum.Success.getMsg();
        } else {
            this.success = false;
            this.busiCode = Integer.parseInt(sysCodeEnum.getCode());
            this.errorMsg = sysCodeEnum.getMsg();
        }

    }

    private Result(boolean isSuccess, BusiCodeEnum busiCodeEnum) {
        if (isSuccess) {
            this.success = true;
            this.busiCode = Integer.parseInt(SysCodeEnum.Success.getCode());
            this.errorMsg = SysCodeEnum.Success.getMsg();
        } else {
            this.success = false;
            this.busiCode = Integer.parseInt(busiCodeEnum.getCode());
            this.errorMsg = busiCodeEnum.getMsg();
        }
    }

    private Result(boolean isSuccess, BusiCodeEnum busiCodeEnum, String errorMsg) {
        if (isSuccess) {
            this.success = true;
            this.busiCode = Integer.parseInt(SysCodeEnum.Success.getCode());
            this.errorMsg = SysCodeEnum.Success.getMsg();
        } else {
            this.success = false;
            this.busiCode = Integer.parseInt(busiCodeEnum.getCode());
            this.errorMsg = StringUtils.isEmpty(errorMsg) ? busiCodeEnum.getMsg() : errorMsg;
        }
    }


    public static <T> Result<T> buildSuccess() {
        return new Result<>(true);
    }

    public static <T> Result<T> buildFailure() {
        return new Result<>(false);
    }

    public static <T> Result<T> buildFailure(SysCodeEnum sysCodeEnum) {
        return new Result<>(false, sysCodeEnum);
    }

    public static <T> Result<T> buildFailure(BusiCodeEnum busiCodeEnum) {
        return new Result<>(false, busiCodeEnum);
    }

    public static <T> Result<T> buildFailure(BusiCodeEnum busiCodeEnum, String errorMsg) {
        return new Result<>(false, busiCodeEnum, errorMsg);
    }

    public static <T> Result<T> buildServiceFailure(BusiCodeEnum busiCodeEnum, String errorMsg) {
       return new Result<T>(false, busiCodeEnum, errorMsg).setCode("3");
    }

    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(Integer busiCode) {
        this.busiCode = busiCode;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public Result<T> add(String key, Object value) {
        result.put(key, value);
        return this;
    }
}
