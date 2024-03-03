package org.spring.springboot.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.playerext.PlayerExtQuery;
import org.spring.springboot.domain.pelbsData.playerext.PlayerExtVO;
import org.spring.springboot.service.PlayerExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-12-03 14:44
 */
@RestController
@RequestMapping("playerExt")
public class PlayerExtController {

    private static final Logger logger = LoggerFactory.getLogger(PlayerExtController.class);

    @Autowired
    private PlayerExtService playerExtService;

    @RequestMapping("queryPlayerExt")
    public Result<?> queryPlayerExt(PlayerExtQuery playerExtQuery) {
        if(playerExtQuery == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            List<PlayerExtVO> playerExtVOS = playerExtService.queryPlayerExtVOs(playerExtQuery);
            long count = playerExtService.countPlayerExtVOs(playerExtQuery);
            return Result.buildSuccess().add("data", playerExtVOS).add("total", count);
        }catch (Exception e) {
            logger.error("PlayerExtController#queryPlayerExt error playerExtQuery:{}", JSON.toJSONString(playerExtQuery), e);
            return Result.buildFailure(SysCodeEnum.SysError);
        }

    }
}
