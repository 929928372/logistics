package edu.scau.software.test.utils;

import edu.scau.software.utils.JdbcUtils;
import org.junit.Test;

import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;

public class JdbcUtilsTest {

    @Test
    public void getConnection() {
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
        JdbcUtils.close(connection);
    }

    @Test
    public void test(){
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(null);
//        list.add(null);
//        list.add(null);
//        System.out.println(list.size());
        fun(null);
    }

    public void fun(Integer a){
        System.out.println(a);
    }
}