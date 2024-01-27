package org.spring.springboot.domain.user;

import java.io.Serializable;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-08-05 10:59
 */
public class UserHolderParam implements Serializable {

    private static final long serialVersionUID = -1835834611768080220L;

    private String userName;

    private Integer role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
