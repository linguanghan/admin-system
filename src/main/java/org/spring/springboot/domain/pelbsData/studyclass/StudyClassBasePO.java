package org.spring.springboot.domain.pelbsData.studyclass;

public class StudyClassBasePO implements java.io.Serializable {
    private static final long serialVersionUID = 472121258760262594L;
    private Long id;
    private Integer classInviteID;
    private Integer classNumber;
    private String teacherName;
    private String schoolName;
    private Integer grade;
    private Integer state;
    private Long createTime;
    private Long ownerPid;
    private String memData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClassInviteID() {
        return classInviteID;
    }

    public void setClassInviteID(Integer classInviteID) {
        this.classInviteID = classInviteID;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getOwnerPid() {
        return ownerPid;
    }

    public void setOwnerPid(Long ownerPid) {
        this.ownerPid = ownerPid;
    }

    public String getMemData() {
        return memData;
    }

    public void setMemData(String memData) {
        this.memData = memData;
    }
}
