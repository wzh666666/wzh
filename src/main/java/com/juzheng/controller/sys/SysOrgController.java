package com.juzheng.controller.sys;


import java.util.List;

import javax.annotation.Resource;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juzheng.entity.code.CodeData;
import com.juzheng.entity.sys.SysOrg;
import com.juzheng.service.sys.SysOrgService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "组织相关Api")
@RequestMapping("/org")
@RestController
public class SysOrgController {
	@Resource
	private SysOrgService sysOrgService;
	
	
	 @ApiOperation(value = "获取所有组织条件", notes = "无需传参")
	 @RequestMapping(value = "listforselect", method = RequestMethod.GET)
	    public Object listforselect() {
		 	SysOrg record=new SysOrg();
		 	List<SysOrg> select = sysOrgService.select(record);
	        return new CodeData(1000,"获取数据成功",select);
	    }
	
	
	
	

}
