package org.spring.springboot.domain.yldres.recharge;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-24 12:28
 */
@Data
public class ChangeRechargeRecordQuery {
    /**
     * 转移账号
     */
    private Long originPid;
    /**
     * 目标账号
     */
    private Long targetPid;
    /**
     * 记录开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    /**
     * 记录结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    /**
     * 页码
     */
    private Integer pageNo = 1;
    /**
     * 页大小
     */
    private Integer pageSize = 10;

}
