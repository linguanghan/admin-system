package org.spring.springboot.service.impl;

import cn.hutool.core.collection.ListUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.dao.pelbsData.PlayervideoDao;
import org.spring.springboot.domain.pelbsData.Playervideo;
import org.spring.springboot.domain.pelbsData.vo.PageParamVo;
import org.spring.springboot.service.PlayervideoService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-15 14:55
 */
@Service
public class PalyervideoServiceImpl implements PlayervideoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PalyervideoServiceImpl.class);

    @Resource
    private PlayervideoDao playervidoDao;

    private static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String time_start_suffix = " 00:00:00";
    private static final String time_end_suffix = " 23:59:59";

    @Override
    public Integer findPlayvideoNum(Date dateTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        if (null == dateTime) {
            dateTime = new Date();
        }
        String t = df.format(dateTime);
        String substring = t.substring(0, 10);
        String e = substring + time_end_suffix;
        t = substring + time_start_suffix;
        long start = 0;
        long end = 0;
        try {
            start = df.parse(t).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playervidoDao.findNumBetweenDate(start, end);
    }

    @Override
    public Integer findNumBetweenDate(Date startTime, Date endTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String s = df.format(startTime);
        String e = df.format(endTime);
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playervidoDao.findNumBetweenDate(start, end);
    }

    @Override
    public List<Playervideo> findDetail(Date dateTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String e = df.format(dateTime);
        String substring = e.substring(0, 10);
        String s = substring + time_start_suffix;
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playervidoDao.findBetweenDate(start, end);
    }

    @Override
    public Result<?> findDetailBetweenDate(PageParamVo vo) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String t = df.format(vo.getStartTime());
        String e = df.format(vo.getEndTime());
        long start = 0;
        long end = 0;
        try {
            start = df.parse(t).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }
        List<Playervideo> playerVideos = playervidoDao.findBetweenDate(start, end);
        if(CollectionUtils.isEmpty(playerVideos)) {
            return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
        }
        List<Playervideo> playerVideoPage = ListUtil.page(vo.getPageNo() - 1, vo.getPageSize(), playerVideos);
        return Result.buildSuccess().add("data", playerVideoPage).add("total", playerVideos.size());
    }
}
