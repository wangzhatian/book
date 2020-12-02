package com.course.testng;

import org.testng.annotations.*;

/**
 * @author 小测试
 * @create 2020-11-25 21:57
 */
public class BeasicAnnotation {

    //最基本的注解，用来把方法标记位测试的一部分
    @Test
    public void testCase1() {
        System.out.println("这是测试用例1");
    }

    @Test(enabled = false)
    public void testCase2() {
        System.out.println("这是测试用例2");
    }

    @Ignore
    public void ignore(){
        System.out.println("不执行");
    }
    @BeforeMethod
    public void berforeMethod() {
        System.out.println("berforeMethod这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod这是在测试方法之后运行的");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass这是在测试类之前运行的");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("beforeClass这是在测试类之后运行的");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite测试套件");
    }

}
