package org.spring.springboot.common.enums;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-08-05 11:23
 */
public enum RoleEnum {
    MANAGER(0, "客服"),
    ADMIN(1, "管理员");
    private Integer code;

    private String Desc;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    RoleEnum() {
    }

    RoleEnum(Integer code, String desc) {
        this.code = code;
        Desc = desc;
    }
}
