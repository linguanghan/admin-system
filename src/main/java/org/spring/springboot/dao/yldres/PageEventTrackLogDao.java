package org.spring.springboot.dao.yldres;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogPO;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogQuery;
import org.spring.springboot.domain.yldres.page.PageEventTrackLogPO;
import org.spring.springboot.domain.yldres.page.PageEventTrackLogQuery;

import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-08-13 15:42
 */
public interface PageEventTrackLogDao {

    List<PageEventTrackLogPO> searchPageEventTrackLogByPage(PageEventTrackLogQuery pageEventTrackLogQuery);

    Integer searchPageEventTrackLogByPageCount(PageEventTrackLogQuery pageEventTrackLogQuery);

    void savePageEventTrackLog(PageEventTrackLogPO pageEventTrackLogPO);

}
