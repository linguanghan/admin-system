package org.spring.springboot.service;

import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogPO;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogQuery;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogVO;

import java.util.List;

public interface FuncBundleVersionLogService {

    List<FuncBundleVersionLogVO> searchFuncBundleVersionLogByKeyWord(FuncBundleVersionLogQuery funcBundleVersionLogQuery);


    Integer searchFuncBundleVersionLogByKeyWordCount(FuncBundleVersionLogQuery funcBundleVersionLogQuery);

    boolean updateFuncBundleVersionLog(FuncBundleVersionLogVO funcBundleVersionLogVO);

    boolean deleteFuncBundleVersionLog(Long id);

    boolean saveFuncBundleVersionLog(FuncBundleVersionLogVO funcBundleVersionLogVO);

    FuncBundleVersionLogVO searchFuncBundleVersionLogByIdx(Long idx);

}
