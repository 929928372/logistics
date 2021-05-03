package edu.scau.software.utils;

import java.text.DateFormat;
import java.util.Date;

public class TimeUtils {
    private static String currentTime(){
        /**
         * 获取系统时间
         */
        Date date=new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        return dateFormat.format(date);
    }

    public static long autoNumber(){
        /**
         * 获取时间戳
         */
        Date date = new Date();
        long time = date.getTime();
        return time;
    }

    public static void main(String[] args) {
        System.out.println(currentTime());
        System.out.println(autoNumber());
    }
}
