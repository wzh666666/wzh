package com.juzheng.service.impl.pm;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.juzheng.entity.pm.PmFile;
import com.juzheng.mapper.pm.PmFileMapper;
import com.juzheng.service.pm.PmFileService;



@Service
public class PmFileServiceImpl  implements  PmFileService{
	
	@Resource
	private PmFileMapper pmFileMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int deleteByPrimaryKey = pmFileMapper.deleteByPrimaryKey(id);
		return deleteByPrimaryKey;
	}

	@Override
	public int insert(PmFile record) {
		// TODO Auto-generated method stub
		int insert = pmFileMapper.insert(record);
		return insert;
	}

	@Override
	public List<PmFile> select(PmFile record) {
		// TODO Auto-generated method stub
		List<PmFile> select = pmFileMapper.select(record);
		return select;
	}

	@Override
	public int update(PmFile record) {
		// TODO Auto-generated method stub
		int update = pmFileMapper.update(record);
		return update;
	}

	@Override
	public int findmaxId() {
		// TODO Auto-generated method stub
		Integer findmaxId = pmFileMapper.findmaxId();
		if (findmaxId==null) {
			findmaxId=0;
		}
		return findmaxId;
	}

}
