package org.spring.springboot.domain.yldres.page;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-08-13 15:35
 */
@Data
public class PageEventTrackLogPO {

    /**
     * 自增主鍵
     */
    private Long id;
    /**
     * 埋点内容
     */
    private String logContent;
    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 渠道
     */
    private Integer channel;


}
