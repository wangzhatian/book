package com.testng.exer1;

import org.testng.annotations.Test;

/**
 * @author 小测试
 * @create 2020-11-26 18:11
 */
public class RiskCase {
    @Test
    public void addRiskSuccee() {
        System.out.println("添加风险点成功");
    }

    @Test
    public void addRiskError() {
        System.out.println("添加风险点失败");
    }
}
