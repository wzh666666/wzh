package com.juzheng.controller.sys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juzheng.entity.code.CodeToken;
import com.juzheng.entity.code.TokenDetail;
import com.juzheng.entity.sys.SysUser;
import com.juzheng.service.sys.SysUserService;
import com.juzheng.util.Jwt;
import com.juzheng.util.MD5;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/login")
@Api(value = "LoginController",description = "登录")
public class LoginController {
	@Resource
	private SysUserService sysUserService;

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ApiOperation(value="登录")
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public Object doorLogin(HttpServletRequest request,
			@ApiParam("userNo") @RequestParam String userNo,@ApiParam("password") @RequestParam String password) throws Exception {
		logger.info("验证登录:userNo={},password={}",userNo,password);	
		
		//获取ip
		String ip = getIp(request);
		SysUser sysUser=new SysUser();
		sysUser.setPassword(MD5.md5(password+""+userNo));
		SysUser user = sysUserService.login(sysUser);
		
		if (user==null) {
			return new CodeToken(404,"登陆失败，帐号或者密码错误",null,null);
		}
		
			 //登入成功创建TOken
            Jwt jwt = new Jwt();
    
            TokenDetail tokenDetail = new TokenDetail();
            SimpleDateFormat format =  new SimpleDateFormat( );
            tokenDetail.setName(user.getName());//姓名
            tokenDetail.setId(user.getId());//id
            Date now = new Date();
            String d = format.format(now.getTime()+1000*60*60*2);
            Date exprire = format.parse(d);
            tokenDetail.setExpirationDate(exprire);
  
    		Map<String,Object> map = new HashMap<>();
    		map.put("user", user);

            return new CodeToken(1000,"登录成功",jwt.getAuthToken(tokenDetail),map);			
		
		

	}
	
	
	

//
//	/**
//	 * 微信登录验证
//	 */
//	
//    @ApiOperation("微信用户登录")
//    @ApiImplicitParam(name = "code",value = "微信端获取的Code",required = true, dataType = "String",paramType = "query")
//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    public CodeToken login(HttpServletRequest request,@RequestParam("code") String code){
//       try{
//    	 //获取ip
//    	   String ip = getIp(request);
//           System.out.println(code);
//           if(code!=null&&!"".equals(code)){
//               String accessToken = loginService.getAccessToken();
//               String userNo= QyweixinUtil.checkUserCode(code,accessToken);
//               SysUser su = new SysUser();
//               su.setUserNo(userNo);
//               List<SysUser> listUser = sysUserService.listBySysUser(su);
//               if(!CollectionUtils.isEmpty(listUser)&&listUser.get(0)!=null){
//                   SysUser sysUser=listUser.get(0);
//                   //登入成功创建TOken
//                   Jwt jwt = new Jwt();
//                   TokenDetail tokenDetail = new TokenDetail();
//                   SimpleDateFormat format =  new SimpleDateFormat( );
//                   tokenDetail.setTel(sysUser.getTelphone());//电话
//                   tokenDetail.setName(sysUser.getUserName());//姓名
//                   tokenDetail.setId(sysUser.getUserId());//id
//                   Date now = new Date();
//                   String d = format.format(now.getTime()+1000*60*60*2);
//                   Date exprire = format.parse(d);
//                   tokenDetail.setExpirationDate(exprire);
//           		   List<SysMenu> menuList = sysUserService.menuListByUserId(sysUser.getUserId());
//           		   
//           		   
//
//           		//登录成功时获取角色等信息
//           		
//           		//角色
//       			SysUserRole sru=new SysUserRole();
//       			sru.setUserId(listUser.get(0).getUserId());
//       			List<SysUserRole> roleList=sysUserService.listBySysRole(sru);
//       			if(!CollectionUtils.isEmpty(roleList)) {
//       				String roleIds="";
//       				String roleName="";
//       				for(SysUserRole sur:roleList) {
//       					roleIds=roleIds+","+sur.getRoleId();
//       					roleName=roleName+","+sur.getRoleName();
//       				}
//       				roleIds=roleIds.substring(1);
//       				roleName=roleName.substring(1);
//       				sysUser.setRoleId(roleIds);
//       				listUser.get(0).setRoleName(roleName);
//       			}
//       			//组织
//       			List<SysOrg> orgList=sysUserService.listOrgByUserId(listUser.get(0).getUserId());
//       			if(!CollectionUtils.isEmpty(orgList)) {
//       				String orgIds="";
//       				String orgName="";
//       				for(SysOrg sur:orgList) {
//       					orgIds=orgIds+","+sur.getOrgId();
//       					orgName=orgName+","+sur.getOrgName();
//       				}
//       				listUser.get(0).setAreaId(orgList.get(0).getAreaId());
//       				orgIds=orgIds.substring(1);
//       				orgName=orgName.substring(1);
//       				listUser.get(0).setOrgId(orgIds);
//       				listUser.get(0).setOrgName(orgName);
//       			}
//           		   
//           		   
//           		   Map<String,Object> map = new HashMap<>();
//        		   map.put("listUser", listUser);
//        		   map.put("menuList", menuList);
//        		   
//        		 //登录成功记录日日志
//       			SysUserLog sysLog=new SysUserLog();
//       			sysLog.setUserId(listUser.get(0).getUserId());
//       			sysLog.setActionType(4);
//       			sysLog.setState(1);
//       			sysLog.setIp(ip);
//       			sysLog.setAreaId(listUser.get(0).getAreaId());
//       			sysLog.setLogName("登录");
//       			sysLog.setLogContent(listUser.get(0).getUserName()+"登录成功");
//       			sysUserLogService.insert(sysLog);
//        		   
//                   return new CodeToken(1000,"登入成功",jwt.getAuthToken(tokenDetail),map);
//               }
//           }
//           return new CodeToken(1001,"登陆失败",null,null);
//       }catch (Exception e){
//           return new CodeToken(1001,"登陆失败",null,null);
//       }
//    }
	
//	
//	@ApiOperation(value="是否需要验证码", notes="无需参数")
//	@RequestMapping(value = "/hasCode",method = RequestMethod.GET)
//	public Object hasCode() {
//		if(Const.IMG_CODE.equals("1")) {
//			return 1;
//		}else {
//			return 0;
//		}
//	}
//	
	
	
	
//	@ApiOperation(value="重置所有密码", notes="无需参数")
//	@RequestMapping(value = "/ChangeAllUseer",method = RequestMethod.GET)
//	public Object ChangeAllUseer() {
//	
//		List<SysUser> findAllUser = sysUserService.findAllUser();
//		for (SysUser sysUser : findAllUser) {
//			sysUser.setPassword(MD5.md5(111111+""+sysUser.getUserNo()));
//			
//			sysUserService.update(sysUser);
//		}
//		return new Code(1000,"修改完成");
//		
//	}
//	
	
	

//	
//	@ApiOperation(value="退出登录", notes="无需参数")
//	@RequestMapping(value = "/loginout",method = RequestMethod.GET)
//	public Object loginout(HttpServletRequest request,@ApiParam(name="userId",required=true) @RequestParam Integer userId,
//			@ApiParam(name="areaId",required=true) @RequestParam Integer areaId,@ApiParam(name="userName",required=true) @RequestParam String userName) {
//		String ipAddress = getIp(request);
//		System.out.println(ipAddress);
//		
//		//登录失败记录日日志
//		SysUserLog sysLog=new SysUserLog();
//		sysLog.setUserId(userId);
//		sysLog.setActionType(5);
//		sysLog.setState(1);
//		sysLog.setIp(ipAddress);
//		sysLog.setAreaId(areaId);
//		sysLog.setLogName("退出登录");
//		sysLog.setLogContent("退出登录:"+userName);
//		sysLog.setCreDate(new Date());
//		sysUserLogService.insert(sysLog);
//		return new Code(1000,"成功退出");
//		
//	}
//	
//	
	
	
	
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	    return ip;

	}
	
}
