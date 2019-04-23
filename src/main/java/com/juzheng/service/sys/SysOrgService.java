package com.juzheng.service.sys;

import java.util.List;

import com.juzheng.entity.sys.SysOrg;


public interface SysOrgService {

	   int deleteByPrimaryKey(Integer id);

	    int insert(SysOrg record);


	    int update(SysOrg record);
	    
	    List<SysOrg> select(SysOrg record);
	    

}
