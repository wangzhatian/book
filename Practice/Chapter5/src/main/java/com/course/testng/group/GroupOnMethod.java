package com.course.testng.group;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @author 小测试
 * @create 2020-11-25 23:53
 */
public class GroupOnMethod {

    @Test(groups = "server")
    public void test1() {
        System.out.println("这是server用例1");
    }

    @Test(groups = "server")
    public void test2() {
        System.out.println("这是server用例2");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("这是client用例1");
    }

    @BeforeGroups()
    public void beforeGroupsOnServer() {
        System.out.println("这是服务端组运行之前运行的方法");
    }
}
