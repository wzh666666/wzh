package com.juzheng.util;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * http请求
 */
//主要用于企业微信请求接口
public class HttpUtil {
    /**
     * 通过路径获取请求结果（返回json）
     * @param url 路径
     * @return json
     */
    public static JSONObject get(String url){
        JSONObject body=null;
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
            InputStream is = http.getInputStream();
//            int size = is.available();
////            System.out.println(size);
//            byte[] jsonBytes = new byte[size];
            byte[] jsonBytes = new byte[1024];
            int len=0;
            String message="";
            while((len=is.read(jsonBytes))!=-1){
                message=message+new String(jsonBytes,0,len);
            }
//            is.read(jsonBytes);
//            String message = new String(jsonBytes, "UTF-8");
            System.out.println(message);
            body =JSONObject.fromObject(message);
//            System.out.println(body);
            is.close();
        } catch (IOException e) {
            //e.printStackTrace();
        } 
        return body;
    }

    /**
     * post请求通过路径获取请求结果（返回json）
     * @param url 路径
     * @return json
     */
    public static JSONObject postBody(String url,JSONObject param){
        JSONObject body=null;
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            byte[] byteArray = param.toString().getBytes("UTF-8");
            http.setFixedLengthStreamingMode(byteArray.length);
            OutputStream newStream = http.getOutputStream();//创建一个Stream,赋值是写入HttpWebRequest对象提供的一个stream里面
            newStream.write(byteArray, 0, byteArray.length);
            newStream.close();
            http.connect();
            InputStream is = http.getInputStream();
//            int size = is.available();
////            System.out.println(size);
//            byte[] jsonBytes = new byte[size];
            byte[] jsonBytes = new byte[1024];
            int len=0;
            String message="";
            while((len=is.read(jsonBytes))!=-1){
                message=message+new String(jsonBytes,0,len);
            }
//            is.read(jsonBytes);
//            String message = new String(jsonBytes, "UTF-8");
            System.out.println(message);
            body =JSONObject.fromObject(message);
//            System.out.println(body);
            is.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return body;
    }
    
}
