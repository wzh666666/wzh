package com.juzheng.entity.code;



import java.util.List;
import java.util.Map;


/**
 * Created by asus on 2017/10/11.
 */
public class CodeToken extends Code{
    private String token=null;

    private Map<String,Object> data=null;

    public CodeToken(Integer code, String message, String token, Map<String,Object> data) {
        super(code, message);
        this.token = token;
        this.data = data;
    }

    public Map<String,Object> getData() {
        return data;
    }

    public String getToken() {
        return token;
    }
}
