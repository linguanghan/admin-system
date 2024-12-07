package org.spring.springboot.dao.yldres;

import org.spring.springboot.domain.yldres.AppInfoConfig;

import java.util.List;

public interface AppInfoConfigDao {

    Integer insert(AppInfoConfig appInfoConfig);

    AppInfoConfig selectById(Integer id);

    List<AppInfoConfig> selectAll();

    Integer update(AppInfoConfig appInfoConfig);

    Integer deleteById(Integer id);
}
