package org.spring.springboot.domain.yldres.recharge;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-10 15:01
 */
@Data
public class ChangeRechargeRecordPO {
    /**
     * 自增id
     */
    private Long id;
    /**
     * 变更记录
     */
    private String changeInfo;
    /**
     * 具体sql操作
     */
    private String operateInfo;
    /**
     * 创建时间
     */
    private Long createTime;
}
