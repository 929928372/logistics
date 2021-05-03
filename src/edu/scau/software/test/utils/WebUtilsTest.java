package edu.scau.software.test.utils;

import edu.scau.software.utils.WebUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebUtilsTest {

    @Test
    public void getRandomString() {
        for (int i = 0; i < 100; i++) {
            System.out.println(WebUtils.getRandomString(15));
        }
    }
}