package org.spring.springboot.domain.yldres.app;

import java.util.Date;

public class AppInfoConfig {
    private Long id;
    private Integer packageIdx;
    private String appName;
    private String registrationNum;
    private String companyName;
    private String packagePara;
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

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPackagePara() {
        return packagePara;
    }

    public void setPackagePara(String packagePara) {
        this.packagePara = packagePara;
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
                ", registrationNum='" + registrationNum + '\'' +
                ", companyName='" + companyName + '\'' +
                ", packagePara='" + packagePara + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
