package org.spring.springboot.domain.pelbsData.studyclass;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class StudyClassVO {
    private String userName;
    private String className;
    private int classNumber;
    private int studentNumber;

    public static List<StudyClassVO> convertFromPOList(List<StudyClassPO> studyClassPOList) {
        List<StudyClassVO> studyClassVOList = new ArrayList<>();

        for (StudyClassPO po : studyClassPOList) {
            StudyClassVO vo = new StudyClassVO();
            vo.setUserName(po.getUserName());
            vo.setClassName(po.getClassName());
            vo.setClassNumber(po.getClassNumber());

            // 解析学生数量
            int studentNumber = parseStudentNumber(po.getStudentInfo());
            vo.setStudentNumber(studentNumber);

            studyClassVOList.add(vo);
        }

        return studyClassVOList;
    }

    private static int parseStudentNumber(String studentInfoJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(studentInfoJson);
            int studentCount = 0;
            for (JsonNode node : rootNode) {
                JsonNode positionNode = node.get("position");
                if (positionNode != null && positionNode.asInt() == 1) {
                    studentCount++;
                }
            }
            return studentCount;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
