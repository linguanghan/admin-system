package org.spring.springboot.domain.pelbsData.playerunit;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-03 10:32
 */
@Getter
@Setter
public class PlayerRechargeQuery {
    /**
     * 角色ID[用户账号]
     */
    private Long pid;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 购买时间=>开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    /**
     * 购买时间=>结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
    /**
     * 当前页
     */
    private Integer pageNo = 1;
    /**
     *
     * 起始數據
     */
    private Integer startRow;
    /**
     * 页码
     */
    private Integer pageSize = 20;


    public Integer getStartRow() {
        this.startRow = (pageNo - 1) * pageSize;
        return startRow;
    }

    /**
     * 下单时间
     */
    private Long orderTime;
    /**
     * 是否解锁
     */
    private Integer unlock;
}
