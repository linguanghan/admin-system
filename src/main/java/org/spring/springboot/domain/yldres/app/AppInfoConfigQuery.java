package org.spring.springboot.domain.yldres.app;

import lombok.Data;

import java.io.Serializable;

@Data
public class AppInfoConfigQuery implements Serializable {
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
     * 包编号
     */
    private Integer packageIdx;
    /**
     * 应用名称
     */
    private String appName;
}
