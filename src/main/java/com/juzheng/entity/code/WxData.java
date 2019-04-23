package com.juzheng.entity.code;

/**
 * 腾讯云 需求
 * 
 * @author Hong
 * @since 2018年8月11日
 */
public class WxData {
	private Integer errcode;
	private String errmsg;
	private String access_token;
	private Integer expires_in;

	public WxData() {
		super();
	}

	public WxData(Integer errcode, String errmsg, String access_token, Integer expires_in) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.access_token = access_token;
		this.expires_in = expires_in;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "WxData [errcode=" + errcode + ", errmsg=" + errmsg + ", access_token=" + access_token + ", expires_in="
				+ expires_in + "]";
	}

}
