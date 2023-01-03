package com.xiaoniucr.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {


    public static final String DATE_PATTERN = "yyyy-MM-dd";


    /**
     * 时间格式化成字符串
     *
     * @param date    Date
     * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN， 如果为空，则为yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static String dateFormat(Date date, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            pattern = DateUtils.DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 字符串解析成时间对象
     *
     * @param dateTimeString String
     * @param pattern        StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN，如果为空，则为yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date dateParse(String dateTimeString, String pattern){
        if (StringUtils.isEmpty(pattern)) {
            pattern = DateUtils.DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }




    public static int getAgeByBirth(Date birthday) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = sdf.parse(sdf.format(birthday));
            //Calendar：日历
            /*从Calendar对象中或得一个Date对象*/
            Calendar cal = Calendar.getInstance();
            /*把出生日期放入Calendar类型的bir对象中，进行Calendar和Date类型进行转换*/
            Calendar bir = Calendar.getInstance();
            bir.setTime(birthday);
            /*如果生日大于当前日期，则抛出异常：出生日期不能大于当前日期*/
            if(cal.before(birthday)){
                throw new IllegalArgumentException("The birthday is before Now,It's unbelievable");
            }
            /*取出当前年月日*/
            int yearNow = cal.get(Calendar.YEAR);
            int monthNow = cal.get(Calendar.MONTH);
            int dayNow = cal.get(Calendar.DAY_OF_MONTH);
            /*取出出生年月日*/
            int yearBirth = bir.get(Calendar.YEAR);
            int monthBirth = bir.get(Calendar.MONTH);
            int dayBirth = bir.get(Calendar.DAY_OF_MONTH);
            /*大概年龄是当前年减去出生年*/
            int age = yearNow - yearBirth;
            /*如果出当前月小与出生月，或者当前月等于出生月但是当前日小于出生日，那么年龄age就减一岁*/
            if(monthNow < monthBirth || (monthNow == monthBirth && dayNow < dayBirth)){
                age--;
            }
            return age;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;

    }


    /**
     * 获取过去5年
     */
    public static Integer[] getPastYear(int num) {
        Integer[] lastYears = new Integer[num];
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < num; i++) {
            lastYears[(num-1) - i] = cal.get(Calendar.YEAR);
            cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 1); //逐次往前推1个月
        }
        return lastYears;
    }


    /**
     * 通过秒毫秒数判断两个时间的间隔的天数
     * @param min
     * @param max
     * @return
     */
    public static int differDays(Date min,Date max)
    {
        int days = (int) ((max.getTime() - min.getTime()) / (1000*3600*24));
        return days;
    }



    /**
     * 获取过去12个月
     */
    public static String[] getLast12Months() {
        String[] last12Months = new String[12];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1); //要先+1,才能把本月的算进去
        for (int i = 0; i < 12; i++) {
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
            last12Months[11 - i] = cal.get(Calendar.YEAR) + "-" + fillZero((cal.get(Calendar.MONTH) + 1));
        }
        return last12Months;
    }


    /**
     * 获取某年某月的最后一天
     * @return
     *
     */
    public static String getLastDayOfMonth(Date month)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(month);
        cal.add(Calendar.MONTH,1);//月增加1天
        cal.add(Calendar.DAY_OF_MONTH,-1);//日期倒数一日,既得到本月最后一天
        return DateUtils.dateFormat(cal.getTime(),DateUtils.DATE_PATTERN);
    }


    /**
     * 获取某年某月的第一天
     * @param month
     * @return
     */
    public static String getFisrtDayOfMonth(Date month)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(month);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return DateUtils.dateFormat(cal.getTime(),DateUtils.DATE_PATTERN);
    }


    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static String getFirstDayOfYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return DateUtils.dateFormat(currYearFirst,"yyyy-MM-dd");
    }

    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static String getLastDayOfYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return DateUtils.dateFormat(currYearLast,"yyyy-MM-dd");
    }


    /**
     * 格式化月份
     */
    public static String fillZero(int i){
        String month = "";
        if(i<10){
            month = "0" + i;
        }else{
            month = String.valueOf(i);
        }
        return month;
    }


}
