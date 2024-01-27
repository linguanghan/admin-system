package org.spring.springboot.domain.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户基本信息
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 15:38
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserToken implements Serializable {

    private static final long serialVersionUID = -8181889880322807719L;

    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;

}
