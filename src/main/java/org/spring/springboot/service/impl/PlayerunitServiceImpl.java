package org.spring.springboot.service.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSON;
import generator.PlayerunitExample;
import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.bean.Option;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.dao.game.PlayerDao;
import org.spring.springboot.dao.game.PlayerLearnTimeDao;
import org.spring.springboot.dao.game.PlayerRechargeDao;
import org.spring.springboot.dao.game.PlayerunitDao;
import org.spring.springboot.dao.yldres.BookresourceDao;
import org.spring.springboot.dao.yldres.ChangeRechargeRecordDao;
import org.spring.springboot.domain.game.Player;
import org.spring.springboot.domain.game.palyerlearntime.PlayerLearnTimePO;
import org.spring.springboot.domain.game.playerunit.*;
import org.spring.springboot.domain.game.vo.PageParamVo;
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
    private PlayerDao playerDao;

    @Resource
    private ChangeRechargeRecordDao changeRechargeRecordDao;

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

        String orderId = query.getOrderId();
        List<Long> pidList = new ArrayList<>();
        List<Long> pids = new ArrayList<>();
        // 2、订单号不为空的时候再Recharge表根据订单查询pid
        if (!StringUtils.isEmpty(orderId)) {
            List<PlayerRechargePO> playerRechargePOS = playerRechargeDao.queryPlayerRechargeInfoByOrderId(orderId);
            if (!CollectionUtils.isEmpty(playerRechargePOS)) {
                pidList = playerRechargePOS.stream().map(PlayerRechargePO::getPid).collect(Collectors.toList());
                if (NumberUtil.isNumber(playerRechargePOS.get(0).getUpdateTime())) {
                    query.setOrderTime(Long.parseLong(playerRechargePOS.get(0).getUpdateTime()) / 1000);
                }
            }

        }
        if (query.getPid() != null && StringUtils.isEmpty(query.getOrderId())) {
            pids = Collections.singletonList(query.getPid());
        }
        if (query.getPid() == null && !StringUtils.isEmpty(query.getOrderId())) {
            pids = pidList;
        }
        if (query.getPid() != null && !StringUtils.isEmpty(query.getOrderId())) {
            pids = ListUtils.retainAll(Collections.singletonList(query.getPid()), pidList);
        }

        // 没有交集直接返回空
        if (CollectionUtils.isEmpty(pids)) {
            return Result.buildSuccess().add("data", Collections.emptyList()).add("total", 0);
        }

        // 3、根据时间、pid联合查询充值记录
        Map<String, Long> timeChangeMap = getTimeChangeMap(Arrays.asList(query.getStartTime(), query.getEndTime()), Arrays.asList("startTime", "endTime"));
        List<Playerunit> playerunits = playerunitDao.queryRechargeByPage(timeChangeMap.get("startTime"), timeChangeMap.get("endTime"), pids, query.getStartRow(), query.getPageSize(), query.getOrderTime(), query.getUnlock());
        Integer total = playerunitDao.queryRechargeByPageCount(timeChangeMap.get("startTime"), timeChangeMap.get("endTime"), pids, query.getOrderTime(), query.getUnlock());

        if (CollectionUtils.isEmpty(playerunits)) {
            return Result.buildSuccess().add("data", Collections.emptyList()).add("total", 0);
        }

        //4、查询相关信息
        List<Long> bookIds = playerunits.stream().map(playerunit -> Long.parseLong(String.valueOf(playerunit.getBookidx()))).collect(Collectors.toList());
        // 查询书本详情
        List<Bookresource> bookresources = bookresourceDao.batchQueryBookResourceInfosByIds(bookIds);
        Map<Long, Bookresource> bookresourceMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(bookresources)) {
            bookresourceMap = bookresources.stream().collect(Collectors.toMap(Bookresource::getBookId, v -> v, (k1, k2) -> k1));
        }
        Map<Long, Player> playerMap = new HashMap<>();
        List<Long> ids = playerunits.stream().map(Playerunit::getPid).collect(Collectors.toList());
        // 用户详情
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
        // 学习时长
        Map<String, PlayerLearnTimePO> playerLearnTimeMap = new HashMap<>();
        List<PlayerLearnTimePO> playerLearnTimePOS = playerLearnTimeDao.batchQueryPlayerLearnTimeInfoByPidAndBookIdx(poList);
        if(!CollectionUtils.isEmpty(playerLearnTimePOS)) {
            playerLearnTimeMap = playerLearnTimePOS.stream()
                    .collect(Collectors.toMap(playerLearnTimePO -> playerLearnTimePO.getPid() + "-" + playerLearnTimePO.getBookIdx(), v -> v, (v1, v2) -> v1));
        }

        // 5、VO转化
        final Map<Long, Bookresource> finalBookresourceMap = bookresourceMap;
        final Map<Long, Player> finalPlayerMap = playerMap;
        final Map<String, PlayerLearnTimePO> finalPlayerLearnTimeMap = playerLearnTimeMap;

        List<PlayerRechargeVO> playerRechargeVOS = playerunits.stream()
                .map(playerunit -> mapsToPlayerRechargeVO(playerunit, finalBookresourceMap, finalPlayerMap, finalPlayerLearnTimeMap))
                .collect(Collectors.toList());
        return Result.buildSuccess().add("data", playerRechargeVOS).add("total", total);
    }


    /**
     * VO转化
     *
     * @param playerunit
     * @param finalBookresourceMap
     * @param finalPlayerMap
     * @return org.spring.springboot.domain.game.playerunit.PlayerRechargeVO
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
                playerRechargeVO.setBookType(finalBookresourceMap.get(bookIndexLong).getBookType());
            }
            // 用户名填充
            if (finalPlayerMap.get(playerunit.getPid()) != null) {
                playerRechargeVO.setPlayerName(finalPlayerMap.get(playerunit.getPid()).getName());
            }
            PlayerLearnTimePO playerLearnTimePO = finalPlayerLearnTimeMap.get(playerunit.getPid() + "-" + playerunit.getBookidx());
            // 学习时长填充
            if (playerLearnTimePO != null && playerLearnTimePO.getTotalTime() != null) {
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
    public String addBookUnit(PlayerUnitQuery query) {
        Playerunit playerunit = new Playerunit();
        playerunit.setPid(query.getPid());
        long now = System.currentTimeMillis();
        playerunit.setCreatetime((int) (now / 1000));
        playerunit.setChannel(query.getChannel());
        playerunit.setBookidx(query.getBookIdx());
        List<Playerunit> playerunits = playerunitDao.selectByCondition(playerunit);
        if(!CollectionUtils.isEmpty(playerunits)) {
            return "已经有该本书了不能再添加了";
        }
        List<Bookresource> bookresources = bookresourceDao.fetchBookresourceInfosByBookId(String.valueOf(query.getBookIdx()));
        if(!CollectionUtils.isEmpty(bookresources)) {
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
        int insertNum = playerunitDao.insertSelective(playerunit);
        return insertNum > 0 ? null : "新增失败！";
    }

    @Override
    public void updateBookUnitUpdateTimeOrLearnTime(PlayerUnitLearnQuery query) {
        if(query.getRemainTime() != null) {
            Playerunit playerunit = new Playerunit();
            playerunit.setPid(query.getPid());
            playerunit.setBookidx(query.getBookIdx());
            List<Playerunit> playerUnitInfos = playerunitDao.selectByCondition(playerunit);
            if(!CollectionUtils.isEmpty(playerUnitInfos)) {
                Playerunit playerunitTemp = playerUnitInfos.get(0);
                playerunitTemp.setPeriod(query.getRemainTime());
                playerunitDao.updateByPrimaryKey(playerunitTemp);
            }
        }

        if(query.getLearnTime() != null) {
            PlayerLearnTimePO playerLearnTimePO = new PlayerLearnTimePO();
            playerLearnTimePO.setPid(query.getPid());
            playerLearnTimePO.setBookIdx(query.getBookIdx());
            List<PlayerLearnTimePO> playerLearnTimePOS = playerLearnTimeDao.batchQueryPlayerLearnTimeInfoByPidAndBookIdx(Collections.singletonList(playerLearnTimePO));
            if(!CollectionUtils.isEmpty(playerLearnTimePOS)) {
                PlayerLearnTimePO playerLearnTimePOTemp = playerLearnTimePOS.get(0);
                playerLearnTimePOTemp.setTotalTime(query.getLearnTime());
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
        if(!CollectionUtils.isEmpty(playerunits)){
            booIdxSet = playerunits.stream()
                    .map(item -> (long) item.getBookidx())
                    .collect(Collectors.toSet());
        }
        List<Bookresource> bookresources = bookresourceDao.fetchBookresourceInfos();
        if(CollectionUtils.isEmpty(bookresources)) {
            return Collections.emptyList();
        }

        Set<Long> finalBooIdxSet = booIdxSet;
        return bookresources.stream()
                .filter(bookresource -> !finalBooIdxSet.contains(bookresource.getBookId()))
                .map(bookresource -> {
                    Option option = new Option();
                    option.setLabel("【" + bookresource.getBookId() + "】" + bookresource.getName());
                    option.setValue(String.valueOf(bookresource.getBookId()));
                    return option;
                }).collect(Collectors.toList());
    }


    private Boolean checkUnlockShow(Long playerUnitId) {
        Playerunit playerunit = playerunitDao.selectByPrimaryKey(playerUnitId);
        Date bookDeadLineTime = getBookDeadLineTime(playerunit.getCreatetime(), playerunit.getPeriod());
        Date now = new Date();
        Date createTime = DateUtil.timeStampToDate(playerunit.getCreatetime(), LENGTH_10);
        return !now.after(bookDeadLineTime) && now.after(createTime);
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
