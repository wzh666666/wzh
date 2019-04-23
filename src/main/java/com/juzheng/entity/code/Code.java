package com.juzheng.entity.code;

/**
 * @author 华
 *code
 */
public class Code {
	private int code;
	private String msg;
	public Code() {
		super();
	}
	
	public Code(int code, String msg) {
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
	@Override
	public String toString() {
		return "Code [code=" + code + ", msg=" + msg + "]";
	}
	
	
	
}
