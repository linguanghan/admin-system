package org.spring.springboot.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.playerext.PictureBookDailyRecharge;
import org.spring.springboot.domain.pelbsData.playerext.PlayerExtQuery;
import org.spring.springboot.domain.pelbsData.playerext.PlayerExtVO;
import org.spring.springboot.service.PlayerExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-12-03 14:44
 */
@RestController
@RequestMapping("/playerExt")
public class PlayerExtController {

    private static final Logger logger = LoggerFactory.getLogger(PlayerExtController.class);

    @Autowired
    private PlayerExtService playerExtService;

    @RequestMapping(value = "/getPictureBookDailyRecharges", method = RequestMethod.POST)
    public Result<?> GET_PICTURE_BOOK_DAILY_RECHARGES() {
//        List<PictureBookDailyRecharge> pictureBookDailyRecharges = playerExtService.GET_PICTURE_BOOK_DAILY_RECHARGES();
//        return ResponseEntity.ok(pictureBookDailyRecharges);
        try {
            List<PictureBookDailyRecharge> pictureBookDailyRecharges = playerExtService.GET_PICTURE_BOOK_DAILY_RECHARGES();
            if (CollectionUtils.isEmpty(pictureBookDailyRecharges)) {
                return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
            }
            return Result.buildSuccess().add("data", pictureBookDailyRecharges);
        } catch (Exception e) {
            logger.error("PlayerExtController#GET_PICTURE_BOOK_DAILY_RECHARGES error", e);
            return Result.buildFailure(SysCodeEnum.SysError);
        }
    }

    @RequestMapping("/queryPlayerExt")
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
