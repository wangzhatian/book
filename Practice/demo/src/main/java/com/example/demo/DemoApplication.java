
package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootApplication
@RestController
@ComponentScan("com.example")

@Api(tags = "用户管理")
public class DemoApplication {
    private Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @ApiOperation(value = "/")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


//    @GetMapping("/get/cookies")
    @RequestMapping(value = "/get/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookie", httpMethod = "GET")
    public String getCookies(HttpServletResponse respon) {
        //httpserverletrequest,装请求的类
        //httpserverletreqponse 装响应的类
        Cookie cookie = new Cookie("login", "trun");
        respon.addCookie(cookie);

        return "恭喜你获得cookie成功";
    }

    @ApiOperation(value = "要求客户端携带cookie访问", httpMethod = "GET")
//        要求客户端携带cookie访问
//    @GetMapping("/get/with/cookies")
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带cookie信息来";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") &&
                    cookie.getValue().equals("trun")) {
                return "恭喜你访问成功！";
            }
        }
        return "你必须携带cookie信息来";
    }

    @ApiOperation(value = "需要携带参数才能访问的get请求", httpMethod = "GET", notes = "需要携带参数才能访问的get请求")
    //需要携带参数才能访问的get请求
//    @GetMapping("/get/list")
    @RequestMapping(value = "/get/list",method = RequestMethod.GET)
    public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end) {
        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋子", 400);
        myList.put("小浣熊", 1);
        myList.put("衬衫", 300);
        return myList;
    }

//    @GetMapping("/v2/request")
    @ApiOperation(value = "用户登录",httpMethod = "POST")
    @RequestMapping(value = "/v2/request",method = RequestMethod.GET)
    public Object testPage1(int from, int size) {
        map.clear();
        map.put("from", from);
        map.put("size", size);
        return map;
    }

//    @GetMapping("/v2/request_page")
    @ApiOperation(value = "用户登出",httpMethod = "GET")
    @RequestMapping(value = "/v2/request_page",method = RequestMethod.GET)
    public Object testPage2(@RequestParam(defaultValue = "0", name = "page") int from, int size) {
        map.clear();
        map.put("from", from);
        map.put("size", size);
        return map;
    }
}

