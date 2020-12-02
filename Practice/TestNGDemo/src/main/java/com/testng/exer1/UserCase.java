package com.testng.exer1;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @author 小测试
 * @create 2020-11-26 18:06
 */
public class UserCase {
    //@Test(enabled = false)
    @Test(groups = "add")
    public void addUserSuccee() {
        System.out.println("添加用户成功");
    }

    @Test(groups = "add")
    public void addUserError() {
        System.out.println("添加用户失败");
    }

    @Test(groups = "del")
    public void delUserSuccee() {
        System.out.println("删除用户成功");
    }

    @Test(groups = "del")
    public void delUserError() {
        System.out.println("删除用户失败");
    }
    @BeforeGroups(groups = "add")
    public void groupsOnAddCase(){
        System.out.println("groupsOnAddCase 添加接口用例组执行 ");
    }
    @BeforeGroups(groups = "del")
    public void groupsOnDelCase(){
        System.out.println("groupsOnAddCase 删除接口用例组执行 ");
    }
}
