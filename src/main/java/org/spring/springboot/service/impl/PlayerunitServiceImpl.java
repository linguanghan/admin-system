package org.spring.springboot.service.impl;

import cn.hutool.core.collection.ListUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.bean.Option;
import org.spring.springboot.common.enums.RoleEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.dao.pelbsData.*;
import org.spring.springboot.dao.yldres.AppInfoConfigDao;
import org.spring.springboot.dao.yldres.BookresourceDao;
import org.spring.springboot.dao.yldres.ChangeRechargeRecordDao;
import org.spring.springboot.domain.pelbsData.DayPlayer;
import org.spring.springboot.domain.pelbsData.DayPlayerRecharge;
import org.spring.springboot.domain.pelbsData.PackageQuery;
import org.spring.springboot.domain.pelbsData.Player;
import org.spring.springboot.domain.pelbsData.palyerlearntime.PlayerLearnTimePO;
import org.spring.springboot.domain.pelbsData.playerext.PlayerExt;
import org.spring.springboot.domain.pelbsData.playerunit.*;
import org.spring.springboot.domain.pelbsData.vo.PageParamVo;
import org.spring.springboot.domain.user.UserHolder;
import org.spring.springboot.domain.yldres.app.AppInfoConfig;
import org.spring.springboot.domain.yldres.Bookresource;
import org.spring.springboot.domain.yldres.recharge.ChangeRechargeRecordPO;
import org.spring.springboot.service.PlayerunitService;
import org.spring.springboot.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-15 12:46
 */
