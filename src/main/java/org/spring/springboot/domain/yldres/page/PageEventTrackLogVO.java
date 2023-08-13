package org.spring.springboot.domain.yldres.page;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-08-13 15:53
 */
@Data
public class PageEventTrackLogVO implements Serializable {

    private static final long serialVersionUID = -5149536235728993213L;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 渠道
     */
    private Integer channel;
}
