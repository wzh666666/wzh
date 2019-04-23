package com.juzheng.mapper.pm;

import java.util.List;

import com.juzheng.entity.pm.PmBase;

public interface PmBaseMapper {
    int deleteByPrimaryKey(Integer pmId);

    int insert(PmBase record);

  
    List<PmBase> select(PmBase record);
    
    int count(PmBase record);

    int update(PmBase record);
    
    //获取项目最大id
    Integer findMaxId();

   
}