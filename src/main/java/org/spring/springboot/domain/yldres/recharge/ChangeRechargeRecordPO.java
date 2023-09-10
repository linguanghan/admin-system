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
    private Long id;

    private String changeInfo;

    private String operateInfo;

    private Long createTime;
}
