package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @author 小测试
 * @create 2020-11-25 23:16
 */
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite运行了");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite运行了");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest执行");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest执行");
    }
}
