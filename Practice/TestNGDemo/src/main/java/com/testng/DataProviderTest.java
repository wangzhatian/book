package com.testng;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author 小测试
 * @create 2020-11-26 23:40
 */
public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        Assert.assertEquals("aaa","bbb");
        Reporter.log("这是我们自己写的日志");
        System.out.println("name:" + name + ",\tage:" + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] objects = new Object[][]{
                {"张三", 10},
                {"李四", 20}
        };
    return objects;
    }
}
