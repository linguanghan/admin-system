package org.spring.springboot.service.impl;

import cn.hutool.core.collection.ListUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.enums.RoleEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.dao.pelbsData.PlayerDao;
import org.spring.springboot.dao.yldres.DailyActiveUserLogDao;
import org.spring.springboot.domain.pelbsData.DayPlayer;
import org.spring.springboot.domain.pelbsData.Player;
import org.spring.springboot.domain.pelbsData.vo.PageParamVo;
import org.spring.springboot.domain.user.UserHolder;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO;
import org.spring.springboot.service.PlayerService;
import org.spring.springboot.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 玩家业务逻辑实现类
 *
 * @Author : zhoubin
 * @Date : 2022-12-22 15:26
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);

    private static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String time_start_suffix = " 00:00:00";
    private static final String time_end_suffix = " 23:59:59";
    @Resource
    private PlayerDao playerDao;

    @Resource
    private DailyActiveUserLogDao dailyActiveUserLogDao;

    @Override
    public Integer findRegisterNum(Date dateTime) {
        if (RoleEnum.MANAGER.getCode().equals(UserHolder.getRole())) {
            return 0;
        }
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
            start = df.parse(t).getTime();
            end = df.parse(e).getTime();
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerDao.findRegisterNumBetweenDate(start, end);
    }

    @Override
    public Integer findRegisterNumMonth(Date dateTime) {
        if (RoleEnum.MANAGER.getCode().equals(UserHolder.getRole())) {
            return 0;
        }
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        if (null == dateTime) {
            dateTime = new Date();
        }
        Date firstDayOfMonth = this.getFirstDayOfMonth(dateTime);
        Date lastDayOfMonth = this.getLastDayOfMonth(dateTime);
        String t = df.format(firstDayOfMonth);
        String e = df.format(lastDayOfMonth);

        long start = 0;
        long end = 0;
        try {
            start = df.parse(t).getTime();
            end = df.parse(e).getTime();
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerDao.findRegisterNumBetweenDate(start, end);
    }

    @Override
    public Integer findRegisterNumBetweenDate(Date startTime, Date endTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String s = df.format(startTime);
        String e = df.format(endTime);
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime();
            end = df.parse(e).getTime();
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerDao.findRegisterNumBetweenDate(start, end);
    }

    @Override
    public List<Player> findRegisterDetail(Date dateTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String e = df.format(dateTime);
        String substring = e.substring(0, 10);
        String s = substring + time_start_suffix;
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime();
            end = df.parse(e).getTime();
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerDao.findRegistersBetweenDate(start, end);
    }

    @Override
    public Result<?> findRegisterDetailBetweenDate(PageParamVo vo) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String t = df.format(vo.getStartTime());
        String e = df.format(vo.getEndTime());
        long start = 0;
        long end = 0;
        try {
            start = df.parse(t).getTime();
            end = df.parse(e).getTime();
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }
        List<Player> playerList = playerDao.findRegistersBetweenDate(start, end);
        List<Player> playerListPage = ListUtil.page(vo.getPageNo() - 1, vo.getPageSize(), playerList);
        if (CollectionUtils.isEmpty(playerList)) {
            return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
        }
        return Result.buildSuccess().add("data", playerListPage).add("total", playerList.size());

    }

    @Override
    public List<DayPlayer> findRegisterNumGroupbyDate(Date startTime, Date endTime) {
        if(RoleEnum.MANAGER.getCode().equals( UserHolder.getRole())) {
            return Collections.emptyList();
        }
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
        List<DayPlayer> players = new ArrayList<>();
        List<DayPlayer> result = playerDao.findRegisterNumGroupbyDate(start, end);
        if (CollectionUtils.isEmpty(result)){
            for (String date:dates){
                players.add(new DayPlayer(date,0));
            }
        } else {
            Map<String, Integer> map = result.stream()
                    .collect(Collectors.toMap(DayPlayer::getTimedate, DayPlayer::getNum));
            for (String date:dates){
                int num = 0;
                if (map.containsKey(date)){
                    num = map.get(date);
                }
                players.add(new DayPlayer(date,num));
            }
        }

        return players;
    }

    @Override
    public List<DayPlayer> findRegisterNumGroupbyMonth(Date startTime, Date endTime) {
        if(RoleEnum.MANAGER.getCode().equals( UserHolder.getRole())) {
            return Collections.emptyList();
        }
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        // 获取startTime当月第一天和endTime当月最后一天时间
        Date firstDayOfMonth = this.getFirstDayOfMonth(startTime);
        Date lastDayOfMonth = this.getLastDayOfMonth(endTime);
        String s = df.format(firstDayOfMonth);
        String e = df.format(lastDayOfMonth);

        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime();
            end = df.parse(e).getTime();
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        List<String> dates = DateUtil.getBetweenMonths(s, e);
        List<DayPlayer> players = new ArrayList<>();
        List<DayPlayer> resultList = new ArrayList<>();
        List<DayPlayer> result = playerDao.findRegisterNumGroupbyDate(start, end);
        if (CollectionUtils.isEmpty(result)){
            for (String date:dates){
                players.add(new DayPlayer(date,0));
            }
        } else {
            // 按月汇总
            Map<String, Integer> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            for (DayPlayer dayPlayer : result) {
                String substring = dayPlayer.getTimedate().substring(0, 7);

                if (list.contains(substring)){
                    Integer i = map.get(substring);
                    Integer count = i + dayPlayer.getNum();
                    map.put(substring, count);
                    continue;
                }
                list.add(substring);
                map.put(substring, dayPlayer.getNum());
            }

            for (String date:dates){
                int num = 0;
                if (map.containsKey(date)){
                    num = map.get(date);
                }
                players.add(new DayPlayer(date,num));
            }

            Map<String, Integer> resultMap = players.stream()
                    .collect(Collectors.groupingBy(
                            DayPlayer::getTimedate, // 直接使用 getTimedate 作为分组的键
                            Collectors.summingInt(DayPlayer::getNum)
                    ));
            resultList = resultMap.entrySet().stream()
                    .map(entry -> new DayPlayer(entry.getKey(), entry.getValue()))
                    .sorted(Comparator.comparing(DayPlayer::getTimedate))
                    .collect(Collectors.toList());
        }

        return resultList;
    }

    @Override
    public Integer findActiveNum(Date dateTime) {
        if (RoleEnum.MANAGER.getCode().equals(UserHolder.getRole())) {
            return 0;
        }
        List<DailyActiveUserLogPO> dailyActiveUserLogPOS = dailyActiveUserLogDao.queryDailyActiveUserLog(dateTime, dateTime);
        if(CollectionUtils.isEmpty(dailyActiveUserLogPOS)){
            return 0;
        }
        return dailyActiveUserLogPOS.get(0).getActiveCount().intValue();
    }

    @Override
    public Integer findActiveNumMonth(Date dateTime) {
        if (RoleEnum.MANAGER.getCode().equals(UserHolder.getRole())) {
            return 0;
        }
        Date firstDayOfMonth = this.getFirstDayOfMonth(dateTime);
        Date lastDayOfMonth = this.getLastDayOfMonth(dateTime);
        List<DailyActiveUserLogPO> dailyActiveUserLogPOS = dailyActiveUserLogDao.queryDailyActiveUserLog(firstDayOfMonth, lastDayOfMonth);
        if(CollectionUtils.isEmpty(dailyActiveUserLogPOS)){
            return 0;
        }
        long sum = dailyActiveUserLogPOS.stream().mapToLong(DailyActiveUserLogPO::getActiveCount).sum();
        return (int) sum;
    }

    @Override
    public Integer findActiveNumBetweenDate(Date startTime, Date endTime) {
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String s = df.format(startTime);
        String e = df.format(endTime);
        long start = 0;
        long end = 0;
        try {
            start = df.parse(s).getTime() / 1000;
            end = df.parse(e).getTime();
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage(), pe);
        }

        return playerDao.findActiveNumBetweenDate(start, end);
    }

    @Override
    public List<Player> findActiveDetail(Date dateTime) {
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

        return playerDao.findActiveBetweenDate(start, end);
    }

    @Override
    public Result<?> findActiveDetailBetweenDate(PageParamVo vo) {
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

        List<Player> playerList = playerDao.findActiveBetweenDate(start, end);
        if(CollectionUtils.isEmpty(playerList)) {
            return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
        }
        List<Player> playerListPage = ListUtil.page(vo.getPageNo() - 1, vo.getPageSize(), playerList);
        return Result.buildSuccess().add("data", playerListPage).add("total", playerList.size());
    }

    @Override
    public List<DayPlayer> findActiveNumGroupbyDate(Date startTime, Date endTime) {
        if (RoleEnum.MANAGER.getCode().equals(UserHolder.getRole())) {
            return Collections.emptyList();
        }
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        String s = df.format(startTime);
        String e = df.format(endTime);
        List<String> dates = DateUtil.getBetweenDates(s, e);
        List<DayPlayer> players = new ArrayList<>();
        List<DailyActiveUserLogPO> dailyActiveUserLogPOS = dailyActiveUserLogDao.queryDailyActiveUserLog(startTime, endTime);
        if (CollectionUtils.isEmpty(dailyActiveUserLogPOS)) {
            for (String date : dates) {
                players.add(new DayPlayer(date, 0));
            }
        } else {
            Map<String, Long> map = dailyActiveUserLogPOS
                    .stream()
                    .collect(Collectors.toMap(DailyActiveUserLogPO::getCountTime, DailyActiveUserLogPO::getActiveCount, (k1, k2) -> k1));

            for (String date : dates) {
                long num = 0;
                if (map.containsKey(date)) {
                    num = map.get(date);
                }
                players.add(new DayPlayer(date, (int)num));
            }
        }

        return players;
    }

    @Override
    public List<DayPlayer> findActiveNumGroupbyMonth(Date startTime, Date endTime) {
        if (RoleEnum.MANAGER.getCode().equals(UserHolder.getRole())) {
            return Collections.emptyList();
        }
        DateFormat df = new SimpleDateFormat(FORMAT_PATTERN);
        // 获取startTime当月第一天和endTime当月最后一天时间
        Date firstDayOfMonth = this.getFirstDayOfMonth(startTime);
        Date lastDayOfMonth = this.getLastDayOfMonth(endTime);
        String s = df.format(firstDayOfMonth);
        String e = df.format(lastDayOfMonth);
        List<String> dates = DateUtil.getBetweenMonths(s, e);
        List<DayPlayer> players = new ArrayList<>();
        List<DayPlayer> resultList = new ArrayList<>();
        List<DailyActiveUserLogPO> dailyActiveUserLogPOS = dailyActiveUserLogDao.queryDailyActiveUserLog(firstDayOfMonth, lastDayOfMonth);
        if (CollectionUtils.isEmpty(dailyActiveUserLogPOS)) {
            for (String date : dates) {
                resultList.add(new DayPlayer(date, 0));
            }
        } else {
            // 按月汇总
            Map<String, Long> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            for (DailyActiveUserLogPO t : dailyActiveUserLogPOS) {
                String substring = t.getCountTime().substring(0, 7);

                if (list.contains(substring)) {
                    Long l = map.get(substring);
                    Long count = l + t.getActiveCount();
                    map.put(substring, count);
                    continue;
                }
                list.add(substring);
                map.put(substring, t.getActiveCount());

            }

            for (String date : dates) {
                long num = 0;
                if (map.containsKey(date)) {
                    num = map.get(date);
                }
                players.add(new DayPlayer(date, (int) num));
            }

            Map<String, Integer> result = players.stream()
                    .collect(Collectors.groupingBy(
                            DayPlayer::getTimedate, // 直接使用 getTimedate 作为分组的键
                            Collectors.summingInt(DayPlayer::getNum)
                    ));
            resultList = result.entrySet().stream()
                    .map(entry -> new DayPlayer(entry.getKey(), entry.getValue()))
                    .sorted(Comparator.comparing(DayPlayer::getTimedate))
                    .collect(Collectors.toList());
        }

        return resultList;
    }

    public Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);

        return calendar.getTime();
    }

    @Override
    public Player getPlayerInfoById(Long playerId) {
        List<Player> players = playerDao.batchQueryPlayerInfosById(Collections.singletonList(playerId));
        if(CollectionUtils.isEmpty(players)) {
            return null;
        }
        return players.get(0);
    }

