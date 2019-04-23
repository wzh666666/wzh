package com.juzheng.mapper.pm;

import java.util.List;

import com.juzheng.entity.pm.PmFile;

public interface PmFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PmFile record);


    List<PmFile> select(PmFile record);


    int update(PmFile record);
    
    //获取附件最大id
    Integer  findmaxId();
}