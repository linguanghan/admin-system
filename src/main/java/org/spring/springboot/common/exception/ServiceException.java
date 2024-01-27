package org.spring.springboot.common.exception;

import lombok.Getter;
import org.spring.springboot.common.enums.BusiCodeEnum;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 22:48
 */
@Getter
public class ServiceException extends RuntimeException{

    private String code;

    /**
     * 使用已有的错误类型
     * @param busiCodeEnum 枚举类中的错误类型
     */
    public ServiceException(BusiCodeEnum busiCodeEnum){
        super(busiCodeEnum.getMsg());
        this.code = busiCodeEnum.getCode();
    }

    /**
     * 自定义错误类型
     * @param code 自定义的错误码
     * @param msg 自定义的错误提示
     */
    public ServiceException(String code, String msg){
        super(msg);
        this.code = code;
    }
}
