package com.juzheng.entity.sys;

import io.swagger.annotations.ApiModelProperty;

public class SysUser {
	 @ApiModelProperty(value = "用户id")
    private Integer id;
	 @ApiModelProperty(value = "用户名称")
    private String name;
	 @ApiModelProperty(value = "(1-海鱼局,2-责任单位)密码")
    private String password;
	 @ApiModelProperty(value = "用户编号")
    private String userNo;
    @ApiModelProperty(value = "(1-海鱼局,2-责任单位)")
    private Integer type;
    @ApiModelProperty(value = "部门id")
    private Integer dept;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    
    
    @ApiModelProperty(value = " //查询时使用，页面条数")
	private Integer pageSize; //查询时使用，页面条数
    @ApiModelProperty(value = " //查询时使用，开始下标")
	private Integer startIndex; //查询时使用，开始下标
	
	
	

	
	
    public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

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

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }
}