package org.spring.springboot.controller;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordQuery;
import org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordVO;
import org.spring.springboot.service.OperateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * 操作记录
 * @author 13540
 * @version 1.0
 * @date 2023-09-24 14:37
 */
@RestController
@RequestMapping("/operateRecord")
public class OperateRecordCtrl {


    private static final Logger LOGGER = LoggerFactory.getLogger(OperateRecordCtrl.class);

    @Autowired
    private OperateRecordService operateRecordService;

    /**
     *
     * 查询转移记录（分页）
     * @author 13540
     * @date 2023-09-24 16:08 
     * @return org.spring.springboot.common.result.Result<?>
     */
    @RequestMapping("/queryChangeRechargeRecord")
    public Result<?> queryChangeRechargeRecord(ChangeRechargeRecordQuery query) {
        if(query == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            List<ChangeRechargeRecordVO> changeRechargeRecordVOS = operateRecordService.queryChangeRechargeRecord(query);
            if(CollectionUtils.isEmpty(changeRechargeRecordVOS)) {
                return Result.buildSuccess().add("data", Collections.emptyList()).add("total", 0);
            }
            List<ChangeRechargeRecordVO> page = ListUtil.page(query.getPageNo() - 1, query.getPageSize(), changeRechargeRecordVOS);
            return Result.buildSuccess().add("data", page).add("total", changeRechargeRecordVOS.size());
        } catch (Exception e) {
            LOGGER.error("OperateRecordCtrl#queryChangeRechargeRecord error, query:{}", JSONUtil.toJsonStr(query), e);
        }

        return Result.buildFailure(SysCodeEnum.BusinessError);
    }
}
