package org.spring.springboot.dao.yldres;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.yldres.app.AppInfoConfig;
import org.spring.springboot.domain.yldres.app.AppInfoConfigQuery;

import java.util.List;

public interface AppInfoConfigDao {

    Integer insert(AppInfoConfig appInfoConfig);

    AppInfoConfig selectById(Integer id);

    List<AppInfoConfig> selectAll();

    Integer update(AppInfoConfig appInfoConfig);

    Integer deleteById(Integer id);

    List<AppInfoConfig> queryPage(@Param("query") AppInfoConfigQuery query);
}
