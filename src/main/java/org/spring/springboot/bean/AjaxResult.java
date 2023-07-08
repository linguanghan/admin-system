package org.spring.springboot.bean;

/**
 * 统一返回
 *
 * @Author : zhoubin
 * @Date : 2022-12-27 16:03
 */
public class AjaxResult {
    private static final Integer SUCCESS =0;
    private static final Integer FAILURE =1;
    private static final Integer FAILURE_WARN =2;
    private static final Integer ERROR =3;

    private static final String SUCCESS_MSG ="success";
    private static final String FAIL_MSG ="fail";

    private int code;
    private Object data;
    private String message;

    public AjaxResult() {
    }

    public AjaxResult(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static AjaxResult successResult(Object data){
        AjaxResult result = new AjaxResult();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }

    public static AjaxResult emptySuccessResult(){
        AjaxResult result = new AjaxResult();
        result.setCode(SUCCESS);
        result.setData(SUCCESS_MSG);
        return result;
    }

    public static AjaxResult failResult(){
        AjaxResult result = new AjaxResult();
        result.setCode(FAILURE);
        result.setData(FAIL_MSG);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
