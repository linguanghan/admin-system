package org.spring.springboot.dao.yldres;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.res.Bookresource;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogPO;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogQuery;

import java.util.List;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-16 21:53
 */
public interface FuncBundleVersionLogDao {
    List<FuncBundleVersionLogPO> searchFuncBundleVersionLogByKeyWord(FuncBundleVersionLogQuery funcBundleVersionLogQuery);

    Integer searchFuncBundleVersionLogByKeyWordCount(FuncBundleVersionLogQuery funcBundleVersionLogQuery);

    Integer updateFuncBundleVersionLog(FuncBundleVersionLogPO bookInfo);

    Integer deleteFuncBundleVersionLog(@Param("id") Long id);

    void saveFuncBundleVersionLog(FuncBundleVersionLogPO bookInfo);

    FuncBundleVersionLogPO searchFuncBundleVersionLogByIdx(@Param("idx") Long idx);
}
