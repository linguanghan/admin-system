package org.spring.springboot.dao.yldres;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordPO;
import java.util.List;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-16 21:53
 */
public interface ChangeRechargeRecordDao {


    /**
     * 插入操作记录
     * 
     * @author 13540
     * @date 2023-09-10 15:04 
     * @return void
     */
    void saveBookInfo(ChangeRechargeRecordPO changeRechargeRecordPO);


    List<ChangeRechargeRecordPO> queryChangeRechargeRecord(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
    

}
