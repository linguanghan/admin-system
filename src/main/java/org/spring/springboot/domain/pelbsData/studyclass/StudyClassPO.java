package org.spring.springboot.domain.pelbsData.studyclass;

import java.io.Serializable;

public class StudyClassPO implements Serializable {

    private static final long serialVersionUID = 8981725895832021034L;
    private String userName;
    private String className;
    private int classNumber;
    private String studentInfo;

    // Getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public String getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(String studentInfo) {
        this.studentInfo = studentInfo;
    }

    // toString method for debugging or logging
    @Override
    public String toString() {
        return "StudyClassPO{" +
                "userName='" + userName + '\'' +
                ", className='" + className + '\'' +
                ", classNumber=" + classNumber +
                ", studentInfo='" + studentInfo + '\'' +
                '}';
    }
}
