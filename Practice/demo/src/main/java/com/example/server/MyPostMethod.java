package com.example.server;

import com.example.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 小测试
 * @create 2020-12-01 17:23
 */
@RestController
@Api(value = "/", description = "这是我全部的post请求")
@RequestMapping("/v1")
public class MyPostMethod {
    //这个变量是用来存储cookies信息的
    private Cookie cookie;

    //用户登录成功，获取cookies，然后再访问其他接口获取列表
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookie信息")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String useName,
                        @RequestParam(value = "passWord", required = false) String passWord) {
        if (useName.equals("zhangsan") && passWord.equals("123456")) {
            cookie = new Cookie("login", "trun");
            response.addCookie(cookie);
            return "登录成功";
        } else {
            return "用户名或者密码错误";
        }
    }

    @RequestMapping(value = "/get/user/list", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User user) {
        User user1 = new User();
        //获取cookies
        Cookie[] cookie = request.getCookies();
        //验证cookie是否合法
        for (Cookie cookie1 : cookie) {
            if (cookie1.getName().equals("login" ) && cookie1.getValue().equals("trun") ) {
                user1.setName("lisi");
                user1.setAge("14");
                user1.setSex("man");
                return user1.toString();
            }
        }
        return  "参数不合法";
    }
}
