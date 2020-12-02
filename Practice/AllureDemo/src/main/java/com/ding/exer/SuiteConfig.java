package com.ding.exer;

import org.testng.annotations.*;

/**
 * @author 小测试
 * @create 2020-11-27 10:18
 */
public class SuiteConfig {
    @BeforeSuite
    public void login() {
        System.out.println("登录成功");
    }

    @AfterSuite
    public void logout() {
        System.out.println("退出成功");
    }

    @BeforeTest
    public void conntionSql() {
        System.out.println("连接数据库成功");

    }

    @AfterTest
    public void disconnectSql() {
        System.out.println("断开数据库连接");
    }
}
