package org.spring.springboot.service;

import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.yldres.app.AppInfoConfig;
import org.spring.springboot.domain.yldres.app.AppInfoConfigQuery;

import java.util.List;

public interface AppInfoConfigService {
    List<AppInfoConfig> findAll();
    AppInfoConfig findById(Integer id);
    Integer save(AppInfoConfig appInfoConfig);
    Integer deleteById(Integer id);

    Integer update(AppInfoConfig appInfoConfig);

    Result<?> getList(AppInfoConfigQuery query);
}
