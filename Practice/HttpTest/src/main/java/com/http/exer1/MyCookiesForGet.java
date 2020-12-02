package com.http.exer1;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author 小测试
 * @create 2020-11-29 22:32
 */
public class MyCookiesForGet {
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
    public void testGetWith() throws IOException {
        String result;
        String testUrl;
        testUrl = this.url + bundle.getString("getWithCookies");
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);

        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("状态码：" + statusCode);
        if (statusCode == 200) {
            result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }

    }
}
