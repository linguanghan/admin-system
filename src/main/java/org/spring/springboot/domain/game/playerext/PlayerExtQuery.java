package org.spring.springboot.domain.game.playerext;

import java.io.Serializable;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-12-03 13:50
 */
public class PlayerExtQuery implements Serializable {


    private static final long serialVersionUID = 991084978292793720L;
    /**
     * 玩家ID
     */
    private Long id;
    /**
     * 玩家ID
     */
    private Long accountID;

    /**
     * 页数
     */
    private Integer pageNo = 1;
    /**
     * 页大小
     */
    private Integer pageSize = 20;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

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
}
