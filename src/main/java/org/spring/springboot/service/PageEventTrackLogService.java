package org.spring.springboot.service;

import org.spring.springboot.domain.yldres.page.PageEventTrackLogQuery;
import org.spring.springboot.domain.yldres.page.PageEventTrackLogVO;

import java.util.List;

public interface PageEventTrackLogService {

    /**
     *
     * 分页查询埋点记录
     * @author 13540
     * @date 2023-08-13 15:47
     * @return java.util.List<org.spring.springboot.domain.yldres.page.PageEventTrackLogPO>
     */
    List<PageEventTrackLogVO> searchPageEventTrackLogByPage(PageEventTrackLogQuery pageEventTrackLogQuery);


    /**
     *
     * 分页查询埋点记录 总条数
     * @param pageEventTrackLogQuery
     * @author 13540
     * @date 2023-08-13 16:24 
     * @return java.lang.Integer
     */
    Integer searchPageEventTrackLogByPageCount(PageEventTrackLogQuery pageEventTrackLogQuery);
    
    /**
     *
     * 插入埋点记录
     * @author 13540
     * @date 2023-08-13 15:47 
     * @return void
     */
    long savePageEventTrackLog(String log);

}
