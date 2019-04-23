package com.juzheng.mapper.sys;

import java.util.List;

import com.juzheng.entity.sys.SysOrg;


public interface SysOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOrg record);


    List<SysOrg> select(SysOrg record);

   

    int update(SysOrg record);
    
    
    
}