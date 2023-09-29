package org.spring.springboot.service;

import org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordQuery;
import org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordVO;

import java.util.List;

public interface OperateRecordService {
   /**
    *
    * 查询账号转移记录
    * @author 13540
    * @date 2023-09-24 14:50 
    * @return java.util.List<org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordVO>
    */
   List<ChangeRechargeRecordVO> queryChangeRechargeRecord(ChangeRechargeRecordQuery query);
   
}
