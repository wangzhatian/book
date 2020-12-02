package com.ding.exer;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author 小测试
 * @create 2020-11-27 10:18
 */
public class UserTest {

    @Test(description = "用户管理")
    public void addUserSuccess() {
        System.out.println("添加用户成功");
        Assert.assertEquals("123","123");
    }
    @Test(expectedExceptions=RuntimeException.class)
    public void addUserError() {
        System.out.println("添加用户失败");
        throw new  RuntimeException();
    }
    @BeforeClass
    public void readCase(){
        System.out.println("读取用例成功");
    }
    @AfterClass
    public void writeResult(){
        System.out.println("写入测试结果成功");
    }
}
