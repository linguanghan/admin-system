package org.spring.springboot.bean;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-03 10:51
 */
@Data
public class Option {
    /**
     * 前端用于展示label
     */
    private String label;

    /**
     * 端用于展示value
     */
    private String value;
}
