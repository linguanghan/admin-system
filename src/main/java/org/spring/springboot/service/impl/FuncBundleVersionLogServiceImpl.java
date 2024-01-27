package org.spring.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import org.spring.springboot.dao.yldres.FuncBundleVersionLogDao;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogPO;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogQuery;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogVO;
import org.spring.springboot.service.FuncBundleVersionLogService;
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
 * @date 2023-07-29 13:05
 */
@Service
public class FuncBundleVersionLogServiceImpl implements FuncBundleVersionLogService {

    @Resource
    private FuncBundleVersionLogDao funcBundleVersionLogDao;

    @Override
    public List<FuncBundleVersionLogVO> searchFuncBundleVersionLogByKeyWord(FuncBundleVersionLogQuery funcBundleVersionLogQuery){
        if(funcBundleVersionLogQuery == null){
            return Collections.emptyList();
        }

        List<FuncBundleVersionLogPO> funcBundleVersionLogPOS = funcBundleVersionLogDao.searchFuncBundleVersionLogByKeyWord(funcBundleVersionLogQuery);
        if(CollectionUtils.isEmpty(funcBundleVersionLogPOS)) {
            return Collections.emptyList();
        }
        return funcBundleVersionLogPOS.stream().map(funcBundleVersionLogPO -> {
            FuncBundleVersionLogVO funcBundleVersionLogVO = new FuncBundleVersionLogVO();
            BeanUtils.copyProperties(funcBundleVersionLogPO, funcBundleVersionLogVO);
            return funcBundleVersionLogVO;
        }).collect(Collectors.toList());

    }

    @Override
    public Integer searchFuncBundleVersionLogByKeyWordCount(FuncBundleVersionLogQuery funcBundleVersionLogQuery) {
        return funcBundleVersionLogDao.searchFuncBundleVersionLogByKeyWordCount(funcBundleVersionLogQuery);
    }


    @Override
    public boolean updateFuncBundleVersionLog(FuncBundleVersionLogVO funcBundleVersionLogVO) {
        if(funcBundleVersionLogVO == null) {
            return false;
        }
        FuncBundleVersionLogPO funcBundleVersionLogPO = new FuncBundleVersionLogPO();
        BeanUtils.copyProperties(funcBundleVersionLogVO, funcBundleVersionLogPO);
        String updateTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        funcBundleVersionLogPO.setUpdateTime(updateTime);
        Integer update = funcBundleVersionLogDao.updateFuncBundleVersionLog(funcBundleVersionLogPO);
        return update != null && update > 0;
    }

    @Override
    public boolean deleteFuncBundleVersionLog(Long id) {
        Integer delete = funcBundleVersionLogDao.deleteFuncBundleVersionLog(id);
        return delete != null && delete > 0;
    }

    @Override
    public boolean saveFuncBundleVersionLog(FuncBundleVersionLogVO funcBundleVersionLogVO) {
        if(funcBundleVersionLogVO == null) {
            return false;
        }
        FuncBundleVersionLogPO funcBundleVersionLogPO = new FuncBundleVersionLogPO();
        BeanUtils.copyProperties(funcBundleVersionLogVO, funcBundleVersionLogPO);
        String createTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        funcBundleVersionLogPO.setCreateTime(createTime);
        funcBundleVersionLogDao.saveFuncBundleVersionLog(funcBundleVersionLogPO);
        return funcBundleVersionLogPO.getId() != null && funcBundleVersionLogPO.getId() > 0;
    }

    @Override
    public FuncBundleVersionLogVO searchFuncBundleVersionLogByIdx(Long idx){
        if(idx == null) {
            return null;
        }
        FuncBundleVersionLogPO funcBundleVersionLogPO = funcBundleVersionLogDao.searchFuncBundleVersionLogByIdx(idx);
        FuncBundleVersionLogVO funcBundleVersionLogVO = new FuncBundleVersionLogVO();
        BeanUtils.copyProperties(funcBundleVersionLogPO, funcBundleVersionLogVO);
        return funcBundleVersionLogVO;
    }
}
