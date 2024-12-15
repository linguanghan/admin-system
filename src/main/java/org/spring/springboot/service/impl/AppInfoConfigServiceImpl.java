package org.spring.springboot.service.impl;

import cn.hutool.core.collection.ListUtil;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.dao.yldres.AppInfoConfigDao;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassBasePO;
import org.spring.springboot.domain.yldres.app.AppInfoConfig;
import org.spring.springboot.domain.yldres.app.AppInfoConfigQuery;
import org.spring.springboot.service.AppInfoConfigService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class AppInfoConfigServiceImpl implements AppInfoConfigService {

    @Resource
    private AppInfoConfigDao appInfoConfigDao;

    @Override
    public List<AppInfoConfig> findAll() {
        return appInfoConfigDao.selectAll();
    }

    @Override
    public AppInfoConfig findById(Integer id) {
        return appInfoConfigDao.selectById(id);
    }

    @Override
    public Integer save(AppInfoConfig appInfoConfig) {
        appInfoConfig.setCreateTime(new Date());
        return appInfoConfigDao.insert(appInfoConfig);
    }

    @Override
    public Integer deleteById(Integer id) {
        return appInfoConfigDao.deleteById(id);
    }

    @Override
    public Integer update(AppInfoConfig appInfoConfig) {
        return appInfoConfigDao.update(appInfoConfig);
    }

    @Override
    public Result<?> getList(AppInfoConfigQuery query) {

        List<AppInfoConfig> result = appInfoConfigDao.queryPage(query);

        List<AppInfoConfig> page = ListUtil.page(query.getPageNo() - 1, query.getPageSize(), result);
        if (CollectionUtils.isEmpty(page)) {
            return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
        }
        return Result.buildSuccess().add("data", page).add("total", result.size());
    }
}
