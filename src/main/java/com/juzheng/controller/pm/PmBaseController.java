package com.juzheng.controller.pm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juzheng.entity.code.CodeData;
import com.juzheng.entity.code.Page;
import com.juzheng.entity.pm.PmBase;
import com.juzheng.entity.pm.PmFile;
import com.juzheng.service.pm.PmBaseService;
import com.juzheng.service.pm.PmFileService;
import com.juzheng.util.PageCount;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="/pmBase")
@Api(value = "项目Api")
public class PmBaseController {
	
	@Resource
	private PmBaseService pmBaseService;
	@Resource
	private PmFileService pmFileService;
	
	
	  @ApiOperation(value = "获取项目编号")
		@RequestMapping(value = "/findPmNO", method = RequestMethod.GET)
		public Object findPmNO() {
		   String nowday = new SimpleDateFormat("yyyyMMdd").format(new Date());
		   int findMaxId = pmBaseService.findMaxId();
	    	
			return new CodeData(1000, "获取项目编号成功", nowday+findMaxId);

		}
	
	
	  
    @ApiOperation(value = "新增项目")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Object insert( @ApiParam("PmBase实体类") @RequestBody PmBase pmBase,@ApiParam("附件ID集合,逗号分开") @RequestParam(required=false) String fileList ) {
    	pmBase.setPmInfo(1);
    	int insert = pmBaseService.insert(pmBase);
    	
    	if (fileList!=null&&fileList!=null) {
    		String[] split = fileList.split(",");
    		for (String string : split) {
    			PmFile pmFile=new PmFile();
				pmFile.setId(Integer.parseInt(string));
				pmFile.setPmId(pmBase.getPmId());
				pmFileService.update(pmFile);
			}
		}
    
    	
		return new CodeData(1000, "新增项目成功", pmBase.getPmId());

	}
    
    @ApiOperation(value = "修改项目")
  	@RequestMapping(value = "/update", method = RequestMethod.POST)
  	public Object update( @ApiParam("附件ID") @RequestBody PmBase pmBase) {

    	pmBaseService.update(pmBase);
      	      	
  		return new CodeData(1000, "修改项目成功",null);
  	}
    
    
    
    
    @ApiOperation(value = "删除项目")
  	@RequestMapping(value = "/delete", method = RequestMethod.POST)
  	public Object delete( @ApiParam("项目ID") @RequestParam Integer pmId) {

    	pmBaseService.deleteByPrimaryKey(pmId);
      	      	
  		return new CodeData(1000, "删除项目成功",null);
  	}

    
    @ApiOperation(value = "查询项目")
  	@RequestMapping(value = "/select", method = RequestMethod.POST)
  	public Object select( @ApiParam("传入pmBase实体类，其中分页条件必传") @RequestBody PmBase pmBase,
  			@ApiParam("用户部门") @RequestParam  Integer userDept,@ApiParam("用户类型") @RequestParam  Integer userType) {
    	
    	
    	if (userType==2) {
    		pmBase.setPmDept(userDept);
		}
    	
    	List<PmBase> select = pmBaseService.select(pmBase);
    	int count = pmBaseService.count(pmBase);
    	Page<Object> page = new PageCount().getPage(pmBase.getStartIndex(), pmBase.getPageSize(), count, select);
      	      	
  		return new CodeData(1000, "获取项目成功",page);
  	}
}
