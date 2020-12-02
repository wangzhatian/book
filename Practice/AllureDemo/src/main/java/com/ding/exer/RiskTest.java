package com.ding.exer;

import org.testng.annotations.Test;

import java.security.PublicKey;

/**
 * @author 小测试
 * @create 2020-11-27 10:19
 */
//风险点模块用例

public class RiskTest {
    //添加风险点用例
    @Test
    public void  RiskSuccess(){
        System.out.println("添加风险点成功");
    }
    //添加风险点失败用例
    @Test(expectedExceptions = RuntimeException.class)
    public void RiskError(){
        System.out.println("添加风险点失败");
        throw new RuntimeException();
    }
}
