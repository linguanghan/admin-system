package org.spring.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import org.spring.springboot.common.enums.ChannelEnum;
import org.spring.springboot.dao.yldres.PageEventTrackLogDao;
import org.spring.springboot.domain.yldres.page.PageEventTrackLogPO;
import org.spring.springboot.domain.yldres.page.PageEventTrackLogQuery;
import org.spring.springboot.domain.yldres.page.PageEventTrackLogVO;
import org.spring.springboot.service.PageEventTrackLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-08-13 15:47
 */
@Service
public class PageEventTrackLogServiceImpl implements PageEventTrackLogService {

    @Resource
    private PageEventTrackLogDao pageEventTrackLogDao;

    @Override
    public List<PageEventTrackLogVO> searchPageEventTrackLogByPage(PageEventTrackLogQuery pageEventTrackLogQuery) {
        if(pageEventTrackLogQuery == null) {
            return Collections.emptyList();
        }
        List<PageEventTrackLogPO> pageEventTrackLogPOS = pageEventTrackLogDao.searchPageEventTrackLogByPage(pageEventTrackLogQuery);
        if(CollectionUtils.isEmpty(pageEventTrackLogPOS)) {
            return Collections.emptyList();
        }
        return pageEventTrackLogPOS.stream().map(pageEventTrackLogPO -> {
            PageEventTrackLogVO pageEventTrackLogVO = new PageEventTrackLogVO();
            BeanUtils.copyProperties(pageEventTrackLogPO, pageEventTrackLogVO, "createTime");
            Long createTime = pageEventTrackLogPO.getCreateTime();
            pageEventTrackLogVO.setCreateTime(new Date(createTime));
            return pageEventTrackLogVO;
        }).collect(Collectors.toList());
    }

    @Override
    public Integer searchPageEventTrackLogByPageCount(PageEventTrackLogQuery pageEventTrackLogQuery){
        if(pageEventTrackLogQuery == null) {
            return 0;
        }
        return pageEventTrackLogDao.searchPageEventTrackLogByPageCount(pageEventTrackLogQuery);
    }


    @Override
    public long savePageEventTrackLog(String log) {
        if(log == null) {
            return 0;
        }
        PageEventTrackLogPO pageEventTrackLogPO = new PageEventTrackLogPO();
        pageEventTrackLogPO.setLogContent(log);
        pageEventTrackLogPO.setCreateTime(DateUtil.current());
        pageEventTrackLogPO.setChannel(ChannelEnum.APP.getCode());
        pageEventTrackLogDao.savePageEventTrackLog(pageEventTrackLogPO);
        return pageEventTrackLogPO.getId();
    }
}
