package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.bean.Option;
import org.spring.springboot.common.anno.JwtIgnore;
import org.spring.springboot.common.enums.BusiCodeEnum;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.game.playerunit.*;
import org.spring.springboot.domain.game.vo.PageParamVo;
import org.spring.springboot.service.PlayerunitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 绘本每日数据、用户购买特定版本
 *
 * @Author : zhoubin
 * @Date : 2023-01-15 12:45
 */
@RestController
@RequestMapping("player/unit")
public class PlayerunitCtrl {

    private static final Logger logger = LoggerFactory.getLogger(PlayerunitCtrl.class);
    @Autowired
    private PlayerunitService playerunitService;

    // 查询该日期绘本数据
    @RequestMapping(value = "/huiben/num", method = RequestMethod.GET)
    public AjaxResult findNum(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playerunitService.findPlayunitNum(dateTime));
    }

    // 查询该日期范围绘本数据
    @RequestMapping(value = "/huiben/rangedate/num", method = RequestMethod.GET)
    public AjaxResult findNumBetweenDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerunitService.findNumBetweenDate(startTime, endTime));
    }

    // 查询该日期绘本数据详情
    @RequestMapping(value = "/huiben/detail", method = RequestMethod.GET)
    public AjaxResult findDetail(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playerunitService.findDetail(dateTime));
    }

    // 查询该日期范围绘本数据详情
    @RequestMapping(value = "/huiben/rangedate/detail")
    public Result<?> findDetailBetweenDate(PageParamVo vo) {
        if (vo == null
                || vo.getEndTime() == null
                || vo.getStartTime() == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            return playerunitService.findDetailBetweenDate(vo);
        } catch (Exception e) {
            logger.info("PlayerCtrl#findDetailBetweenDate error vo is {}", JSONUtil.toJsonStr(vo), e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);
    }

    // 查询该日期用户购买特定版本数据
    @RequestMapping(value = "/purchase/num", method = RequestMethod.GET)
    public AjaxResult findPurchaseNum(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playerunitService.findPurchasePlayunitNum(dateTime));
    }

    // 查询该日期范围用户购买特定版本数据
    @RequestMapping(value = "/purchase/rangedate/num", method = RequestMethod.GET)
    public AjaxResult findPurchaseNumBetweenDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerunitService.findPurchaseNumBetweenDate(startTime, endTime));
    }

    // 查询该日期用户购买特定版本数据详情
    @RequestMapping(value = "/purchase/detail", method = RequestMethod.GET)
    public AjaxResult findPurchaseDetail(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playerunitService.findPurchaseDetail(dateTime));
    }

    // 查询该日期范围用户购买特定版本数据详情
    @RequestMapping(value = "/purchase/rangedate/detail")
    public Result<?> findPurchaseDetailBetweenDate(PageParamVo vo) {
        if (vo == null
                || vo.getEndTime() == null
                || vo.getStartTime() == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            return playerunitService.findPurchaseDetailBetweenDate(vo);
        } catch (Exception e) {
            logger.info("PlayerCtrl#findPurchaseDetailBetweenDate error vo is {}", JSONUtil.toJsonStr(vo), e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);
    }

    // 查询该日期特定版本数据
    @RequestMapping(value = "/version/num", method = RequestMethod.GET)
    public AjaxResult findVersionNum(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playerunitService.findVersionPlayunitNum(dateTime));
    }

    // 查询该日期范围特定版本数据
    @RequestMapping(value = "/version/rangedate/num", method = RequestMethod.GET)
    public AjaxResult findVersionNumBetweenDate(@RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerunitService.findVersionNumBetweenDate(startTime, endTime));
    }

    // 查询该日期特定版本数据详情
    @RequestMapping(value = "/version/detail", method = RequestMethod.GET)
    public AjaxResult findVersionDetail(@RequestParam Date dateTime) {
        return AjaxResult.successResult(playerunitService.findVersionDetail(dateTime));
    }

    // 查询该日期范围特定版本数据详情
    @RequestMapping(value = "/version/rangedate/detail")
    public Result<?> findVersionDetailBetweenDate(PageParamVo vo) {
        if (vo == null
                || vo.getEndTime() == null
                || vo.getStartTime() == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            return playerunitService.findVersionDetailBetweenDate(vo);
        } catch (Exception e) {
            logger.info("PlayerCtrl#findVersionDetailBetweenDate error vo is {}", JSONUtil.toJsonStr(vo), e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);
    }

    /**
     *
     * 根据用户id获取购买的书本option列表
     * @author 13540
     * @date 2023-09-03 11:03 
     * @return org.spring.springboot.common.result.Result<?>
     */
    @RequestMapping(value = "/getPlayerUnitOptionListByPid")
    public Result<?> getPlayerUnitOptionListByPid(Long pid) {
        if(pid == null) {
            return Result.buildFailure(SysCodeEnum.BusinessError);
        }

        try {
            List<Option> playerUnitOptions = playerunitService.getPlayerUnitOptionListByPid(pid);
            return Result.buildSuccess().add("data", playerUnitOptions);

        }catch (Exception e) {
            logger.info("PlayerCtrl#getPlayerUnitOptionListByPid error pid is {}", pid, e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);
    }


    /**
     *
     * 充值记录条件查询
     * @param query
     * @author 13540
     * @date 2023-09-03 15:33
     * @return org.spring.springboot.common.result.Result<?>
     */
    @RequestMapping(value = "/queryRechargeByPage")
    public Result<?> queryRechargeByPage(PlayerRechargeQuery query) {
        try {
            return playerunitService.queryRechargeByPage(query);
        }catch (Exception e) {
            logger.info("PlayerCtrl#queryRechargeByPage error query is {}", JSONUtil.toJsonStr(query), e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);

    }

    /**
     *
     * 订单转移
     * @author 13540
     * @date 2023-09-03 17:31
     * @return org.spring.springboot.common.result.Result<?>
     */
    @RequestMapping(value = "/changeRecharge")
    public Result<?> changeRecharge(PlayerRechargeOperateVO playerRechargeOperateVO) {
        if(playerRechargeOperateVO == null
                || playerRechargeOperateVO.getOriginPid() == null
                || playerRechargeOperateVO.getTargetPid() == null
                || playerRechargeOperateVO.getBookIdx() == null
        ){
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            String errorMess = playerunitService.changeRecharge(playerRechargeOperateVO);
            if(StringUtils.isEmpty(errorMess)) {
                return Result.buildSuccess();
            }
            return Result.buildFailure(BusiCodeEnum.BUSINESS_ERROR, errorMess);
        }catch (Exception e) {
            logger.info("PlayerCtrl#changeRecharge error playerRechargeOperateVO is {}", JSONUtil.toJsonStr(playerRechargeOperateVO), e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);

    }


    /**
     *
     * 加减锁
     * @author 13540
     * @date 2023-09-10 13:12 
     * @return org.spring.springboot.common.result.Result<?>
     */
    @RequestMapping("/updateUnlockStatus")
    public Result<?> updateUnlockStatus(PlayerRechargeUnLockQuery playerRechargeUnLockQuery) {
        if(playerRechargeUnLockQuery == null
                || playerRechargeUnLockQuery.getId() == null
                || playerRechargeUnLockQuery.getUnlock() == null
        ){
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            Integer updateNum = playerunitService.updateUnlockStatus(playerRechargeUnLockQuery);
            if(updateNum == null || updateNum <=0) {
                return Result.buildFailure(BusiCodeEnum.BUSINESS_ERROR, "更新失败！");
            }
            return Result.buildSuccess();
        }catch (Exception e) {
            logger.info("PlayerCtrl#updateUnlockStatus error playerRechargeUnLockQuery is {}", JSONUtil.toJsonStr(playerRechargeUnLockQuery), e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);

    }

    @RequestMapping("/addBookUnit")
    public Result<?> addBookUnit(PlayerUnitQuery query) {
        if(query == null
                || query.getPid() == null
                || query.getChannel() == null
                || query.getPackageIdx() == null
                || query.getRemainTime() == null
        ) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        String errMsg = null;
        try {
            errMsg = playerunitService.addBookUnit(query);
            if(StringUtils.isEmpty(errMsg)) {
                return Result.buildSuccess();
            }
        }catch (Exception e) {
            logger.info("PlayerCtrl#addBookUnit error query is {}", JSONUtil.toJsonStr(query), e);
        }

        return Result.buildFailure(BusiCodeEnum.BUSINESS_ERROR, errMsg);

    }

    @RequestMapping(value = "/queryBookResourceOptions", method = RequestMethod.GET)
    public Result<?> queryBookResourceOptions(@RequestParam("pid") Long pid) {
        try {
            return Result.buildSuccess().add("data", playerunitService.queryBookResourceOptions(pid));
        }catch (Exception e) {
            logger.error("BookresourceCtrl#queryBookResourceOptions error e", e);
        }
        return Result.buildFailure();
    }

    @RequestMapping("/updateBookUnitUpdateTimeOrLearnTime")
    public Result<?> updateBookUnitUpdateTimeOrLearnTime(PlayerUnitLearnQuery query) {
        if(query == null
                || query.getPid() == null
                || query.getBookIdx() == null
        ) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            playerunitService.updateBookUnitUpdateTimeOrLearnTime(query);
        }catch (Exception e) {
            logger.info("PlayerCtrl#updateBookUnitUpdateTimeOrLearnTime error query is {}", JSONUtil.toJsonStr(query), e);
        }

        return Result.buildFailure();

    }

    // 按照包查询充值数量
    @RequestMapping(value = "/queryPackage", method = RequestMethod.GET)
    public AjaxResult findRegisterNumGroupbyDate(@RequestParam Long packageIdx, @RequestParam Date startTime, @RequestParam Date endTime) {
        return AjaxResult.successResult(playerunitService.queryRechargeByPackage(packageIdx, startTime, endTime));
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
}
