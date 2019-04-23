package com.juzheng.service.impl.sys;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.juzheng.entity.sys.SysUser;
import com.juzheng.mapper.sys.SysUserMapper;
import com.juzheng.service.sys.SysUserService;


@Service
public class SysUserServiceIpml implements SysUserService{
	@Resource
	private SysUserMapper sysUserMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int deleteByPrimaryKey = sysUserMapper.deleteByPrimaryKey(id);
		return deleteByPrimaryKey;
	}

	@Override
	public int insert(SysUser record) {
		// TODO Auto-generated method stub
		int insert = sysUserMapper.insert(record);
		return insert;
	}

	@Override
	public List<SysUser> select(SysUser record) {
		// TODO Auto-generated method stub
		List<SysUser> select = sysUserMapper.select(record);
		return select;
	}

	@Override
	public int update(SysUser record) {
		// TODO Auto-generated method stub
		int update = sysUserMapper.update(record);
		return update;
	}

	@Override
	public int count(SysUser record) {
		// TODO Auto-generated method stub
		int count = sysUserMapper.count(record);
		return count;
	}

	@Override
	public int finduserNO(String userNo) {
		// TODO Auto-generated method stub
		int finduserNO = sysUserMapper.finduserNO(userNo);
		return finduserNO;
	}

	@Override
	public SysUser login(SysUser record) {
		// TODO Auto-generated method stub
		SysUser login = sysUserMapper.login(record);
		return login;
	}
	
	

}
