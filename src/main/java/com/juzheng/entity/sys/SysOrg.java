package com.juzheng.entity.sys;

import io.swagger.annotations.ApiModelProperty;

public class SysOrg {
	@ApiModelProperty(value = "部门ID")
    private Integer id;
	@ApiModelProperty(value = "部门名称")
    private String deptName;
	@ApiModelProperty(value = "(1-主管单位,2-责任单位)")
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}