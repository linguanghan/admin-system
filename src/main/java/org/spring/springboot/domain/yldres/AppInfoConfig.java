package org.spring.springboot.domain.yldres;

import java.util.Date;

public class AppInfoConfig {
    private Long id;
    private Integer packageIdx;
    private String appName;
    private String recordNumber;
    private String companyName;
    private String bookParam;
    private Date createTime;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPackageIdx() {
        return packageIdx;
    }

    public void setPackageIdx(Integer packageIdx) {
        this.packageIdx = packageIdx;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBookParam() {
        return bookParam;
    }

    public void setBookParam(String bookParam) {
        this.bookParam = bookParam;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AppInfoConfig{" +
                "id=" + id +
                ", packageIdx=" + packageIdx +
                ", appName='" + appName + '\'' +
                ", recordNumber='" + recordNumber + '\'' +
                ", companyName='" + companyName + '\'' +
                ", bookParam='" + bookParam + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
