package com.juzheng.entity.code;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("返回带数组以及数组长度")
public class CodeDataSizeT<T> implements Serializable  {
    @ApiModelProperty(value="确认编码")
    private Integer code;
    @ApiModelProperty(value="确认信息")
    private String message;
    @ApiModelProperty(value="数组长度")
    private Integer size;
    @ApiModelProperty(value="数组内容")
    private T data;

    @Override
    public String toString() {
        return "CodeDataSizeT{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", size=" + size +
                ", data=" + data +
                '}';
    }

    public CodeDataSizeT() {
    }

    public CodeDataSizeT(Integer code, String message, Integer size, T data) {
        this.code = code;
        this.message = message;
        this.size = size;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
