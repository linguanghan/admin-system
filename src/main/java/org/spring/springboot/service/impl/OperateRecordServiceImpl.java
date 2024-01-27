package org.spring.springboot.service.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.json.JSONUtil;
import org.spring.springboot.dao.yldres.ChangeRechargeRecordDao;
import org.spring.springboot.domain.yldres.Bookresource;
import org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordPO;
import org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordQuery;
import org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordVO;
import org.spring.springboot.service.BookresourceService;
import org.spring.springboot.service.OperateRecordService;
import org.spring.springboot.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-24 14:50
 */
@Service
public class OperateRecordServiceImpl implements OperateRecordService {

    private static final String LENGTH_10 = "LENGTH_10";

    @Autowired
    private ChangeRechargeRecordDao changeRechargeRecordDao;

    @Autowired
    private BookresourceService bookresourceService;

    @Override
    public List<ChangeRechargeRecordVO> queryChangeRechargeRecord(ChangeRechargeRecordQuery query) {
        if(query.getOriginPid() == null && query.getTargetPid() == null && query.getStartTime() == null && query.getEndTime() == null) {
            return Collections.emptyList();
        }
        Long startTime = DateUtil.dateToTimeStamp(query.getStartTime(), LENGTH_10);
        Long endTime = DateUtil.dateToTimeStamp(query.getEndTime(), LENGTH_10);
        // 1、根据时间筛选
        List<ChangeRechargeRecordPO> changeRechargeRecordPOS = changeRechargeRecordDao.queryChangeRechargeRecord(startTime, endTime);
        List<ChangeRechargeRecordVO> playerRechargeOperateVOS = changeRechargeRecordPOS
                .stream()
                .map(changeRechargeRecordPO -> {
                    String changeInfo = changeRechargeRecordPO.getChangeInfo();
                    if (StringUtils.isEmpty(changeInfo)) {
                        return null;
                    }
                    ChangeRechargeRecordVO changeRechargeRecordVO = JSONUtil.toBean(changeInfo, ChangeRechargeRecordVO.class);
                    changeRechargeRecordVO.setCreateTime(new Date(changeRechargeRecordPO.getCreateTime() * 1000));
                    return changeRechargeRecordVO;
                }).filter(Objects::nonNull).collect(Collectors.toList());

        if(CollectionUtils.isEmpty(playerRechargeOperateVOS)) {
            return Collections.emptyList();
        }

        // 2、根据原账号筛选
        if(query.getOriginPid() != null) {
            playerRechargeOperateVOS = playerRechargeOperateVOS
                    .stream()
                    .filter(changeRechargeRecordVO -> query.getOriginPid().equals(changeRechargeRecordVO.getOriginPid()))
                    .collect(Collectors.toList());
        }
        // 3、根据目标账号筛选
        if(query.getTargetPid() != null) {
            playerRechargeOperateVOS = playerRechargeOperateVOS
                    .stream()
                    .filter(changeRechargeRecordVO -> query.getTargetPid().equals(changeRechargeRecordVO.getTargetPid()))
                    .collect(Collectors.toList());
        }
        return fillBookInfo(playerRechargeOperateVOS);
    }

    /**
     *
     * 填充书本基本信息
     * @author 13540
     * @date 2023-09-24 17:02 
     * @return java.util.List<org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordVO>
     */
    private List<ChangeRechargeRecordVO> fillBookInfo(List<ChangeRechargeRecordVO> changeRechargeRecordVOs) {
        List<Long> bookIds = changeRechargeRecordVOs
                .stream()
                .map(changeRechargeRecordVO -> {
                    Integer bookIdx = changeRechargeRecordVO.getBookIdx();
                    if(NumberUtil.isNumber(String.valueOf(bookIdx))) {
                        return Long.parseLong(String.valueOf(bookIdx));
                    }
                    return null;
                }).filter(Objects::nonNull)
                .collect(Collectors.toList());

        if(CollectionUtils.isEmpty(bookIds)) {
            return Collections.emptyList();
        }

        Map<Long, Bookresource> bookResourceMap = bookresourceService.fetchBookResourceByIds(bookIds);

        if(CollectionUtils.isEmpty(changeRechargeRecordVOs)) {
            return Collections.emptyList();
        }

        return changeRechargeRecordVOs.stream().map(changeRechargeRecordVO -> {
            Integer bookIdx = changeRechargeRecordVO.getBookIdx();
            if(!NumberUtil.isNumber(String.valueOf(bookIdx))) {
                return changeRechargeRecordVO;
            }

            Bookresource bookresource = bookResourceMap.get(Long.parseLong(String.valueOf(bookIdx)));
            if(bookresource != null && !StringUtils.isEmpty(bookresource.getName())) {
                changeRechargeRecordVO.setBookName(bookresource.getName());
            }
            return changeRechargeRecordVO;
        }).collect(Collectors.toList());
    }
}
