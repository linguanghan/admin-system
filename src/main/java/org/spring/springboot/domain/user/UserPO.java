package org.spring.springboot.domain.user;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 16:15
 */
@Data
public class UserPO {
    /**
     * id自增主键
     */
    private Integer id;
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
    /**
     * 登录时间
     */
    private Integer loginTime;
}
