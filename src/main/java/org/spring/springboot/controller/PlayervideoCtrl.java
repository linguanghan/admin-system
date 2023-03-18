package org.spring.springboot.controller;

import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.service.PlayervideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 视频查询
 *
 * @Author : zhoubin
 * @Date : 2023-01-21 20:22
 */
@RestController
@RequestMapping("player/video")
public class PlayervideoCtrl {
    @Autowired
    private PlayervideoService playervideoService;

    // 查询该日期绘本数据
    @RequestMapping(value = "/num", method = RequestMethod.GET)
    public AjaxResult findNum(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playervideoService.findPlayvideoNum(dateTime));
    }

    // 查询该日期范围绘本数据
    @RequestMapping(value = "/rangedate/num", method = RequestMethod.GET)
    public AjaxResult findNumBetweenDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playervideoService.findNumBetweenDate(startTime, endTime));
    }

    // 查询该日期绘本数据详情
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public AjaxResult findDetail(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playervideoService.findDetail(dateTime));
    }

    // 查询该日期范围绘本数据详情
    @RequestMapping(value = "/rangedate/detail", method = RequestMethod.GET)
    public AjaxResult findDetailBetweenDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playervideoService.findDetailBetweenDate(startTime, endTime));
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
}
