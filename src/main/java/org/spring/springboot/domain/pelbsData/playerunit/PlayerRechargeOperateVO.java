package org.spring.springboot.domain.pelbsData.playerunit;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-03 17:15
 */
@Data
public class PlayerRechargeOperateVO {

    /**
     * 原始账号
     */
    private Long originPid;

    /**
     * 目标账号
     */
    private Long targetPid;
    /**
     * 书本编号
     */
    private Integer bookIdx;
}
