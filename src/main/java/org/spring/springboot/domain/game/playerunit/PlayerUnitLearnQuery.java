package org.spring.springboot.domain.game.playerunit;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-17 15:12
 */
@Data
public class PlayerUnitLearnQuery {
    /**
     * 书本id
     */
    private Long pid;
    /**
     * 书本编号
     */
    private Integer bookIdx;
    /**
     * 剩余使用时间 月
     */
    private Integer remainTime;
    /**
     * 学习时长（分钟）
     */
    private Integer learnTime;
}
