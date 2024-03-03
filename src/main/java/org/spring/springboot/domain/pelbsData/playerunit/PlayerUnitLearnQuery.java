package org.spring.springboot.domain.pelbsData.playerunit;

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
     * 学习时长(Unit1)
     */
    private Integer learnTimeUnit1;
    /**
     * 学习时长(Unit2)
     */
    private Integer learnTimeUnit2;
    /**
     * 学习时长(Unit3)
     */
    private Integer learnTimeUnit3;
    /**
     * 学习时长(Unit4)
     */
    private Integer learnTimeUnit4;
    /**
     * 学习时长(Unit5)
     */
    private Integer learnTimeUnit5;
    /**
     * 学习时长(Unit6)
     */
    private Integer learnTimeUnit6;
    /**
     * 学习时长(Unit7)
     */
    private Integer learnTimeUnit7;
    /**
     * 学习时长(Unit8)
     */
    private Integer learnTimeUnit8;
    /**
     * 学习时长(Unit9)
     */
    private Integer learnTimeUnit9;
    /**
     * 学习时长(Unit10)
     */
    private Integer learnTimeUnit10;
    /**
     * 学习时长(Unit11)
     */
    private Integer learnTimeUnit11;
    /**
     * 学习时长(Unit12)
     */
    private Integer learnTimeUnit12;
    /**
     * 学习时长(Unit13)
     */
    private Integer learnTimeUnit13;
    /**
     * 学习时长(Unit14)
     */
    private Integer learnTimeUnit14;
    /**
     * 学习时长(Unit15)
     */
    private Integer learnTimeUnit15;
    /**
     * 学习时长(Unit16)
     */
    private Integer learnTimeUnit16;
    /**
     * 学习时长(Unit17)
     */
    private Integer learnTimeUnit17;
    /**
     * 学习时长(Unit18)
     */
    private Integer learnTimeUnit18;
    /**
     * 学习时长(Unit19)
     */
    private Integer learnTimeUnit19;
    /**
     * 学习时长(Unit20)
     */
    private Integer learnTimeUnit20;
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
