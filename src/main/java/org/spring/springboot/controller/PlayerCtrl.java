package org.spring.springboot.controller;

import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
    @RequestMapping(value = "/register/rangedate/detail", method = RequestMethod.GET)
    public AjaxResult findRegisterDetailBetweenDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerService.findRegisterDetailBetweenDate(startTime, endTime));
    }

    // 查询该日期范围注册人数--按天归类
    @RequestMapping(value = "/register/num/day", method = RequestMethod.GET)
    public AjaxResult findRegisterNumGroupbyDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerService.findRegisterNumGroupbyDate(startTime, endTime));
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
    @RequestMapping(value = "/active/rangedate/detail", method = RequestMethod.GET)
    public AjaxResult findActiveDetailBetweenDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerService.findActiveDetailBetweenDate(startTime, endTime));
    }

    // 查询该日期范围活跃人数--按天归类
    @RequestMapping(value = "/active/num/day", method = RequestMethod.GET)
    public AjaxResult findActiveNumGroupbyDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerService.findActiveNumGroupbyDate(startTime, endTime));
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

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

}
