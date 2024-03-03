package org.spring.springboot.domain.pelbsData.playerunit;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-17 15:12
 */
@Data
public class PlayerUnitQuery {
    /**
     * 书本id
     */
    private Long pid;

    /**
     * 渠道
     */
    private Integer channel;

    /**
     * 包编号
     */
    private Integer packageIdx;
    /**
     * 书本编号
     */
    private Integer bookIdx;
    /**
     * 对应年级
     */
    private Integer bookType;
    /**
     * 剩余使用时间 月
     */
    private Integer remainTime;
}
