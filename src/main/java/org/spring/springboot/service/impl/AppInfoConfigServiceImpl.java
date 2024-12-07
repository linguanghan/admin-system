package org.spring.springboot.service.impl;

import org.spring.springboot.dao.yldres.AppInfoConfigDao;
import org.spring.springboot.domain.yldres.AppInfoConfig;
import org.spring.springboot.service.AppInfoConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
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
        return appInfoConfigDao.insert(appInfoConfig);
    }

    @Override
    public void deleteById(Integer id) {
        appInfoConfigDao.deleteById(id);
    }

    @Override
    public Integer update(AppInfoConfig appInfoConfig) {
        return appInfoConfigDao.update(appInfoConfig);
    }
}
