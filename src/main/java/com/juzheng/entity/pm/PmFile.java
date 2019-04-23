package com.juzheng.entity.pm;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class PmFile {
	@ApiModelProperty(value = "附件ID")
    private Integer id;
	@ApiModelProperty(value = "附件名")
    private String fName;
	@ApiModelProperty(value = "保存路径")
    private String fPath;
	@ApiModelProperty(value = "附件类型")
    private Integer fType;
	@ApiModelProperty(value = "上传时间")
    private Date fTime;
	@ApiModelProperty(value = "附件归属(1-主管单位,2-责任单位)")
    private Integer fBelong;
	@ApiModelProperty(value = "项目id")
    private Integer pmId;

	
	
	
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfPath() {
        return fPath;
    }

    public void setfPath(String fPath) {
        this.fPath = fPath == null ? null : fPath.trim();
    }

    public Integer getfType() {
        return fType;
    }

    public void setfType(Integer fType) {
        this.fType = fType;
    }

    public Date getfTime() {
        return fTime;
    }

    public void setfTime(Date fTime) {
        this.fTime = fTime;
    }

    public Integer getfBelong() {
        return fBelong;
    }

    public void setfBelong(Integer fBelong) {
        this.fBelong = fBelong;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }
}