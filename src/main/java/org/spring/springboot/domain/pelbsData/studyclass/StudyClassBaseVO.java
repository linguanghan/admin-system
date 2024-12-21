package org.spring.springboot.domain.pelbsData.studyclass;

import lombok.Data;

@Data
public class StudyClassBaseVO implements java.io.Serializable {
    private static final long serialVersionUID = 472121258760262594L;
    private Long id;
    private Integer classInviteID;
    private Integer classNumber;
    private String teacherName;
    private String schoolName;
    private Integer grade;
    private Integer state;
    private String createTime;
    private Long ownerPid;
    private String memData;
}
