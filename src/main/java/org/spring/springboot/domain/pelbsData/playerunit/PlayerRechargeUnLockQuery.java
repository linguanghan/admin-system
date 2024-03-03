package org.spring.springboot.domain.pelbsData.playerunit;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-10 13:13
 */
@Data
public class PlayerRechargeUnLockQuery {
    /**
     * 角色ID[用户账号]
     */
    private Long id;
    /**
     * 是否解锁
     */
    private Integer unlock;
}
