package org.spring.springboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2024-03-03 14:47
 */
public enum AgentIdentityEnum {

    DEFAULT(0, "默认"),
    STUDENT(1, "学生"),
    TEACHER(2, "老师"),
    PARENT(3, "家长"),
    CLASS_TEACHER(4, "班主任");
    private Integer code;

    private String Desc;

    private static Map<Integer, AgentIdentityEnum> agentIdentityEnumMap = new HashMap<>();
    
    static {
        for (AgentIdentityEnum agentIdentityEnum : AgentIdentityEnum.values()) {
            agentIdentityEnumMap.put(agentIdentityEnum.getCode(), agentIdentityEnum);
        }
    }

    AgentIdentityEnum(Integer code, String desc) {
        this.code = code;
        Desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public static AgentIdentityEnum getAgentIdentityEnumByCode(Integer code) {
        if(code == null) {
            return null;
        }
        return agentIdentityEnumMap.get(code);
    }
}

