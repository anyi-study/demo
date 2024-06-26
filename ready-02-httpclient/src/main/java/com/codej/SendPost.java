package com.codej;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SendPost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的ip");
        String ip = scanner.next();
//        创建httpclient对象
        CloseableHttpClient c = HttpClients.createDefault();
//        创建url字符串地址
        String url="https://restapi.amap.com/v3/ip";
        HttpPost httpPost = new HttpPost(url);
//        准备post参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        添加参数  BasicNameValuePair 实现了NameValuePair接口
//                  BasicNameValuePair(参数名，参数值)
        params.add(new BasicNameValuePair("key","0113a13c88697dcea6a445584d535837"));
//        params.add(new BasicNameValuePair("ip","113.68.11.193"));
        params.add(new BasicNameValuePair("ip",ip));
        try {
//        设置HttpPost使用设置
            httpPost.setEntity(new UrlEncodedFormEntity(params));
//            执行
            CloseableHttpResponse response = c.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String json = EntityUtils.toString(response.getEntity());
                System.out.println(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                c.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
