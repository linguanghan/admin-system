package org.spring.springboot.service;

import org.spring.springboot.domain.yldres.AppInfoConfig;

import java.util.List;

public interface AppInfoConfigService {
    List<AppInfoConfig> findAll();
    AppInfoConfig findById(Integer id);
    Integer save(AppInfoConfig appInfoConfig);
    void deleteById(Integer id);

    Integer update(AppInfoConfig appInfoConfig);
}
