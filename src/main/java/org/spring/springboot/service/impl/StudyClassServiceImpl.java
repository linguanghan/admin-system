package org.spring.springboot.service.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.dao.pelbsData.StudyClassDao;
import org.spring.springboot.domain.pelbsData.studyclass.*;
import org.spring.springboot.service.StudyClassService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
class StudyClassServiceImpl implements StudyClassService {
    @Autowired
    private StudyClassDao studyClassDao;

    @Override
    public List<StudyClassVO> CLASS_VO_LIST() {
        List<StudyClassPO> studyClassPOList = studyClassDao.selectStudyClass();
        return StudyClassVO.convertFromPOList(studyClassPOList);
    }

    @Override
    public Result<?> queryPage(StudyClassQuery query) {
//        long startTime = query.getStartTime().getTime();
//        long endTime = query.getEndTime().getTime();
//        List<StudyClassBasePO> studyClassVOS = studyClassDao.queryPage(startTime/1000, endTime/1000);
        List<StudyClassBasePO> studyClassVOS = studyClassDao.queryList(query);
        List<StudyClassBasePO> page = ListUtil.page(query.getPageNo() - 1, query.getPageSize(), studyClassVOS);
        if (CollectionUtils.isEmpty(page)) {
            return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
        }
        List<StudyClassBaseVO> result = page.stream().map(t -> {
            StudyClassBaseVO baseVO = new StudyClassBaseVO();
            BeanUtils.copyProperties(t, baseVO);
            Long createTime = t.getCreateTime();
            Instant instant = Instant.ofEpochSecond(createTime);

            // 使用系统默认时区
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = localDateTime.format(formatter);
            baseVO.setCreateTime(formattedDate);

            String memData = t.getMemData();
            if (memData != null) {
                Gson gson = new Gson();
                Type type = new TypeToken<Map<String, Map<String, Object>>>(){}.getType();
                Map<String, Map<String, Object>> memMap = gson.fromJson(memData, type);

                baseVO.setStudentCount(memMap == null ? 0 : memMap.size());
            }

            return baseVO;
        }).collect(Collectors.toList());
        return Result.buildSuccess().add("data", result).add("total", studyClassVOS.size());
    }

    @Override
    public Long createStudyClass(StudyClassBasePO studyClassDTO) {
        studyClassDTO.setState(0);
        studyClassDTO.setCreateTime(System.currentTimeMillis() / 1000);
        studyClassDTO.setMemData("");
        return studyClassDao.createStudyClass(studyClassDTO);
    }

    @Override
    public Long updateStudyClass(StudyClassBaseVO studyClassBaseVO) {
        StudyClassBasePO studyClassDTO = new StudyClassBasePO();
        BeanUtils.copyProperties(studyClassBaseVO, studyClassDTO);
        return studyClassDao.updateStudyClass(studyClassDTO);
    }

    @Override
    public Result<?> queryOne(Long id) {
        StudyClassBasePO studyClassPO = studyClassDao.selectStudyClassByID(id);
        return Result.buildSuccess().add("data", studyClassPO);
    }
}