@Service
public class PlayerunitServiceImpl implements PlayerunitService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerunitServiceImpl.class);

    private static final String LENGTH_10 = "LENGTH_10";

    @Resource
    private PlayerunitDao playerunitDao;

    @Resource
    private PlayerRechargeDao playerRechargeDao;

    @Resource
    private PlayerLearnTimeDao playerLearnTimeDao;

    @Resource
    private BookresourceDao bookresourceDao;

    @Resource
    private PlayerExtDao playerExtDao;

    @Resource
    private PlayerDao playerDao;

    @Resource
    private ChangeRechargeRecordDao changeRechargeRecordDao;

    @Resource
    private AppInfoConfigDao appInfoConfigDao;

    private static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String time_start_suffix = " 00:00:00";
    private static final String time_end_suffix = " 23:59:59";

    @Override
    public Integer findPlayunitNum(Date dateTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        if (null == dateTime) {
            dateTime = new Date();
        }
        String t = df.format(dateTime);
        String substring = t.substring(0, 10);
        String e = substring + time_end_suffix;
        t = substring + time_start_suffix;
        long start = 0;
        long end = 0;
        try {
            start = df.parse(t).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerunitDao.findNumBetweenDate(start, end);
    }

    @Override
    public Integer findNumBetweenDate(Date startTime, Date endTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String s = df.format(startTime);
        String e = df.format(endTime);
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerunitDao.findNumBetweenDate(start, end);
    }

    @Override
    public List<Playerunit> findDetail(Date dateTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String e = df.format(dateTime);
        String substring = e.substring(0, 10);
        String s = substring + time_start_suffix;
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerunitDao.findBetweenDate(start, end);
    }

    @Override
    public Result<?> findDetailBetweenDate(PageParamVo vo) {

        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String t = df.format(vo.getStartTime());
        String e = df.format(vo.getEndTime());
        long start = 0;
        long end = 0;
        try {
            start = df.parse(t).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (Exception pe) {
            LOGGER.error(pe.getMessage(), pe);
        }
        List<Playerunit> playerUnits = playerunitDao.findBetweenDate(start, end);
        if (CollectionUtils.isEmpty(playerUnits)) {
            return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
        }
        List<Playerunit> playerUnitsPage = ListUtil.page(vo.getPageNo() - 1, vo.getPageSize(), playerUnits);
        return Result.buildSuccess().add("data", playerUnitsPage).add("total", playerUnits.size());
    }

    @Override
    public Integer findPurchasePlayunitNum(Date dateTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        if (null == dateTime) {
            dateTime = new Date();
        }
        String t = df.format(dateTime);
        String substring = t.substring(0, 10);
        String e = substring + time_end_suffix;
        t = substring + time_start_suffix;
        long start = 0;
        long end = 0;
        try {
            start = df.parse(t).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerunitDao.findPurchaseNumBetweenDate(start, end);
    }

    @Override
    public Integer findPurchaseNumBetweenDate(Date startTime, Date endTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String s = df.format(startTime);
        String e = df.format(endTime);
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerunitDao.findPurchaseNumBetweenDate(start, end);
    }

    @Override
    public List<Playerunit> findPurchaseDetail(Date dateTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String e = df.format(dateTime);
        String substring = e.substring(0, 10);
        String s = substring + time_start_suffix;
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerunitDao.findPurchaseBetweenDate(start, end);
    }

    @Override
    public Result<?> findPurchaseDetailBetweenDate(PageParamVo vo) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String t = df.format(vo.getStartTime());
        String e = df.format(vo.getEndTime());
        long start = 0;
        long end = 0;
        try {
            start = df.parse(t).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        List<Playerunit> playerUnits = playerunitDao.findPurchaseBetweenDate(start, end);
        if (CollectionUtils.isEmpty(playerUnits)) {
            return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
        }
        List<Playerunit> playerUnitsPage = ListUtil.page(vo.getPageNo() - 1, vo.getPageSize(), playerUnits);
        return Result.buildSuccess().add("data", playerUnitsPage).add("total", playerUnits.size());
    }

    @Override
    public Integer findVersionPlayunitNum(Date dateTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        if (null == dateTime) {
            dateTime = new Date();
        }
        String t = df.format(dateTime);
        String substring = t.substring(0, 10);
        String e = substring + time_end_suffix;
        t = substring + time_start_suffix;
        long start = 0;
        long end = 0;
        try {
            start = df.parse(t).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerunitDao.findVersionNumBetweenDate(start, end);
    }

    @Override
    public Integer findVersionNumBetweenDate(Date startTime, Date endTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String s = df.format(startTime);
        String e = df.format(endTime);
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerunitDao.findVersionNumBetweenDate(start, end);
    }

    @Override
    public List<Playerunit> findVersionDetail(Date dateTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String e = df.format(dateTime);
        String substring = e.substring(0, 10);
        String s = substring + time_start_suffix;
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerunitDao.findVersionBetweenDate(start, end);
    }

    @Override
    public Result<?> findVersionDetailBetweenDate(PageParamVo vo) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String t = df.format(vo.getStartTime());
        String e = df.format(vo.getEndTime());
        long start = 0;
        long end = 0;
        try {
            start = df.parse(t).getTime() / 1000;
            end = df.parse(e).getTime() / 1000;
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        List<Playerunit> playerUnits = playerunitDao.findVersionBetweenDate(start, end);
        if (CollectionUtils.isEmpty(playerUnits)) {
            return Result.buildSuccess().add("data", playerUnits).add("total", 0);
        }
        List<Playerunit> playerUnitsPage = ListUtil.page(vo.getPageNo() - 1, vo.getPageSize(), playerUnits);

        return Result.buildSuccess().add("data", playerUnitsPage).add("total", playerUnits.size());
    }


    /**
     * 根据用户id获取购买的书本option列表
     *
     * @return java.util.List<org.spring.springboot.bean.OptionList>
     * @author 13540
     * @date 2023-09-03 10:54
     */
    @Override
    public List<Option> getPlayerUnitOptionListByPid(Long pid) {
        Playerunit playerunit = new Playerunit();
        playerunit.setPid(pid);
        playerunit.setUnit3(1);
        List<Playerunit> playerUnitByPid = playerunitDao.findPlayerUnitByExample(playerunit);
        if (CollectionUtils.isEmpty(playerUnitByPid)) {
            return Collections.emptyList();
        }

        return playerUnitByPid.stream().map(playerUnitInfo -> {
            Option optionList = new Option();
            optionList.setLabel(String.valueOf(playerUnitInfo.getBookidx()));
            optionList.setValue(String.valueOf(playerUnitInfo.getBookidx()));
            return optionList;
        }).collect(Collectors.toList());

    }

    @Override
    public Result<?> queryRechargeByPage(PlayerRechargeQuery query) {
        // 1、查询参数都不传递的时候不查询
        if (query.getPid() == null && StringUtils.isEmpty(query.getOrderId()) && query.getStartTime() == null && query.getEndTime() == null) {
            return Result.buildSuccess().add("data", Collections.emptyList()).add("total", 0);
        }

        List<Long> pids = new ArrayList<>();
        List<Long> pidList = new ArrayList<>();
        String orderId = query.getOrderId();

        // 2、订单号不为空的时候再Recharge表根据订单查询pid
        if (!StringUtils.isEmpty(orderId)) {
            List<PlayerRechargePO> playerRechargePOS = playerRechargeDao.queryPlayerRechargeInfoByOrderId(orderId);
            if (!CollectionUtils.isEmpty(playerRechargePOS)) {
                pidList = playerRechargePOS.stream().map(PlayerRechargePO::getPid).collect(Collectors.toList());
            }
        }

        // 3、根据时间、pid联合查询充值记录
        if (query.getPid() != null && StringUtils.isEmpty(query.getOrderId())) {
            pids = Collections.singletonList(query.getPid());
        }
        if (query.getPid() == null && !StringUtils.isEmpty(query.getOrderId())) {
            pids = pidList;
        }
        if (query.getPid() != null && !StringUtils.isEmpty(query.getOrderId())) {
            pids = ListUtils.retainAll(Collections.singletonList(query.getPid()), pidList);
        }
        if (pids.isEmpty()) {
            return Result.buildSuccess().add("data", Collections.emptyList()).add("total", 0);
        }
        Map<String, Long> timeChangeMap = getTimeChangeMap(Arrays.asList(query.getStartTime(), query.getEndTime()), Arrays.asList("startTime", "endTime"));
        List<Playerunit> playerunits = playerunitDao.queryRechargeByPage(timeChangeMap.get("startTime"), timeChangeMap.get("endTime"), pids, query.getStartRow(), query.getPageSize(), query.getUnlock());
        Integer total = playerunitDao.queryRechargeByPageCount(timeChangeMap.get("startTime"), timeChangeMap.get("endTime"), pids, query.getUnlock());
        if (CollectionUtils.isEmpty(playerunits)) {
            return Result.buildSuccess().add("data", Collections.emptyList()).add("total", 0);
        }

        //4、查询相关信息
        List<Long> bookIds = playerunits.stream().map(playerunit -> Long.parseLong(String.valueOf(playerunit.getBookidx()))).collect(Collectors.toList());
        List<Bookresource> bookresources = bookresourceDao.batchQueryBookResourceInfosByIds(bookIds);
        Map<Long, Bookresource> bookresourceMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(bookresources)) {
            bookresourceMap = bookresources.stream().collect(Collectors.toMap(Bookresource::getBookId, v -> v, (k1, k2) -> k1));
        }
        Map<Long, Player> playerMap = new HashMap<>();
        List<Long> ids = playerunits.stream().map(Playerunit::getPid).collect(Collectors.toList());
        List<Player> players = playerDao.batchQueryPlayerInfosById(ids);
        if (!CollectionUtils.isEmpty(players)) {
            playerMap = players.stream().collect(Collectors.toMap(Player::getId, v -> v, (k1, k2) -> k1));
        }
        List<PlayerLearnTimePO> poList = playerunits.stream().map(playerunit -> {
            PlayerLearnTimePO playerLearnTimePO = new PlayerLearnTimePO();
            playerLearnTimePO.setPid(playerunit.getPid());
            playerLearnTimePO.setBookIdx(playerunit.getBookidx());
            return playerLearnTimePO;
        }).collect(Collectors.toList());
        Map<String, PlayerLearnTimePO> playerLearnTimeMap = new HashMap<>();
        List<PlayerLearnTimePO> playerLearnTimePOS = playerLearnTimeDao.batchQueryPlayerLearnTimeInfoByPidAndBookIdx(poList);
        if (!CollectionUtils.isEmpty(playerLearnTimePOS)) {
            playerLearnTimeMap = playerLearnTimePOS.stream().collect(Collectors.toMap(playerLearnTimePO -> playerLearnTimePO.getPid() + "-" + playerLearnTimePO.getBookIdx(), v -> v, (v1, v2) -> v1));
        }

        // 5、VO转化
        final Map<Long, Bookresource> finalBookresourceMap = bookresourceMap;
        final Map<Long, Player> finalPlayerMap = playerMap;
        final Map<String, PlayerLearnTimePO> finalPlayerLearnTimeMap = playerLearnTimeMap;

        List<PlayerRechargeVO> playerRechargeVOS = playerunits.stream().map(playerunit -> mapsToPlayerRechargeVO(playerunit, finalBookresourceMap, finalPlayerMap, finalPlayerLearnTimeMap)).collect(Collectors.toList());
        return Result.buildSuccess().add("data", playerRechargeVOS).add("total", total);
    }


    /**
     * VO转化
     *
     * @param playerunit
     * @param finalBookresourceMap
     * @param finalPlayerMap
     * @return org.spring.springboot.domain.pelbsData.playerunit.PlayerRechargeVO
     * @author 13540
     * @date 2023-09-09 14:42
     */
    private PlayerRechargeVO mapsToPlayerRechargeVO(Playerunit playerunit, Map<Long, Bookresource> finalBookresourceMap, Map<Long, Player> finalPlayerMap, Map<String, PlayerLearnTimePO> finalPlayerLearnTimeMap) {
        PlayerRechargeVO playerRechargeVO = new PlayerRechargeVO();
        playerRechargeVO.setId(playerunit.getId());
        playerRechargeVO.setPid(playerunit.getPid());
        Date date = DateUtil.timeStampToDate(playerunit.getCreatetime(), LENGTH_10);
        playerRechargeVO.setCreateTime(date);
        playerRechargeVO.setUnlock(playerunit.getUnit3());// unit3 = 1：解锁、0：锁住
        playerRechargeVO.setRemainTime(String.valueOf(playerunit.getPeriod()));
        Date bookDeadLineTime = getBookDeadLineTime(playerunit.getCreatetime(), playerunit.getPeriod());
        playerRechargeVO.setDeadLineTime(bookDeadLineTime);
        playerRechargeVO.setUnlockShow(1);
        playerRechargeVO.setBookType(playerunit.getBooktype());
        playerRechargeVO.setPackageIdx(playerunit.getPackageidx());
        if (new Date().after(bookDeadLineTime)) {
            playerRechargeVO.setUnlockShow(0);
        }
        Integer bookidx = playerunit.getBookidx();
        if (bookidx != null) {
            playerRechargeVO.setBookIdx(playerunit.getBookidx());
            long bookIndexLong = Long.parseLong(String.valueOf(bookidx));
            // 书名填充
            if (finalBookresourceMap.get(bookIndexLong) != null) {
                playerRechargeVO.setBookName(finalBookresourceMap.get(bookIndexLong).getName());
//                playerRechargeVO.setBookType(finalBookresourceMap.get(bookIndexLong).getBookType());
            }
            // 用户名填充
            if (finalPlayerMap.get(playerunit.getPid()) != null) {
                playerRechargeVO.setPlayerName(finalPlayerMap.get(playerunit.getPid()).getName());
            }
            PlayerLearnTimePO playerLearnTimePO = finalPlayerLearnTimeMap.get(playerunit.getPid() + "-" + playerunit.getBookidx());
            // 学习时长填充
            if (playerLearnTimePO != null && playerLearnTimePO.getTotalTime() != null) {
                playerRechargeVO.setLearnTimeUnit1(playerLearnTimePO.getUnit1());
                playerRechargeVO.setLearnTimeUnit2(playerLearnTimePO.getUnit2());
                playerRechargeVO.setLearnTimeUnit3(playerLearnTimePO.getUnit3());
                playerRechargeVO.setLearnTimeUnit4(playerLearnTimePO.getUnit4());
                playerRechargeVO.setLearnTimeUnit5(playerLearnTimePO.getUnit5());
                playerRechargeVO.setLearnTimeUnit6(playerLearnTimePO.getUnit6());
                playerRechargeVO.setLearnTimeUnit7(playerLearnTimePO.getUnit7());
                playerRechargeVO.setLearnTimeUnit8(playerLearnTimePO.getUnit8());
                playerRechargeVO.setLearnTimeUnit9(playerLearnTimePO.getUnit9());
                playerRechargeVO.setLearnTimeUnit10(playerLearnTimePO.getUnit10());
                playerRechargeVO.setLearnTimeUnit11(playerLearnTimePO.getUnit11());
                playerRechargeVO.setLearnTimeUnit12(playerLearnTimePO.getUnit12());
                playerRechargeVO.setLearnTimeUnit13(playerLearnTimePO.getUnit13());
                playerRechargeVO.setLearnTimeUnit14(playerLearnTimePO.getUnit14());
                playerRechargeVO.setLearnTimeUnit15(playerLearnTimePO.getUnit15());
                playerRechargeVO.setLearnTimeUnit16(playerLearnTimePO.getUnit16());
                playerRechargeVO.setLearnTimeUnit17(playerLearnTimePO.getUnit17());
                playerRechargeVO.setLearnTimeUnit18(playerLearnTimePO.getUnit18());
                playerRechargeVO.setLearnTimeUnit19(playerLearnTimePO.getUnit19());
                playerRechargeVO.setLearnTimeUnit20(playerLearnTimePO.getUnit20());
                playerRechargeVO.setTotalTime(playerLearnTimePO.getTotalTime());
            }
        }

        return playerRechargeVO;
    }

    /**
     * 账号转移
     *
     * @return java.lang.String
     * @author 13540
     * @date 2023-09-03 18:47
     */
    @Override
    @Transactional
    public String changeRecharge(PlayerRechargeOperateVO playerRechargeOperateVO) {
        // 1、校验原始账号有没有该本书
        Playerunit playerunit = new Playerunit();
        playerunit.setPid(playerRechargeOperateVO.getOriginPid());
        playerunit.setUnit3(1);
        List<Playerunit> originPlayerUnits = playerunitDao.findPlayerUnitByExample(playerunit);
        if (CollectionUtils.isEmpty(originPlayerUnits)) {
            return "该账号没有该书的转移权限！";
        }
        List<Integer> originBookIds = originPlayerUnits.stream().map(Playerunit::getBookidx).collect(Collectors.toList());
        if (!originBookIds.contains(playerRechargeOperateVO.getBookIdx())) {
            return "该账号没有该书的转移权限";
        }

        // 2、查询目标账号有没有该本书
        playerunit.setPid(playerRechargeOperateVO.getTargetPid());
        playerunit.setBookidx(playerRechargeOperateVO.getBookIdx());
        playerunit.setUnit3(0);
        List<Playerunit> targetPlayerUnits = playerunitDao.findPlayerUnitByExample(playerunit);

        List<ChangeRechargeOperateInfo> changeRechargeOperateInfos = new ArrayList<>();
        // 3、目标账号与原账号不同，并且目标账号有该书的时候删除目标账号的书
        if (!CollectionUtils.isEmpty(targetPlayerUnits) && !playerRechargeOperateVO.getOriginPid().equals(playerRechargeOperateVO.getTargetPid())) {
            for (Playerunit targetPlayerUnit : targetPlayerUnits) {
                // 记录删除
                Playerunit playerunitInfo = playerunitDao.selectByPrimaryKey(targetPlayerUnit.getId());
                ChangeRechargeOperateInfo changeRechargeOperateInfo = new ChangeRechargeOperateInfo();
                changeRechargeOperateInfo.setOperateType("DELETE");
                changeRechargeOperateInfo.setOperateObj(playerunitInfo);
                changeRechargeOperateInfos.add(changeRechargeOperateInfo);
                // 操作删除
                playerunitDao.deleteByPrimaryKey(targetPlayerUnit.getId());
            }
        }

        playerunit.setPid(playerRechargeOperateVO.getOriginPid());
        playerunit.setBookidx(playerRechargeOperateVO.getBookIdx());
        playerunit.setUnit3(1);
        List<Playerunit> newOriginPlayerUnits = playerunitDao.findPlayerUnitByExample(playerunit);
        // 4、更新新书
        for (Playerunit newOriginPlayerUnit : newOriginPlayerUnits) {
            // 记录更新前的值
            ChangeRechargeOperateInfo changeRechargeOperateInfo = new ChangeRechargeOperateInfo();
            Playerunit playerunitRecordInfo = new Playerunit();
            BeanUtils.copyProperties(newOriginPlayerUnit, playerunitRecordInfo);
            changeRechargeOperateInfo.setOperateType("UPDATE");
            changeRechargeOperateInfo.setOperateObj(playerunitRecordInfo);
            changeRechargeOperateInfos.add(changeRechargeOperateInfo);

            // 更新新书
            newOriginPlayerUnit.setPid(playerRechargeOperateVO.getTargetPid());
            playerunitDao.updateByPrimaryKey(newOriginPlayerUnit);
        }

        // 5、记录转移历史
        ChangeRechargeRecordPO changeRechargeRecordPO = new ChangeRechargeRecordPO();
        changeRechargeRecordPO.setChangeInfo(JSON.toJSONString(playerRechargeOperateVO));
        changeRechargeRecordPO.setOperateInfo(JSON.toJSONString(changeRechargeOperateInfos));
        changeRechargeRecordPO.setCreateTime(System.currentTimeMillis() / 1000);
        changeRechargeRecordDao.saveBookInfo(changeRechargeRecordPO);
        return null;
    }

    @Override
    public Integer updateUnlockStatus(PlayerRechargeUnLockQuery playerRechargeUnLockQuery) {
        if (!checkUnlockShow(playerRechargeUnLockQuery.getId())) {
            return 0;
        }
        Playerunit playerunit = new Playerunit();
        playerunit.setId(playerRechargeUnLockQuery.getId());
        Integer unlock = playerRechargeUnLockQuery.getUnlock();
        if (unlock == 0) {
            PictureBookLock(playerRechargeUnLockQuery.getPid());
        } else if (unlock == 1) {
            PictureBookUnLock(playerRechargeUnLockQuery.getPid());
        }
        playerunit.setUnit3(unlock);
        playerunit.setUnit4(unlock);
        playerunit.setUnit5(unlock);
        playerunit.setUnit6(unlock);
        playerunit.setUnit7(unlock);
        playerunit.setUnit8(unlock);
        playerunit.setUnit9(unlock);
        playerunit.setUnit10(unlock);
        playerunit.setUnit11(unlock);
        playerunit.setUnit12(unlock);
        playerunit.setUnit13(unlock);
        playerunit.setUnit14(unlock);
        playerunit.setUnit15(unlock);
        playerunit.setUnit16(unlock);
        playerunit.setUnit17(unlock);
        playerunit.setUnit18(unlock);
        playerunit.setUnit19(unlock);
        playerunit.setUnit20(unlock);
        return playerunitDao.updateByPrimaryKeySelective(playerunit);
    }

    @Override
    public void PicLock(PlayerRechargeUnLockQuery playerRechargeUnLockQuery) {
        Playerunit playerunit = new Playerunit();
        playerunit.setId(playerRechargeUnLockQuery.getId());
        Integer unlock = playerRechargeUnLockQuery.getUnlock();
        PictureBookLock(playerRechargeUnLockQuery.getPid());
    }

    @Override
    public void PicUnlock(PlayerRechargeUnLockQuery playerRechargeUnLockQuery) {
        Playerunit playerunit = new Playerunit();
        playerunit.setId(playerRechargeUnLockQuery.getId());
        Integer unlock = playerRechargeUnLockQuery.getUnlock();
        PictureBookUnLock(playerRechargeUnLockQuery.getPid());
    }

    /*
     * 绘本表的过期时间和解锁状态查询
     * @param id
     */
    private int CheckPictureBookLock(Long id) {
        PlayerExt playerExt = playerExtDao.selectByPrimaryKey(id);
        if (playerExt == null) {
            return -1;  // 不存在
        }
        long overdueTime = playerExt.getHuibenVipOverdueTime();
        if (overdueTime == 0 || overdueTime < System.currentTimeMillis() / 1000) {
            return 1;  // 已锁定
        }
        long currentTime = System.currentTimeMillis() / 1000;
        if (overdueTime > currentTime) {
            return 0;  // 未锁定
        }
        return -1;
    }

    /**
     * 绘本锁定
     * 几种情况：
     * 一：不是绘本或者不是vip，那么不会在表中出现
     * 二：在表中，已锁定，overduetime为0,此时应该解锁，根据type和createTime计算overduetime
     * 三：在表中，已锁定，overduetime不为0，且overduetime大于当前时间，此时加锁，将overduetime置为0
     *
     * @param id
     * @return java.lang.Void
     */
    private Void PictureBookLock(Long id) {
        PlayerExt playerExt = playerExtDao.selectByPrimaryKey(id);
        if (playerExt == null) {
            return null;
        }
        playerExt.setHuibenVipOverdueTime(0);
        playerExtDao.updateByPrimaryKeySelective(playerExt);
        return null;
    }

    /*
     * 绘本解锁
     */
    private Void PictureBookUnLock(Long id) {
        PlayerExt playerExt = playerExtDao.selectByPrimaryKey(id);
        if (playerExt == null) {
            return null;
        }
        long overdueTime = 0L;
        Long createTime1 = Long.valueOf(playerExt.getCreateTime1());
        Long createTime2 = Long.valueOf(playerExt.getCreateTime2());
        Long createTime3 = Long.valueOf(playerExt.getCreateTime3());
        long maxCreateTime = Math.max(createTime1, Math.max(createTime2, createTime3));

        Integer type1 = playerExt.getType1();
        Integer type2 = playerExt.getType2();
        Integer type3 = playerExt.getType3();
        int maxType = Math.max(type1, Math.max(type2, type3));

        switch (maxType) {
            case 1:  // 1个月
                overdueTime = maxCreateTime + 30 * 24 * 60 * 60;
                break;
            case 2:  // 3个月
                overdueTime = maxCreateTime + 3 * 30 * 24 * 60 * 60;
                break;
            case 3:  // 6个月
                overdueTime = maxCreateTime + 6 * 30 * 24 * 60 * 60;
                break;
            case 4:  // 9个月
                overdueTime = maxCreateTime + 9 * 30 * 24 * 60 * 60;
                break;
            case 5:  // 12个月
                overdueTime = maxCreateTime + 12 * 30 * 24 * 60 * 60;
                break;
            default:
                break;
        }

        playerExt.setHuibenVipOverdueTime((int) overdueTime);
        playerExtDao.updateByPrimaryKeySelective(playerExt);
        return null;
    }

    @Override
    public String addBookUnit(PlayerUnitQuery query) {
        Playerunit playerunit = new Playerunit();
        playerunit.setPid(query.getPid());
        long now = System.currentTimeMillis();
        playerunit.setCreatetime((int) (now / 1000));
        playerunit.setChannel(query.getChannel());
        playerunit.setBookidx(query.getBookIdx());
        List<Playerunit> playerunits = playerunitDao.selectByCondition(playerunit);
        if (!CollectionUtils.isEmpty(playerunits)) {
            return "已经有该本书了不能再添加了";
        }
        List<Bookresource> bookresources = bookresourceDao.fetchBookresourceInfosByBookId(String.valueOf(query.getBookIdx()));
        if (!CollectionUtils.isEmpty(bookresources)) {
            Bookresource bookresource = bookresources.get(0);
            playerunit.setBooktype(bookresource.getBookType());
        }
        playerunit.setPeriod(query.getRemainTime());
        playerunit.setUnit1(1);
        playerunit.setUnit2(1);
        playerunit.setUnit3(1);
        playerunit.setUnit4(1);
        playerunit.setUnit5(1);
        playerunit.setUnit6(1);
        playerunit.setUnit7(1);
        playerunit.setUnit8(1);
        playerunit.setUnit9(1);
        playerunit.setUnit10(1);
        playerunit.setUnit11(1);
        playerunit.setUnit12(1);
        playerunit.setUnit13(1);
        playerunit.setUnit14(1);
        playerunit.setUnit15(1);
        playerunit.setUnit16(1);
        playerunit.setUnit17(1);
        playerunit.setUnit18(1);
        playerunit.setUnit19(1);
        playerunit.setUnit20(1);
        playerunit.setPackageidx(query.getPackageIdx());
        playerunit.setBooktype(query.getBookType());
        int insertNum = playerunitDao.insertSelective(playerunit);
        return insertNum > 0 ? null : "新增失败！";
    }

    @Override
    @Transactional
    public void updateBookUnitUpdateTimeOrLearnTime(PlayerUnitLearnQuery query) {
        if (query.getRemainTime() != null) {
            Playerunit playerunit = new Playerunit();
            playerunit.setId(query.getId());
            List<Playerunit> playerUnitInfos = playerunitDao.selectByCondition(playerunit);
            if (!CollectionUtils.isEmpty(playerUnitInfos)) {
                Playerunit playerunitTemp = playerUnitInfos.get(0);
                playerunitTemp.setPeriod(query.getRemainTime());
                playerunitTemp.setBooktype(query.getBookType());
                playerunitTemp.setPackageidx(query.getPackageIdx());
                playerunitTemp.setBookidx(query.getBookIdx());
                playerunitTemp.setCreatetime(DateUtil.dateToTimeStamp(query.getCreateTime(), LENGTH_10).intValue());
                playerunitDao.updateByPrimaryKey(playerunitTemp);
            }
        }

        if (query.getLearnTimeUnit1() != null) {
            PlayerLearnTimePO playerLearnTimePO = new PlayerLearnTimePO();
            playerLearnTimePO.setPid(query.getPid());
            playerLearnTimePO.setBookIdx(query.getBookIdx());
            List<PlayerLearnTimePO> playerLearnTimePOS = playerLearnTimeDao.batchQueryPlayerLearnTimeInfoByPidAndBookIdx(Collections.singletonList(playerLearnTimePO));
            if (!CollectionUtils.isEmpty(playerLearnTimePOS)) {
                PlayerLearnTimePO playerLearnTimePOTemp = playerLearnTimePOS.get(0);
                playerLearnTimePOTemp.setUnit1(query.getLearnTimeUnit1());
                playerLearnTimePOTemp.setUnit2(query.getLearnTimeUnit2());
                playerLearnTimePOTemp.setUnit3(query.getLearnTimeUnit3());
                playerLearnTimePOTemp.setUnit4(query.getLearnTimeUnit4());
                playerLearnTimePOTemp.setUnit5(query.getLearnTimeUnit5());
                playerLearnTimePOTemp.setUnit6(query.getLearnTimeUnit6());
                playerLearnTimePOTemp.setUnit7(query.getLearnTimeUnit7());
                playerLearnTimePOTemp.setUnit8(query.getLearnTimeUnit8());
                playerLearnTimePOTemp.setUnit9(query.getLearnTimeUnit9());
                playerLearnTimePOTemp.setUnit10(query.getLearnTimeUnit10());
                playerLearnTimePOTemp.setUnit11(query.getLearnTimeUnit11());
                playerLearnTimePOTemp.setUnit12(query.getLearnTimeUnit12());
                playerLearnTimePOTemp.setUnit13(query.getLearnTimeUnit13());
                playerLearnTimePOTemp.setUnit14(query.getLearnTimeUnit14());
                playerLearnTimePOTemp.setUnit15(query.getLearnTimeUnit15());
                playerLearnTimePOTemp.setUnit16(query.getLearnTimeUnit16());
                playerLearnTimePOTemp.setUnit17(query.getLearnTimeUnit17());
                playerLearnTimePOTemp.setUnit18(query.getLearnTimeUnit18());
                playerLearnTimePOTemp.setUnit19(query.getLearnTimeUnit19());
                playerLearnTimePOTemp.setUnit20(query.getLearnTimeUnit20());
                Integer totalTime = query.getLearnTimeUnit1() + query.getLearnTimeUnit2() + query.getLearnTimeUnit3() + query.getLearnTimeUnit4() + query.getLearnTimeUnit5() + query.getLearnTimeUnit6() + query.getLearnTimeUnit7() + query.getLearnTimeUnit8() + query.getLearnTimeUnit9() + query.getLearnTimeUnit10() + query.getLearnTimeUnit11() + query.getLearnTimeUnit12() + query.getLearnTimeUnit13() + query.getLearnTimeUnit14() + query.getLearnTimeUnit15() + query.getLearnTimeUnit16() + query.getLearnTimeUnit17() + query.getLearnTimeUnit18() + query.getLearnTimeUnit19() + query.getLearnTimeUnit20();
                playerLearnTimePOTemp.setTotalTime(totalTime);
                playerLearnTimeDao.updateByPrimaryKey(playerLearnTimePOTemp);
            }
        }
    }

    @Override
    public List<Option> queryBookResourceOptions(Long pid) {
        Playerunit playerunit = new Playerunit();
        playerunit.setPid(pid);
        List<Playerunit> playerunits = playerunitDao.selectByCondition(playerunit);
        Set<Long> booIdxSet = new HashSet<>();
        if (!CollectionUtils.isEmpty(playerunits)) {
            booIdxSet = playerunits.stream().map(item -> (long) item.getBookidx()).collect(Collectors.toSet());
        }
        List<Bookresource> bookresources = bookresourceDao.fetchBookresourceInfos();
        if (CollectionUtils.isEmpty(bookresources)) {
            return Collections.emptyList();
        }

        Set<Long> finalBooIdxSet = booIdxSet;
        return bookresources.stream().filter(bookresource -> !finalBooIdxSet.contains(bookresource.getBookId())).map(bookresource -> {
            Option option = new Option();
            option.setLabel("【" + bookresource.getBookId() + "】" + bookresource.getName());
            option.setValue(String.valueOf(bookresource.getBookId()));
            return option;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PackageQuery> queryPackageIdxRecharge(Long packageIdx, Date startTime, Date endTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String s = df.format(startTime);
        String e = df.format(endTime);
        String substring = e.substring(0, 10);
        e = substring + time_end_suffix;
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime();
            end = df.parse(e).getTime();
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        List<String> dates = DateUtil.getBetweenDates(s, e);
        List<PackageQuery> rechargeNum = new ArrayList<>();
        List<PackageQuery> result = playerunitDao.queryPackageIdxRecharge(packageIdx, start / 1000, end / 1000);
        if (CollectionUtils.isEmpty(result)) {
            return Collections.emptyList();
        } else {
            Map<String, Integer> map = result.stream().collect(Collectors.toMap(PackageQuery::getTimedate, PackageQuery::getNum));
            for (String date : dates) {
                int num = 0;
                if (map.containsKey(date)) {
                    num = map.get(date);
                }
                rechargeNum.add(new PackageQuery(date, num));
            }
        }

//        for (PackageQuery packageQuery : result) {
//            if (dates.contains(packageQuery.getTimedate())) {
//                rechargeNum.add(packageQuery);
//            }
//        }

        return rechargeNum;
    }

    @Override
    public List<DayPlayerRecharge> queryPlayerRecharge2(Date startTime, Date endTime) {
        if (RoleEnum.MANAGER.getCode().equals(UserHolder.getRole())) {
            return Collections.emptyList();
        }
        List<DayPlayerRecharge> resultList = new ArrayList<>();

        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String s = df.format(startTime);
        String e = df.format(endTime);
        List<String> dates = DateUtil.getBetweenDates(s, e);

        Long start = startTime.getTime();
        Long end = endTime.getTime();
        // 获取日期范围内的玩家充值信息
        List<PlayerRechargePO> playerRechargePOS = playerRechargeDao.queryPlayerRecharge(start, end);
        if (CollectionUtils.isEmpty(playerRechargePOS)) {
            for (String date : dates) {
                resultList.add(new DayPlayerRecharge(date, 0, 0));
            }
        } else {
            // 统计充值玩家数量和充值次数
            Map<String, Set<Long>> playerMap = new HashMap<>();
            Map<String, Integer> countMap = new HashMap<>();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (PlayerRechargePO record : playerRechargePOS) {
                String format = dateFormat.format(new Date(Long.parseLong(record.getUpdateTime())));
                Long accountId = record.getAccountId();

                playerMap.computeIfAbsent(format, k -> new HashSet<>()).add(accountId);
                countMap.put(format, countMap.getOrDefault(format, 0) + 1);
            }

            for (String date : playerMap.keySet()) {
                resultList.add(new DayPlayerRecharge(date, playerMap.get(date).size(), countMap.get(date)));
            }
        }

        return resultList.stream().sorted(Comparator.comparing(DayPlayerRecharge::getTimedate)).collect(Collectors.toList());

    }

    @Override
    public List<DayPlayer> queryPlayerRecharge(Date startTime, Date endTime) {
        if (RoleEnum.MANAGER.getCode().equals(UserHolder.getRole())) {
            return Collections.emptyList();
        }
        List<DayPlayer> resultList = new ArrayList<>();

        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String s = df.format(startTime);
        String e = df.format(endTime);
        List<String> dates = DateUtil.getBetweenDates(s, e);

        Long start = startTime.getTime();
        Long end = endTime.getTime();
        // 获取日期范围内的玩家充值信息
        List<PlayerRechargePO> playerRechargePOS = playerRechargeDao.queryPlayerRecharge(start, end);

        if (CollectionUtils.isEmpty(playerRechargePOS)) {
            for (String date : dates) {
                resultList.add(new DayPlayer(date, 0));
            }
        } else {
            // 统计充值额
            Map<String, Integer> countMap = new HashMap<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (PlayerRechargePO record : playerRechargePOS) {
                String format = dateFormat.format(new Date(Long.parseLong(record.getUpdateTime())));
                Integer appPrice = record.getAppPrice();
                if (countMap.containsKey(format)) {
                    countMap.put(format, countMap.get(format) + appPrice);
                    continue;
                }
                countMap.put(format, appPrice);
            }

            countMap.forEach((k, v) -> resultList.add(new DayPlayer(k, v)));
        }

        return resultList.stream().sorted(Comparator.comparing(DayPlayer::getTimedate)).collect(Collectors.toList());
    }

    @Override
    public List<DayPlayer> queryAppRechargeCount(Date currentDate) {
        List<DayPlayer> resultList = new ArrayList<>();
        if (currentDate == null) {
            currentDate = new Date();
        }

        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(currentDate);
        // 重置时间部分为0
        calendarStart.set(Calendar.HOUR_OF_DAY, 0);
        calendarStart.set(Calendar.MINUTE, 0);
        calendarStart.set(Calendar.SECOND, 0);
        calendarStart.set(Calendar.MILLISECOND, 0);
        // 获取设定好的日期对象
        Date startDate = calendarStart.getTime();

        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(currentDate);
        // 设置时间部分为一天中的最后一刻
        calendarEnd.set(Calendar.HOUR_OF_DAY, 23);
        calendarEnd.set(Calendar.MINUTE, 59);
        calendarEnd.set(Calendar.SECOND, 59);
        calendarEnd.set(Calendar.MILLISECOND, 999);
        Date endDate = calendarEnd.getTime();

        long startTime = startDate.getTime();
        long endTime = endDate.getTime();

        // 当天所有APP的玩家充值数据
        List<PlayerRechargePO> playerRechargePOS = playerRechargeDao.queryPlayerRecharge(startTime, endTime);
        // 获取所有APP
        List<Integer> appList = playerunitDao.queryAPPAll();

        List<AppInfoConfig> appInfoConfigs = appInfoConfigDao.selectAll();
        Map<Integer, String> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(appInfoConfigs)) {
            appInfoConfigs.forEach(t -> map.put(t.getPackageIdx(), t.getAppName()));
        }

        if (CollectionUtils.isEmpty(playerRechargePOS)) {
            appList.forEach(t -> resultList.add(new DayPlayer(t + " " + map.getOrDefault(t, ""), 0)));
        } else {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (PlayerRechargePO rechargePO : playerRechargePOS) {
                Integer packageIdx = rechargePO.getPackageIdx();
                Integer appPrice = rechargePO.getAppPrice();
                if (countMap.containsKey(packageIdx)) {
                    countMap.put(packageIdx, countMap.get(packageIdx) + appPrice);
                    continue;
                }
                countMap.put(packageIdx, appPrice);
            }

            appList.forEach(t -> {
                resultList.add(new DayPlayer(t + " " + map.getOrDefault(t, ""), countMap.getOrDefault(t, 0)));
            });

            resultList.sort(Comparator.comparing(DayPlayer::getNum).reversed());
        }

        return resultList;
    }

    // 此函数包含了从数据库中获取信息并进行中间处理的方法，用于后续参考
    private Boolean checkUnlockShow(Long playerUnitId) {
        Playerunit playerunit = playerunitDao.selectByPrimaryKey(playerUnitId);
        Date bookDeadLineTime = getBookDeadLineTime(playerunit.getCreatetime(), playerunit.getPeriod());
        Date now = new Date();
        Date createTime = DateUtil.timeStampToDate(playerunit.getCreatetime(), LENGTH_10);
        return !now.after(bookDeadLineTime) && now.after(createTime);
    }

    // 根据书本Id修改书本类型和packageidx


    public void updateBookPackageAndType(Playerunit playerunit) {
        playerunitDao.updateBookPackageAndType(playerunit.getPackageidx(), playerunit.getBookidx(), playerunit.getPid(), playerunit.getBooktype());
    }


    /**
     * date类型转为Long时间戳
     *
     * @return java.util.Map<java.lang.String, java.lang.Long>
     * @author 13540
     * @date 2023-09-03 14:53
     */
    private Map<String, Long> getTimeChangeMap(List<Date> timeList, List<String> keys) {
        Map<String, Long> map = new HashMap<>();
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);

        for (int i = 0; i < timeList.size(); i++) {
            Date time = timeList.get(i);
            if (time == null) {
                continue;
            }
            String timeStr = df.format(time);
            try {
                long timeStamp = df.parse(timeStr).getTime() / 1000;
                map.put(keys.get(i), timeStamp);
            } catch (ParseException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }

        return map;
    }

    /**
     * 获取createTime+month时间，书本截止时间
     *
     * @return java.util.Date
     * @author 13540
     * @date 2023-09-12 22:03
     */
    private Date getBookDeadLineTime(Integer createTime, Integer month) {
        int deadLineTime = createTime + 60 * 60 * 24 * 30 * (month + 2);
//        Date date = DateUtil.timeStampToDate(createTime, LENGTH_10);
//        cn.hutool.core.date.DateUtil.offsetMonth(date, month);
        return DateUtil.timeStampToDate(deadLineTime, LENGTH_10);
    }
}
