package edu.scau.software.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

public class WebUtils {
    // request参数转为javaBean
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    //    字符串转为整形
    public static int parseInt(String strInt, int defaultValue) {
        try {
            if (strInt != null) {
                return Integer.parseInt(strInt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    //    随机产生订单号
    public static String getRandomString(int length) {
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            if (i == 0) {
                while (number >= 0 && number <= 9){
                    number=random.nextInt(62);
                }
            }
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    // ISO-8859-1转UTF-8
    public static String toUTF8(String str) throws UnsupportedEncodingException {
        if (str == null)
            return null;
        return new String(str.getBytes("ISO-8859-1"), "utf-8");
    }

    // UTF-8转ISO-8859-1
    public static String toISO(String str) throws UnsupportedEncodingException {
        if (str == null)
            return null;
        return new String(str.getBytes("utf-8"), "ISO-8859-1");
    }
}
