package org.spring.springboot.domain.pelbsData.studyclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudyClassQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    private Integer pageNo = 1;
    /**
     *
     * 起始数
     */
    private Integer startRow;
    /**
     * 每页大小
     */
    private Integer pageSize = 10;
    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
