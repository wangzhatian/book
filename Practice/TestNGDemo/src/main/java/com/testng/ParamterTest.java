package com.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author 小测试
 * @create 2020-11-26 23:28
 */
public class ParamterTest {
    @Test
    @Parameters({"name","age"})
    public void paramterTest(String name,int age) {
        System.out.println("name:"+name+"\tage:"+age);
    }
}
