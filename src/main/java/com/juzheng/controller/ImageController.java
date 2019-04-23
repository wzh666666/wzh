package com.juzheng.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@Api(value = "前端图片获取-1", description = "ImageController")
@RequestMapping("res")
public class ImageController {
    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public void insert(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("前端图片获取");
        String a=request.getRequestURI();
        String b=this.getClass().getResource("/").getPath();
        System.out.println(b);
        System.out.println(b+a);
        File file=new File(b+a);
        if (file.exists()) {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            OutputStream os=null;
            try {
                byte[] buffer = new byte[1024];
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            }catch (Exception e){
            }finally {
                if (fis!=null){
                    try {
                        fis.close();
                    } catch (IOException e) {

                    }
                }
                if(bis!=null){
                    try {
                        bis.close();
                    } catch (IOException e) {

                    }
                }
                if (os!=null){
                    try {
                        os.close();
                    } catch (IOException e) {

                    }
                }
            }
        }else {
            throw  new RuntimeException("文件不存在");
        }
    }
}
