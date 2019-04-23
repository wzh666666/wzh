package com.juzheng.entity.code;

public class CodeData {
	private int code;
	private String msg;
	private Object Data;
	
	public CodeData() {
		super();
	}
	
	
	public CodeData(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		Data = data;
	}

	public CodeData(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Object getData() {
		return Data;
	}


	public void setData(Object data) {
		Data = data;
	}


	@Override
	public String toString() {
		return "CodeData [code=" + code + ", msg=" + msg + ", Data=" + Data + "]";
	}
	
	
}
