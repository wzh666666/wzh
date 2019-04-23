package com.juzheng.service.pm;

import java.util.List;

import com.juzheng.entity.pm.PmFile;



public interface PmFileService {
	
	int deleteByPrimaryKey(Integer id);

    int insert(PmFile record);


    List<PmFile> select(PmFile record);


    int update(PmFile record);
    
    
    
    int  findmaxId();

}
