package exer;

import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author 小测试
 * @create 2020-11-27 10:18
 */
@Story("用户管理模块")
public class UserTest {
    @Test(description = "添加用户成功")
    public void addUserSuccess() {
        System.out.println("添加用户成功");
        Assert.assertEquals("123","123");
    }
    @Test(expectedExceptions=RuntimeException.class,description = "添加用户失败")
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
