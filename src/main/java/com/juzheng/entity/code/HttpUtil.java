//package com.juzheng.entity.code;
//
//import net.minidev.json.JSONObject;
//import net.minidev.json.JSONValue;
//import net.minidev.json.parser.ParseException;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
///**
// * http请求
// */
////主要用于企业微信请求接口
//public class HttpUtil {
//    /**
//     * 通过路径获取请求结果（返回json）
//     * @param url 路径
//     * @return json
//     */
//    public static JSONObject post(String url){
//        JSONObject body=null;
//        try {
//            URL urlGet = new URL(url);
//            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
//            http.setRequestMethod("GET");
//            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
//            http.setDoOutput(true);
//            http.setDoInput(true);
//            http.connect();
//            InputStream is = http.getInputStream();
//            int size = is.available();
//            byte[] jsonBytes = new byte[size];
//            is.read(jsonBytes);
//            String message = new String(jsonBytes, "UTF-8");
//            body = (JSONObject) JSONValue.parseWithException(message);
//            is.close();
//        } catch (IOException e) {
//            //e.printStackTrace();
//        } catch (ParseException e) {
//            //e.printStackTrace();
//        }
//        return body;
//    }
//
//}
