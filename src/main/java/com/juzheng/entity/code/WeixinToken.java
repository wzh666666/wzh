package com.juzheng.entity.code;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 腾讯云
 * 
 * @author Hong
 * @since 2018年8月11日
 */
public class WeixinToken {
	private Integer id;
	private String company_id;
	private String access_token;
	private Timestamp expires_in;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Date getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Timestamp expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "WeixinToken [id=" + id + ", company_id=" + company_id + ", access_token=" + access_token
				+ ", expires_in=" + expires_in + "]";
	}

}
