package edu.hrbust.common.utils;

import org.junit.Test;
import org.junit.runner.RunWith;


public class HttpRequestUtilsTest {
    @Test
    public void doGet() {
        String s = HttpRequestUtils.doGet("https://www.baidu.com");
        System.out.println(s);
    }
}
