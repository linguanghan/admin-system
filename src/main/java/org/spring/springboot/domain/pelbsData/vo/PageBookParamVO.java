package org.spring.springboot.domain.pelbsData.vo;

import java.io.Serializable;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-09 8:52
 */
public class PageBookParamVO implements Serializable {

    private static final long serialVersionUID = -7709807902974099062L;
    /**
     * 当前页
     */
    private Integer pageNo = 1;
    /**
     * 页码
     */
    private Integer pageSize = 20;
    /**
     * 书本名称
     */
    private String bookName;
    /**
     * 书本编号
     */
    private String bookId;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
