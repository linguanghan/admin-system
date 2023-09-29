package org.spring.springboot.util;

import java.text.SimpleDateFormat;
import java.util.*;

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

    public static void main(String[] args) {
        List<String> betweenDates = getBetweenDates("2023-01-01 11:11:11", "2023-01-10");
        for (String s:betweenDates){
            System.out.println(s);
        }
    }

}
