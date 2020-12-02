package com.http.exer1;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author 小测试
 * @create 2020-11-29 23:03
 */

public class MyCookiesForPost {
    private String url;
    private String uri;
    private ResourceBundle bundle;
    //用来存储cookie信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
        uri = bundle.getString("getCookies.uri");

    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        HttpGet get = new HttpGet(this.url + this.uri);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //获取cookie信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = this.store.getCookies();
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name:" + name);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostCookies() throws IOException{
//                "name": "huhansan",
//        "age": "18"
        String testUrl = this.url + bundle.getString("post.with.cookie");
        System.out.println(testUrl);

        //声明一个client对象，进行方法
        DefaultHttpClient client=new DefaultHttpClient();
        //声明post方法
        HttpPost post= new HttpPost(testUrl);
        //添加参数
        org.json.JSONObject jsonObject=new org.json.JSONObject();
        jsonObject.put("name","huhansan");
        jsonObject.put("age","18");
        //设置请求头信息
//        post.setHeader();
        //将参数信息添加到方法中
        StringEntity entity=new StringEntity(jsonObject.toString(),"utf-8");
        post.setEntity(entity);
        //设置存储响应结果
        String result;
        //设置cookie信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response=client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        //处理结果，是否达到预期
        //将返回的响应结果字符串转化为json对象
        org.json.JSONObject resultJson=new org.json.JSONObject(result);

        //具体的判断返回结果的值获取的结果值
        System.out.println(resultJson.toString());
        String success=(String) resultJson.get("name");
        System.out.println(success);
        Assert.assertEquals("huhansan",success);
    }
}
