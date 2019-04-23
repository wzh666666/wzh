package com.juzheng.entity.code;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("返回带数据")
public class CodeDataT<T> implements Serializable {
    @ApiModelProperty(value="确认编码")
    private Integer code;
    @ApiModelProperty(value="确认信息")
    private String message;
    @ApiModelProperty(value="数据内容")
    private T data;
    public CodeDataT(){
    }
    public CodeDataT(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
    public CodeDataT(Integer code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Integer getcode() {
        return code;
    }
    public void setcode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
