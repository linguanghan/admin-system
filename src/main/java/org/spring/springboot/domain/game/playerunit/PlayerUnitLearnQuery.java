package org.spring.springboot.domain.game.playerunit;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

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
     * id
     */
    private Long id;
    /**
     * 书本id
     */
    private Long pid;
    /**
     * 书本编号
     */
    private Integer bookIdx;
    /**
     * 书本编号(旧)
     */
    private Integer bookIdxOld;
    /**
     * 剩余使用时间 月
     */
    private Integer remainTime;
    /**
     * 学习时长（分钟）
     */
    private Integer learnTime;
    /**
     * 购买时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 书本类型
     */
    private Integer bookType;
    /**
     * 包编号
     */
    private Integer packageIdx;
}
