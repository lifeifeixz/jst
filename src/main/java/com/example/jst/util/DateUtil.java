package com.example.jst.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static final Date standard_start = stringToDate("2018-04-01 08:00:00", "yyyy-MM-dd HH:mm:ss");
    public static final Date standard_end = stringToDate("2018-04-02 08:00:00", "yyyy-MM-dd HH:mm:ss");
    public static final String date_format = "yyyy-MM-dd HH:mm:ss";

    public static Date stringToDate(String str, String partten) {
        SimpleDateFormat sdf = new SimpleDateFormat(partten);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object splitTime(Date startTime, Date endTime) {
        if (startTime.getTime() > standard_start.getTime()) {

        }
        return null;
    }

    /**
     * 作者：燕齐
     * 链接：https://www.jianshu.com/p/b505b97ccce2
     * 来源：简书
     * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
     *
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */
    public static long countDateIntersection(Date start1, Date end1, Date start2, Date end2) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        long s1 = 0;
        long s2 = 0;
        long e1 = 0;
        long e2 = 0;
        try {
            //标准化到1970-01-01
            s1 = sdf2.parse(sdf2.format(start1)).getTime();
            s2 = sdf2.parse(sdf2.format(start2)).getTime();
            e1 = sdf2.parse(sdf2.format(end1)).getTime();
            e2 = sdf2.parse(sdf2.format(end2)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!(s2 > e1 || s1 > e2)) {
            long s = s1 > s2 ? s1 : s2;
            long e = e1 < e2 ? e1 : e2;
            return e - s;
        }
        return 0;
    }

    public static Date structDate(String day, String time) {
        SimpleDateFormat sdf = new SimpleDateFormat(date_format);
        try {
            return sdf.parse(day + " " + time + ":00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date structDate(Date date, String time) {
        SimpleDateFormat sdf = new SimpleDateFormat(date_format);
        try {
            return sdf.parse(dateToShortString(date) + " " + time + ":00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date dateToShortDate(Date date) {
        return parse(date, "yyyy-MM-dd");
    }

    public static String dateToShortString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static Date parse(Date date, String partten) {
        SimpleDateFormat sdf = new SimpleDateFormat(partten);
        SimpleDateFormat targetSdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        try {
            return targetSdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将时间点转换成时间戳
     * <p>
     * 作者：ru_li
     * 来源：CSDN
     * 原文：https://blog.csdn.net/ru_li/article/details/51755386
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     * </p>
     *
     * @param time
     * @return
     */
    public static Long conventTimeToStamp(String time) {
        Date date = DateUtil.structDate("1970-11-11", time);
        return date.getTime();
    }


    /**
     * ---------------------
     * 作者：xWilson
     * 来源：CSDN
     * 原文：https://blog.csdn.net/hfasdh/article/details/79659175
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     *
     * @param stime1
     * @param etime1
     * @param stime2
     * @param etime2
     * @return
     */
    public static Long calcuTimeSectionIntersection(Date stime1, Date etime1, Date stime2, Date etime2) {
        long f = 0L;
        long lst = stime1.getTime();
        long let = etime1.getTime();

        long rst = stime2.getTime();
        long ret = etime2.getTime();

        if (lst > let || rst > ret) {
//            throw new Exception("起始时间不能大于结束时间");
            return f;
        }

        if (let <= rst || lst >= ret) {
            return f;
        }

        long[] a = {lst, let, rst, ret};
        Arrays.sort(a); //从小到大排序，取第二、第三计算
        f = a[2] - a[1];
        return f;
    }

    /**
     * 日期加减
     *
     * @param date
     * @param days
     * @return
     */
    public static Date datePlus(Date date, Integer days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, days == null ? 1 : days);// 今天+N天
        return c.getTime();
    }

    public static void main(String[] args) {

    }
}
