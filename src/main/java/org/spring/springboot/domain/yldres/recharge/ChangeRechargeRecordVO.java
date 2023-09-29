package org.spring.springboot.domain.yldres.recharge;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-10 15:01
 */
@Data
public class ChangeRechargeRecordVO {
    /**
     * 原始账号
     */
    private Long originPid;
    /**
     * 目标账号
     */
    private Long targetPid;
    /**
     * 转移时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 书本编号
     */
    private Integer bookIdx;
    /**
     * 书本名称
     */
    private String bookName;

}
