/**
 * @projectName: admin-system
 * @package: org.spring.springboot.controller
 * @className: PlayerManagementCtrl
 * @author: Chen Dehong
 * @description: 玩家管理接口
 * @date: 2/5/2024 12:04 PM
 * @version: 1.0
 */
package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.vo.PagePlayerParamVO;
import org.spring.springboot.domain.pelbsData.PlayerManagement;
import org.spring.springboot.service.PlayerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("player/management")
public class PlayerManagementCtrl {
    private static final Logger logger = LoggerFactory.getLogger(PlayerManagementCtrl.class);
    @Autowired
    private PlayerManagementService playerManagementService;

    // 查询玩家列表
    @RequestMapping(value = "/list")
    public Result<?> findPlayerlist(PagePlayerParamVO vo) {
        try {
            logger.info("PlayerManagementCtrl#findPlayerlist vo is{}", JSONUtil.toJsonStr(vo));
            return playerManagementService.fetchList(vo);
        }catch (Exception e) {
            logger.error("PlayerManagementCtrl#findPlayerlist error vo is{}", JSONUtil.toJsonStr(vo), e);
            return Result.buildFailure(SysCodeEnum.SysError);
        }
    }

    // 查询玩家列表--按名称搜索
    @RequestMapping(value = "/list/name", method = RequestMethod.GET)
    public AjaxResult findPlayerlistByname(String name) {
        return AjaxResult.successResult(playerManagementService.fetchListByName(name));
    }

    // 查询玩家列表--按编号搜索
    @RequestMapping(value = "/list/playerId", method = RequestMethod.GET)
    public AjaxResult findPlayerlistByPlayerId(String playerId) {
        return AjaxResult.successResult(playerManagementService.fetchListByPlayerId(playerId));
    }

    // 查询玩家列表--按编号或名称搜索
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public AjaxResult searchPlayerlist(String name,String playerId,String keyword) {
        return AjaxResult.successResult(playerManagementService.searchPlayerlist(name,playerId,keyword));
    }

    // 编辑玩家信息
    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    public AjaxResult updatePlayerInfo(@RequestBody PlayerManagement playerManagement) {
        playerManagementService.updatePlayerInfo(playerManagement);
        return AjaxResult.emptySuccessResult();
    }

    // 删除玩家信息
    @RequestMapping(value = "/del/info", method = RequestMethod.POST)
    public AjaxResult deletePlayerInfo(@RequestBody PlayerManagement playerManagement) {
        playerManagementService.deletePlayerInfo(playerManagement);
        return AjaxResult.emptySuccessResult();
    }

    // 添加玩家信息
    @RequestMapping(value = "/save/info", method = RequestMethod.POST)
    public AjaxResult savePlayerManagementInfo(@RequestBody PlayerManagement playerManagement) {
        playerManagementService.savePlayerManagementInfo(playerManagement);
        return AjaxResult.emptySuccessResult();
    }

    // 获取玩家信息
    @RequestMapping(value = "/queryPlayerManagementOption", method = RequestMethod.GET)
    public Result<?> queryPlayerManagementOption() {
        try {
            return Result.buildSuccess().add("data", playerManagementService.queryPlayerResourceOptions());
        }catch (Exception e) {
            logger.error("PlayerManagementCtrl#queryPlayerManagementOption error", e);
        }
        return Result.buildFailure();
    }

}
