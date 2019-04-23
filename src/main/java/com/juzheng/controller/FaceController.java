package com.juzheng.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.juzheng.util.CodeDataT;
import com.juzheng.util.HttpUtil;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

@RestController
@Api(value = "FaceController", description = "脸部识别")
@RequestMapping("/face")
public class FaceController {
    @Value("${APIKey}")
    private String apiKey;
    @Value("${SecretKey}")
    private String secreKey;
    @Value("${AppID}")
    private String appId;
    @ApiOperation("识别1")
    @PostMapping("/test")
    public CodeDataT test(@RequestBody MultipartFile file) {
        StringBuilder b = new StringBuilder();
        String accessToken = null;
        try {
            //获取图片处理结果
            JSONObject body2 = getFaceResult(file, b);
            System.out.println(body2);
            if (!body2.get("error_code").toString().equals("0")) {
                return new CodeDataT(1001, "图片处理失败");
            }
            //将处理结果写导新的一个图片上。
            String srcFileName = file.getOriginalFilename();
            String suffixName = srcFileName.substring(srcFileName.lastIndexOf("."));
            //附件名生成
            String autoName = UUID.randomUUID().toString().replaceAll("-", "");
            String newfileName = autoName + "-huangqihuang" + suffixName;
            File file2 = new File("D:\\upload\\" + newfileName); //写到新的文件去
            BufferedImage bi = ImageIO.read(file.getInputStream());//原图读取
            writeImage(bi, "png", file2, body2);
            return new CodeDataT(1000, "绘图成功");
        } catch (IOException e) {
            e.printStackTrace();
            return new CodeDataT(1001, "图片处理失败");
        }

    }

    @SuppressWarnings("restriction")
	private JSONObject getFaceResult(@RequestBody MultipartFile file, StringBuilder b) throws IOException {
        String accessToken;
        String url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&" +
                "client_id=" + apiKey + "&client_secret=" + secreKey + "&";
        JSONObject body = HttpUtil.get(url);
        accessToken = body.get("access_token").toString();
		BASE64Encoder encoder = new BASE64Encoder();
        b.append(encoder.encode(file.getBytes()));
        JSONObject param = new JSONObject();
        param.put("image", b.toString());
        param.put("max_face_num", 10);
        param.put("image_type", "BASE64");
        param.put("face_field", "age,beauty,expression,face_shape,gender,glasses,landmark,race,quality,eye_status,emotion,face_type");
        return HttpUtil.postBody("https://aip.baidubce.com/rest/2.0/face/v3/detect?access_token=" + accessToken, param);
    }

    public void writeImage(BufferedImage bi, String picType, File file, JSONObject body) {
        JSONObject resbody= (JSONObject) body.get("result");
        JSONArray resList= (JSONArray) resbody.get("face_list");
        for(Object resbody2:resList){
            JSONObject resbody3= (JSONObject) resbody2;
            JSONObject location = (JSONObject) resbody3.get("location");
            int left=Double.valueOf(location.get("left").toString()).intValue();
            int top=Double.valueOf(location.get("top").toString()).intValue();
            int width=Double.valueOf(location.get("width").toString()).intValue();
            int height=Double.valueOf(location.get("height").toString()).intValue();
            String age= "年龄:"+resbody3.get("age").toString(); 
            String beauty= "颜值:"+resbody3.get("beauty").toString();
            Graphics g = bi.getGraphics();
            g.setColor(new Color(12, 123, 88));
            g.draw3DRect(left,top,width,height,true);//画一个线框
            Font f = new Font("宋体",Font.PLAIN,26);
            g.setFont(f);
            g.drawString(age,left,top);
            g.drawString(beauty,left+width,top);
            
            g.dispose();
            boolean val = false;
            try {
                val = ImageIO.write(bi, picType, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
    
}
