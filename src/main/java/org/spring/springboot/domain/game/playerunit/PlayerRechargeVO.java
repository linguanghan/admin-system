package org.spring.springboot.domain.game.playerunit;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-03 10:37
 */
@Data
public class PlayerRechargeVO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 角色ID[用户账号]
     */
    private Long pid;
    /**
     * 书本编号
     */
    private Integer bookIdx;
    /**
     * 书本名称
     */
    private String bookName;
    /**
     * 书本类型
     */
    private Integer bookType;
    /**
     * 书本类型
     */
    private Integer packageIdx;
    /**
     * 购买时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 是否锁住 1=>解锁 、 0=>锁住
     */
    private Integer unlock;
    /**
     * 用户名
     */
    private String playerName;
    /**
     * 剩余使用时间 月
     */
    private String remainTime;
    /**
     * 剩余使用时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deadLineTime;
    /**
     * 学习时长(默认0)
     */
    private Integer totalTime;
    /**
     * 是否展示加解锁
     */
    private Integer unlockShow;

}
