package org.spring.springboot.util;

import cn.hutool.core.date.DateTime;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 *
 * @Author : zhoubin
 * @Date : 2023-01-10 01:07
 */
public class DateUtil {

    private static final String LENGTH_13 = "LENGTH_13";

    private static final String LENGTH_10 = "LENGTH_10";



    /**
     * 获取两个日期之间的所有日期 (年月日)
     * @param start
     * @param end
     * @return
     */
    public static List<String> getBetweenDates(String start, String end) {
        List<String> result = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (start.length()>10){
                start = start.substring(0,10);
            }
            if (end.length()>10){
                end = end.substring(0,10);
            }
            Date start_date = sdf.parse(start);
            Date end_date = sdf.parse(end);
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start_date);
            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end_date);
            while (tempStart.before(tempEnd)||tempStart.equals(tempEnd)) {
                result.add(sdf.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 获取两个月份之间的所有月份 (年月)
     * @param start
     * @param end
     * @return
     */
    public static List<String> getBetweenMonths(String start, String end) {
        List<String> result = new ArrayList<>();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");  // 修改格式化器，仅包含年和月
            YearMonth startMonth = YearMonth.parse(start.substring(0, 7), formatter);
            YearMonth endMonth = YearMonth.parse(end.substring(0, 7), formatter);

            if (startMonth.isAfter(endMonth)) {
                throw new IllegalArgumentException("开始月份不能晚于结束月份");
            }

            YearMonth current = startMonth;
            while (!current.isAfter(endMonth)) {
                result.add(current.format(formatter));  // 使用适合 YearMonth 的格式化器
                current = current.plusMonths(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 时间戳转时间字符串
     *
     * @return java.lang.String
     * @author 13540
     * @date 2023-09-03 17:05
     */
    public static Date timeStampToDate(Integer timeStamp, String type) {

        if (timeStamp == null) {
            return new Date();
        }
        if (LENGTH_13.equals(type)) {
            return new Date(timeStamp);
        }
        if (LENGTH_10.equals(type)) {
            return new Date(timeStamp * 1000L);
        }
        return new Date();
    }


    public static Long dateToTimeStamp(Date date, String type) {
        if(date == null) {
            return null;
        }

        if (LENGTH_13.equals(type)) {
            return date.getTime();
        }
        if (LENGTH_10.equals(type)) {
            return date.getTime() / 1000;
        }

        return null;

    }

    public static String timeStamp2Str(long timeStamp, String type) {
        if(timeStamp == 0) {
            return "-";
        }
        if(LENGTH_10.equals(type)) {
            timeStamp = timeStamp * 1000;
        }
        DateTime date = cn.hutool.core.date.DateUtil.date(timeStamp);
        return cn.hutool.core.date.DateUtil.formatDateTime(date);
    }

    public static void main(String[] args) {
        List<String> betweenDates = getBetweenDates("2023-01-01 11:11:11", "2023-01-10");
        for (String s:betweenDates){
            System.out.println(s);
        }
    }

}
