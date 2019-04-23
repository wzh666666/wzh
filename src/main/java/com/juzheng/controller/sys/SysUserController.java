package com.juzheng.controller.sys;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juzheng.entity.code.CodeData;
import com.juzheng.entity.code.Page;
import com.juzheng.entity.sys.SysUser;
import com.juzheng.service.sys.SysUserService;
import com.juzheng.util.MD5;
import com.juzheng.util.PageCount;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "用户相关Api")
@RequestMapping("/user")
@RestController
public class SysUserController {
	@Resource
	private SysUserService sysUserService;
	
	 @ApiOperation(value = "新增用户", notes = "SysUser实体类")
	 @RequestMapping(value = "insert", method = RequestMethod.POST)
	    public Object insert(@ApiParam("SysUser实体类") @RequestBody SysUser sysUser) {
		 	if (sysUser.getPassword()!=null&&sysUser.getPassword()!="") {
		 		sysUser.setPassword(MD5.md5(sysUser.getPassword()+""+sysUser.getUserNo()));
			}else {
				sysUser.setPassword(MD5.md5("111111"+""+sysUser.getUserNo()));
			}
		
		 	sysUserService.insert(sysUser);
	        return new CodeData(1000,"新增用户成功");
	    }
	
	 
	 @ApiOperation(value = "修改用户", notes = "SysUser实体类")
	 @RequestMapping(value = "update", method = RequestMethod.POST)
	    public Object update(@ApiParam("SysUser实体类") @RequestBody SysUser sysUser) {
		 	
		 SysUser user=new SysUser();
		 user.setId(sysUser.getId());
		 List<SysUser> select = sysUserService.select(user);
		 SysUser sysUser2 = select.get(0);
		 	if (sysUser.getPassword()!=null&& sysUser.getPassword()!="") {
		 		sysUser.setPassword(MD5.md5(sysUser.getPassword()+""+sysUser2.getUserNo()));
			}
		 	sysUserService.update(sysUser);
	        return new CodeData(1000,"修改用户成功");
	    }
	
	 
	 @ApiOperation(value = "查询用户", notes = "SysUser实体类，查询条件必传")
	 @RequestMapping(value = "select", method = RequestMethod.POST)
	    public Object select(@ApiParam("SysUser实体类") @RequestBody SysUser sysUser) {
		 	
		 	List<SysUser> select = sysUserService.select(sysUser);
		 	int count = sysUserService.count(sysUser);
			Page<Object> page = new PageCount().getPage(sysUser.getStartIndex(), sysUser.getPageSize(), count, select);
	        return new CodeData(1000,"获取数据成功",page);
	    }
	 
	 @ApiOperation(value = "查询所有用户", notes = "SysUser实体类，查询条件必传")
	 @RequestMapping(value = "findAllUser", method = RequestMethod.GET)
	    public CodeData findAllUser() {
		    SysUser sysUser=new SysUser();
		 	List<SysUser> select = sysUserService.select(sysUser);
		 	
	        return new CodeData(1000,"获取数据成功",select);
	    }
	 
	 @ApiOperation(value = "删除用户", notes = "传userId")
	 @RequestMapping(value = "delete", method = RequestMethod.GET)
	    public Object delete(@ApiParam("userId") @RequestParam Integer userId) {
		 	sysUserService.deleteByPrimaryKey(userId);
	        return new CodeData(1000,"删除用户成功");
	    }
	 
	 
	 @ApiOperation(value = "查询userNO是否重复", notes = "传userNO")
	 @RequestMapping(value = "finduserNO", method = RequestMethod.GET)
	    public Object finduserNO(@ApiParam("finduserNO") @RequestParam String userNo) {
		 	int finduserNO = sysUserService.finduserNO(userNo);
		 	if (finduserNO==0) {
		        return new CodeData(1000,"该用户编号可以使用");
			}
	        return new CodeData(800,"该用户编号已经存在");
	    }
	 
	 
	 @ApiOperation(value = "查询旧密码是否正确")
	 @RequestMapping(value = "findPassword", method = RequestMethod.POST)
	    public Object findPassword(@ApiParam("userId") @RequestParam Integer userId,@ApiParam("旧密码") @RequestParam String password) {
		 	SysUser sysUser=new SysUser();
		 	sysUser.setId(userId);
		 	SysUser user = sysUserService.login(sysUser);
		 	if (user.getPassword().equals(MD5.md5(password+""+user.getUserNo()))) {
		 		return new CodeData(1000,"旧密码正确",null);
			}
		 	
		 	return new CodeData(800,"旧密码不正确",null);
	    }
	 

}
