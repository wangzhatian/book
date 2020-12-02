package com.http.exer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author 小测试
 * @create 2020-11-27 14:43
 */
public class HttpTest {
    String host = "https://buswash.jintdev.com/";
    //用来存放结果
    String result;

    @Test
    public void httpTest() throws IOException {
        String api = "safept/users/login";
        String url = host + api;
        //请求方法
        HttpGet get = new HttpGet("http://www.baidu.com");
        //执行
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
    }

    @Test
    public void http_with_cooike() {

    }
}
