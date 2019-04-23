//package com.juzheng.entity.code;
//
//
//
//import net.minidev.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class QyweixinUtil {
//    private static final Logger logger = LoggerFactory.getLogger(QyweixinUtil.class);
//    public static String corpid;
//    public static String corpsecret;
//    public static String agentid;
//    public static String sdkappid;
//    public static String appkey;
//    @Autowired
//    private Environment env;
//    @PostConstruct
//    public void initParam () {
//        corpid = env.getProperty("wechat.appid");
//        corpsecret = env.getProperty("wechat.corpSecret");
//        agentid = env.getProperty("wechat.agentId");
//        sdkappid = env.getProperty("sdkappid");
//        appkey = env.getProperty("appkey");
//    }
//    public static void out(){
//        System.out.println("**************************");
//        System.out.println(corpid);
//        System.out.println(corpsecret);
//        System.out.println(agentid);
//        System.out.println(sdkappid);
//        System.out.println(appkey);
//        System.out.println("**************************");
//    }
//    /**
//     * 获取一次企业微信access_taken
//     * @return
//     */
//    public static WxData getWxAccessToken(){
//        String url="https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+
//                corpid+"&corpsecret=" +corpsecret;
//        try {
//            JSONObject body = HttpUtil.post(url);
//            WxData wxData = new WxData(
//                    (Integer) body.get("errcode"),
//                    (String)body.get("errmsg"),
//                    (String)body.get("access_token"),
//                    (Integer) body.get("expires_in")
//            );
//            System.out.println(wxData.access_token);
//            return wxData;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new WxData(10002,"获取失败");
//    }
//
//
//
//    /**
//     * 用过返回的code和本地accesstoken获取用户账号
//     * @param code
//     * @param accessToken
//     * @return 要登录的用户账号
//     */
//    public static String checkUserCode(String code,String accessToken){ ;
//        String url="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="+accessToken+"&code="+code;
//        JSONObject body =HttpUtil.post(url);
//        System.out.println(body);
//        if (null != body) {
//            String userNo = body.get("UserId").toString();
//            return  userNo;
//        }
//        return null;
//    }
//
//
////    /**
////     * 短信发送
////     * @param toUser
////     * @param msgType
////     * @param header
////     * @param access_token
////     * @return
////     */
////    public static String sendMessage(String toUser,String msgType,String header,String access_token) {
////        String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="+access_token;
////
////        JSONObject json = new JSONObject();
////        JSONObject j = new JSONObject();
////        json.put("touser",toUser);
////        json.put("msgtype",msgType);
////        json.put("agentid",agentid);
////        j.put("title","支部通");
////        LocalDate today = LocalDate.now();
////        j.put("description","<div class=\"gray\">"+today+"</div> <div class=\"normal\">"+header+"</div>");
////        //连江
////        j.put("url","https://open.weixin.qq.com/connect/oauth2/authorize?appid="+corpid+"&redirect_uri=http://www.fjlj.gov.cn:30014&/nextplan&response_type=code&scope=snsapi_userinfo&agentid="+agentid+"&state=bb#wechat_redirect");
////        //居正
////        //j.put("url"," https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxe5831c7dbb62a084&redirect_uri=week.fzjuzheng.com&response_type=code&scope=snsapi_userinfo&agentid=1000016&state=bb#wechat_redirect") ;
////
////        j.put("btntxt","详情");
////        json.put("textcard",j);
////
////        String s = json.toString();
////        return http(s,url);
////    }
//
//
//
//
//
//
//
//
//    /**
//     * 获取企业微信access_token返回信息
//     */
//    public static class WxData {
//        private Integer errcode;
//        private String errmsg;
//        private String access_token;
//        private Integer expires_in;
//        public WxData(Integer errcode,String errmsg){
//            this.errcode = errcode;
//            this.errmsg = errmsg;
//        }
//        public WxData(Integer errcode,String errmsg,String access_token,Integer expires_in){
//            this.errcode = errcode;
//            this.errmsg = errmsg;
//            this.access_token = access_token;
//            this.expires_in = expires_in;
//        }
//        public Integer getErrcode() {
//            return errcode;
//        }
//        public String getErrmsg() {
//            return errmsg;
//        }
//        public String getAccess_token() {
//            return access_token;
//        }
//        public Integer getExpires_in() {
//            return expires_in;
//        }
//    }
//
//}
