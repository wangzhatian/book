package exer;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

/**
 * @author 小测试
 * @create 2020-11-27 10:19
 */
//风险点模块用例
@Story("风险点模块")
public class RiskTest {
    //添加风险点用例
    @Test(description = "添加风险点")
    public void  RiskSuccess(){
        System.out.println("添加风险点成功");
    }
    //添加风险点失败用例
    @Test(expectedExceptions = RuntimeException.class,description = "添加风险点")
    public void RiskError(){

        System.out.println("添加风险点失败");
        throw new RuntimeException();
    }
}
