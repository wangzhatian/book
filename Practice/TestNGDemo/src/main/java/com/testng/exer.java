package com.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author 小测试
 * @create 2020-11-26 17:47
 */
public class exer {
    @Test(expectedExceptions = RuntimeException.class)
    public void testCase1() {
        System.out.println("测试用例1执行");
    }

    @Test(dependsOnMethods = {"testCase1"})
    public void testCase2() {
        System.out.println("测试用例2执行");
    }
    @Test(expectedExceptions=RuntimeException.class)
    public void testCase3(){
        System.out.println("异常测试");
        throw new RuntimeException();
    }

}
