package com.example.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小测试
 * @create 2020-11-30 23:09
 */
@RestController
@Api(tags = "组织管理")
public class MyGetMethod {

    @ApiOperation(value = "获取组织",httpMethod = "GET",code = 200)
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getCookies() {
        return "恭喜你获得cookie成功";
    }
}
