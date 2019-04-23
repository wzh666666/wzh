package com.juzheng.mapper.sys;

import java.util.List;

import com.juzheng.entity.sys.SysUser;


public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    //查询
    List<SysUser> select(SysUser record);
    //计数
    int count(SysUser record);

    int update(SysUser record);
    
    //查询userNO数量
    int   finduserNO(String userNo);
    
    
    //登录
    SysUser login(SysUser record);
  
}