//    @Override
//    public List<Player> findPlyersBetweenTime(Date startTime, Date endTime) {
//        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String t=df.format(startTime);
//        String e=df.format(endTime);
//        long start= 0;
//        long end= 0;
//        try {
//            start = df.parse(t).getTime();
//            end=df.parse(e).getTime();
//        } catch (ParseException exc) {
//            exc.printStackTrace();
//        }
//
//        return playerDao.findPlyersBetweenTime(start,end);
//    }
//
//    @Override
//    public Integer findPlyersBetweenTimeNum(Date startTime, Date endTime) {
//        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String t=df.format(startTime);
//        String e=df.format(endTime);
//        long start= 0;
//        long end= 0;
//        try {
//            start = df.parse(t).getTime();
//            end=df.parse(e).getTime();
//        } catch (ParseException exc) {
//            exc.printStackTrace();
//        }
//
//        return playerDao.findPlyersBetweenTimeNum(start,end);
//    }
//
//    @Override
//    public List<Player> findPlyersHistory(Date startTime, Date endTime) {
//        return findPlyersBetweenTime(startTime,endTime);
//    }
//
//    @Override
//    public List<Player> findPlyersCurrent(Date startTime) {
//        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String t=df.format(startTime);
//        String substring = t.substring(0, 10);
//        String e=substring + " 00:00:00";
//        long start= 0;
//        long end= 0;
//        try {
//            start = df.parse(t).getTime();
//            end=df.parse(e).getTime();
//        } catch (ParseException exc) {
//            exc.printStackTrace();
//        }
//
//        return playerDao.findPlyersBetweenTime(end,start);
//    }
//
//    @Override
//    public Integer findPlyersHistoryNum(Date startTime, Date endTime) {
//        return findPlyersBetweenTimeNum(startTime,endTime);
//    }
//
//    @Override
//    public Integer findPlyersCurrentNum(Date startTime) {
//        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        if (null == startTime) {
//            startTime = new Date();
//        }
//        String t = df.format(startTime);
//        String substring = t.substring(0, 10);
//        String e = substring + " 23:59:59";
//        t = substring + " 00:00:00";
//        long start = 0;
//        long end = 0;
//        try {
//            start = df.parse(t).getTime();
//            end=df.parse(e).getTime();
//        } catch (ParseException exc) {
//            exc.printStackTrace();
//        }
//
//        return playerDao.findPlyersBetweenTimeNum(start,end);
//    }
//
//    @Override
//    public List<DayPlayer> findPlyersHistoryNumLast30Days() {
//        Date date = new Date();
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        c.add(Calendar.DATE,-30);
//        Date endDate = c.getTime();
//        System.out.println(date);
//        System.out.println(endDate);
//        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String t=df.format(date);
//        String e=df.format(endDate);
//        String substring = e.substring(0, 10);
//        e = substring + " 00:00:00";
//        long start= 0;
//        long end= 0;
//        try {
//            start = df.parse(t).getTime();
//            end=df.parse(e).getTime();
//        } catch (ParseException exc) {
//            exc.printStackTrace();
//        }
//
//        return playerDao.findPlyersHistoryNumLast30Days(end, start);
//    }

}
