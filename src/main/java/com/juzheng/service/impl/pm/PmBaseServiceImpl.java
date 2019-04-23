package com.juzheng.service.impl.pm;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.juzheng.entity.pm.PmBase;
import com.juzheng.mapper.pm.PmBaseMapper;
import com.juzheng.service.pm.PmBaseService;


@Service
public class PmBaseServiceImpl  implements  PmBaseService{
	@Resource
	private PmBaseMapper pmBaseMapper;
	
	
	@Override
	public int deleteByPrimaryKey(Integer pmId) {
		// TODO Auto-generated method stub
		int deleteByPrimaryKey = pmBaseMapper.deleteByPrimaryKey(pmId);
		return deleteByPrimaryKey;
	}

	@Override
	public int insert(PmBase record) {
		// TODO Auto-generated method stub
		int insert = pmBaseMapper.insert(record);
		return insert;
	}

	@Override
	public List<PmBase> select(PmBase record) {
		// TODO Auto-generated method stub
		List<PmBase> select = pmBaseMapper.select(record);
		return select;
	}

	@Override
	public int count(PmBase record) {
		// TODO Auto-generated method stub
		int count = pmBaseMapper.count(record);
		return count;
	}

	@Override
	public int update(PmBase record) {
		// TODO Auto-generated method stub
		int count = pmBaseMapper.update(record);
		return count;
	}

	@Override
	public Integer findMaxId() {
		// TODO Auto-generated method stub
		Integer findMaxId = pmBaseMapper.findMaxId();
		if (findMaxId==null) {
			findMaxId=0;
		}
		findMaxId++;
		return findMaxId;
	}

}
