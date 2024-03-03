package org.spring.springboot.domain.pelbsData.playerunit;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-10 15:09
 */
@Data
public class ChangeRechargeOperateInfo {
    /**
     * 操作类型
     */
    private String operateType;
    /**
     * 操作对象
     */
    private Playerunit operateObj;
}
