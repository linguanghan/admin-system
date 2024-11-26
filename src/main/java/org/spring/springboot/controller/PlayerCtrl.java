package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.Player;
import org.spring.springboot.domain.pelbsData.vo.PageParamVo;
import org.spring.springboot.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 玩家接口
 *
 * @Author : zhoubin
 * @Date : 2022-12-22 15:28
 */
@RestController
@RequestMapping("player")
public class PlayerCtrl {
    private static final  Logger logger = LoggerFactory.getLogger(PlayerCtrl.class);
    @Autowired
    private PlayerService playerService;

    // 查询该日期注册人数
    @RequestMapping(value = "/register/num", method = RequestMethod.GET)
    public AjaxResult findRegisterNum(@RequestParam Date dateTime) {


        return AjaxResult.successResult(playerService.findRegisterNum(dateTime));
    }

    // 查询该日期范围注册人数
    @RequestMapping(value = "/register/rangedate/num", method = RequestMethod.GET)
    public AjaxResult findRegisterNumBetweenDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerService.findRegisterNumBetweenDate(startTime, endTime));
    }

    // 查询该日期注册人员详情
    @RequestMapping(value = "/register/detail", method = RequestMethod.GET)
    public AjaxResult findRegisterDetail(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playerService.findRegisterDetail(dateTime));
    }

    // 查询该日期范围注册人员详情
    @RequestMapping("/register/rangedate/detail")
    public Result<?> findRegisterDetailBetweenDate(PageParamVo vo) {
        if (vo == null
                || vo.getEndTime() == null
                || vo.getStartTime() == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            return playerService.findRegisterDetailBetweenDate(vo);
        } catch (Exception e) {
            logger.info("PlayerCtrl#findRegisterDetailBetweenDate error vo is {}", JSONUtil.toJsonStr(vo), e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);
    }

    // 查询该日期范围注册人数--按天归类
    @RequestMapping(value = "/register/num/day", method = RequestMethod.GET)
    public AjaxResult findRegisterNumGroupbyDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerService.findRegisterNumGroupbyDate(startTime, endTime));
    }

    // 查询该日期范围注册人数--按月归类
    @RequestMapping(value = "/register/num/month", method = RequestMethod.GET)
    public AjaxResult findRegisterNumGroupbyMonth(@RequestParam @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                                  @RequestParam @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        return AjaxResult.successResult(playerService.findRegisterNumGroupbyMonth(startTime, endTime));
    }

    /***************分隔线*******************/

    // 查询该日期活跃人数
    @RequestMapping(value = "/active/num", method = RequestMethod.GET)
    public AjaxResult findActiveNum(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playerService.findActiveNum(dateTime));
    }

    // 查询该日期范围活跃人数
    @RequestMapping(value = "/active/rangedate/num", method = RequestMethod.GET)
    public AjaxResult findActiveNumBetweenDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerService.findActiveNumBetweenDate(startTime, endTime));
    }

    // 查询该日期活跃人员详情
    @RequestMapping(value = "/active/detail", method = RequestMethod.GET)
    public AjaxResult findActiveDetail(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playerService.findActiveDetail(dateTime));
    }

    // 查询该日期范围活跃人员详情
    @RequestMapping(value = "/active/rangedate/detail")
    public Result<?> findActiveDetailBetweenDate(PageParamVo vo) {
        if (vo == null
                || vo.getEndTime() == null
                || vo.getStartTime() == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            return playerService.findActiveDetailBetweenDate(vo);
        } catch (Exception e) {
            logger.info("PlayerCtrl#findActiveDetailBetweenDate error vo is {}", JSONUtil.toJsonStr(vo), e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);
    }

    // 查询该日期范围活跃人数--按天归类
    @RequestMapping(value = "/active/num/day", method = RequestMethod.GET)
    public AjaxResult findActiveNumGroupbyDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerService.findActiveNumGroupbyDate(startTime, endTime));
    }

    // 查询该日期范围活跃人数--按月归类
    @RequestMapping(value = "/active/num/month", method = RequestMethod.GET)
    public AjaxResult findActiveNumGroupbyMonth(@RequestParam @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                                @RequestParam @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        return AjaxResult.successResult(playerService.findActiveNumGroupbyMonth(startTime, endTime));
    }

//    @RequestMapping(value = "/current", method = RequestMethod.GET)
//    public AjaxResult findPlyersCurrentNum() {
//        return AjaxResult.successResult(playerService.findPlyersCurrentNum(null));
//    }
//
//    @RequestMapping(value = "/history", method = RequestMethod.GET)
//    public Integer findPlyersHistoryNum(@RequestParam Date startTime, @RequestParam Date endTime) {
//        return playerService.findPlyersHistoryNum(startTime, endTime);
//    }
//
//    @RequestMapping(value = "/history30/days", method = RequestMethod.GET)
//    public AjaxResult findPlyersHistoryNumLast30Days() {
//        return AjaxResult.successResult(playerService.findPlyersHistoryNumLast30Days());
//    }
//
//    @RequestMapping(value = "/current/detail", method = RequestMethod.GET)
//    public AjaxResult findPlyersCurrentDetail(@RequestParam Date startTime) {
//        return AjaxResult.successResult(playerService.findPlyersCurrent(startTime));
//    }
//
//    @RequestMapping(value = "/history/detail", method = RequestMethod.GET)
//    public List<Player> findPlyersHistoryDetail(@RequestParam Date startTime, @RequestParam Date endTime) {
//        return playerService.findPlyersHistory(startTime, endTime);
//    }

    @RequestMapping(value = "/getPlayerInfoById", method = RequestMethod.GET)
    public Result<?> getPlayerInfoById(@RequestParam Long playerId) {
        if (playerId == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            Player player = playerService.getPlayerInfoById(playerId);
            return Result.buildSuccess().add("data", player);
        } catch (Exception e) {
            logger.info("PlayerCtrl#getPlayerInfoById playerId :{}", playerId, e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

}
