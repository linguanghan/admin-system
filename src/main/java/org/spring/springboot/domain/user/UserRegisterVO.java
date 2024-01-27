package org.spring.springboot.domain.user;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 20:32
 */
@Data
public class UserRegisterVO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色
     */
    private Integer role;
    /**
     * 手机号
     */
    private String phone;
}
