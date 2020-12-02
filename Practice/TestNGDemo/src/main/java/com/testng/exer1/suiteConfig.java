package com.testng.exer1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @author 小测试
 * @create 2020-11-26 18:02
 */
public class suiteConfig {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite  case :登录成功");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite case：退出成功");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest 读取用例");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest 测试结果");

    }
}
