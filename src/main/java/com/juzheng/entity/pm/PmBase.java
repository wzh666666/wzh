package com.juzheng.entity.pm;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class PmBase {
	@ApiModelProperty(value = "项目ID")
    private Integer pmId;
	@ApiModelProperty(value = "项目编号")
    private String pmNo;
	@ApiModelProperty(value = "项目类型(1项目,2合同)")
    private Integer pmType;
	
	@ApiModelProperty(value = "项目名称")
    private String pmName;
	@ApiModelProperty(value = "项目单位")
    private Integer pmDept;
	@ApiModelProperty(value = "部门名称")
	private String deptName;

	@ApiModelProperty(value = "补偿标准")
    private Double pmStandard;
	@ApiModelProperty(value = "补偿数量")
    private Double pmCount;
	@ApiModelProperty(value = "补偿金额")
    private Double pmMoney;
	

	@JsonFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "签订时间")
    private Date pmSignTime;
	@ApiModelProperty(value = "资金来源（1 专项资金  2征迁贷款资金）")
    private Integer pmSource;
	@ApiModelProperty(value = "状态(0-保存1-执行,2-归档,3-作废)")
    private Integer pmState;
	@ApiModelProperty(value = "说明")
    private String pmRemark;
	@ApiModelProperty(value = "创建者id")
    private Integer pmCreateId;
	@ApiModelProperty(value = "计量单位（1亩   2 平方米）")
    private Integer pmMeasurement;
	@ApiModelProperty(value = "消息状态（0-无消息，1-主管单位上传，2，责任单位上传）")
    private Integer pmInfo;
	@ApiModelProperty(value = "是否可以修改 0-不可  1可以")
    private Integer ifEdit;
	
	@ApiModelProperty(value = "查询时使用，页面条数")
	private Integer pageSize; //查询时使用，页面条数
	@ApiModelProperty(value = "查询时使用，开始下标")
	private Integer startIndex; //查询时使用，开始下标
	

	
	
    public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    public String getPmNo() {
        return pmNo;
    }

    public void setPmNo(String pmNo) {
        this.pmNo = pmNo == null ? null : pmNo.trim();
    }



    public Integer getPmType() {
		return pmType;
	}

	public void setPmType(Integer pmType) {
		this.pmType = pmType;
	}

	public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName == null ? null : pmName.trim();
    }

    public Integer getPmDept() {
        return pmDept;
    }

    public void setPmDept(Integer pmDept) {
        this.pmDept = pmDept;
    }

    public Double getPmStandard() {
        return pmStandard;
    }

    public void setPmStandard(Double pmStandard) {
        this.pmStandard = pmStandard;
    }

    public Double getPmCount() {
        return pmCount;
    }

    public void setPmCount(Double pmCount) {
        this.pmCount = pmCount;
    }

    public Double getPmMoney() {
        return pmMoney;
    }

    public void setPmMoney(Double pmMoney) {
        this.pmMoney = pmMoney;
    }

    public Date getPmSignTime() {
        return pmSignTime;
    }

    public void setPmSignTime(Date pmSignTime) {
        this.pmSignTime = pmSignTime;
    }

    public Integer getPmSource() {
        return pmSource;
    }

    public void setPmSource(Integer pmSource) {
        this.pmSource = pmSource;
    }

    public Integer getPmState() {
        return pmState;
    }

    public void setPmState(Integer pmState) {
        this.pmState = pmState;
    }

    public String getPmRemark() {
        return pmRemark;
    }

    public void setPmRemark(String pmRemark) {
        this.pmRemark = pmRemark == null ? null : pmRemark.trim();
    }

    public Integer getPmCreateId() {
        return pmCreateId;
    }

    public void setPmCreateId(Integer pmCreateId) {
        this.pmCreateId = pmCreateId;
    }

    public Integer getPmMeasurement() {
        return pmMeasurement;
    }

    public void setPmMeasurement(Integer pmMeasurement) {
        this.pmMeasurement = pmMeasurement;
    }

    public Integer getPmInfo() {
        return pmInfo;
    }

    public void setPmInfo(Integer pmInfo) {
        this.pmInfo = pmInfo;
    }

    public Integer getIfEdit() {
        return ifEdit;
    }

    public void setIfEdit(Integer ifEdit) {
        this.ifEdit = ifEdit;
    }
    
    
}