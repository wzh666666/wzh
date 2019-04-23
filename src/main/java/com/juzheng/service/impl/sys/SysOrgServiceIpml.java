package com.juzheng.service.impl.sys;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.juzheng.entity.sys.SysOrg;
import com.juzheng.mapper.sys.SysOrgMapper;
import com.juzheng.service.sys.SysOrgService;


@Service
public class SysOrgServiceIpml implements SysOrgService{
	@Resource
	private SysOrgMapper sysOrgMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int deleteByPrimaryKey = sysOrgMapper.deleteByPrimaryKey(id);
		return deleteByPrimaryKey;
	}

	@Override
	public int insert(SysOrg record) {
		// TODO Auto-generated method stub
		int insert = sysOrgMapper.insert(record);
		return insert;
	}

	@Override
	public int update(SysOrg record) {
		// TODO Auto-generated method stub
		int update = sysOrgMapper.update(record);
		return 0;
	}

	@Override
	public List<SysOrg> select(SysOrg record) {
		// TODO Auto-generated method stub
		List<SysOrg> select = sysOrgMapper.select(record);
		return select;
	}


}
	

