package zl.readCloud.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ZhangLei
 * @Description: 日期工具类
 */
@Component
public class DateUtils {

    /**
     * 获得当前日期 yyyy-MM-dd HH:mm:ss.SSS
     *
     * @return 2019-08-27 14:12:40.019
     */
    public static String getCurrentTime() {
        // 小写的hh取得12小时，大写的HH取的是24小时
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        return df.format(date);
    }

    /**
     * 获取系统当前时间戳
     *
     * @return 1566889186583
     */
    public static String getSystemTime() {
        String current = String.valueOf(System.currentTimeMillis());
        return current;
    }


    /**
     * 获取当前日期 yy-MM-dd
     *
     * @return 2019-08-27
     */
    public static String getDateByString() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 得到两个时间差  格式yyyy-MM-dd HH:mm:ss
     *
     * @param start 2019-06-27 14:12:40
     * @param end   2019-08-27 14:12:40
     * @return 5270400000
     */
    public static long dateSubtraction(String start, String end) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = df.parse(start);
            Date date2 = df.parse(end);
            return date2.getTime() - date1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 得到两个时间差
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public static long dateTogether(Date start, Date end) {
        return end.getTime() - start.getTime();
    }

    /**
     * 转化long值的日期为yyyy-MM-dd  HH:mm:ss.SSS格式的日期
     *
     * @param millSec 日期long值  5270400000
     * @return 日期，以yyyy-MM-dd  HH:mm:ss.SSS格式输出 1970-03-03  08:00:00.000
     */
    public static String transferLongToDate(String millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSS");
        Date date = new Date(Long.parseLong(millSec));
        return sdf.format(date);
    }

    /**
     * 获得当前日期 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getOkDate(String date) {
        try {
            if (StringUtils.isEmpty(date)) {
                return null;
            }
            Date date1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH).parse(date);
            //格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取当前日期是一个星期的第几天
     *
     * @return 2
     */
    public static int getDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }


    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime     当前时间
     * @param dateSection 时间区间   2018-01-08,2019-09-09
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, String dateSection) {
        try {
            String[] times = dateSection.split(",");
            String format = "yyyy-MM-dd";
            Date startTime = new SimpleDateFormat(format).parse(times[0]);
            Date endTime = new SimpleDateFormat(format).parse(times[1]);
            if (nowTime.getTime() == startTime.getTime()
                    || nowTime.getTime() == endTime.getTime()) {
                return true;
            }
            Calendar date = Calendar.getInstance();
            date.setTime(nowTime);

            Calendar begin = Calendar.getInstance();
            begin.setTime(startTime);

            Calendar end = Calendar.getInstance();
            end.setTime(endTime);

            if (isSameDay(date, begin) || isSameDay(date, end)) {
                return true;
            }
            if (date.after(begin) && date.before(end)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    public static long getTimeByDate(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(time);
            //日期转时间戳（毫秒）
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取当前小时 ：2019-08-23 17
     *
     * @return 2019-08-27 17
     */
    public static String getCurrentHour() {
        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 10) {
            return DateUtils.getCurrentTime() + " 0" + hour;
        }
        return DateUtils.getDateByString() + " " + hour;
    }

    /**
     * 获取当前时间一个小时前
     *
     * @return 2019-08-27 16
     */
    public static String getCurrentHourBefore() {
        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour > 0) {
            hour = calendar.get(Calendar.HOUR_OF_DAY) - 1;
            if (hour < 10) {
                return DateUtils.getDateByString() + " 0" + hour;
            }
            return DateUtils.getDateByString() + " " + hour;
        }
        //获取当前日期前一天
        return DateUtils.getBeforeDay() + " " + 23;
    }

    /**
     * 获取当前日期前一天
     *
     * @return 2019-08-26
     */
    public static String getBeforeDay() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return sdf.format(date);
    }


    /**
     * 获取最近七天
     *
     * @return 2019-08-20
     */
    public static String getServen() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        c.add(Calendar.DATE, -7);

        Date monday = c.getTime();

        String preMonday = sdf.format(monday);

        return preMonday;
    }

    /**
     * 获取最近一个月
     *
     * @return 2019-07-27
     */
    public static String getOneMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        c.add(Calendar.MONTH, -1);

        Date monday = c.getTime();

        String preMonday = sdf.format(monday);

        return preMonday;
    }

    /**
     * 获取最近三个月
     *
     * @return 2019-05-27
     */
    public static String getThreeMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        c.add(Calendar.MONTH, -3);

        Date monday = c.getTime();

        String preMonday = sdf.format(monday);

        return preMonday;
    }

    /**
     * 获取最近一年
     *
     * @return 2018-08-27
     */
    public static String getOneYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        Date start = c.getTime();
        String startDay = sdf.format(start);
        return startDay;
    }


    private static int month = Calendar.getInstance().get(Calendar.MONTH) + 1;

    /**
     * 获取今年月份数据
     * 说明 有的需求前端需要根据月份查询每月数据，此时后台给前端返回今年共有多少月份
     *
     * @return [1, 2, 3, 4, 5, 6, 7, 8]
     */
    public static List getMonthList() {
        List list = new ArrayList();
        for (int i = 1; i <= month; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 返回当前年度季度list
     * 本年度截止目前共三个季度，然后根据1,2,3分别查询相关起止时间
     *
     * @return [1, 2, 3]
     */
    public static List getQuartList() {
        int quart = month / 3 + 1;
        List list = new ArrayList();
        for (int i = 1; i <= quart; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.getQuartList());
    }
}

