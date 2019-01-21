package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Permission;
import com._520it.crm.domain.Role;
import com._520it.crm.mapper.RoleMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.RoleQueryObject;
import com._520it.crm.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper rolemapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		rolemapper.deleteRelation(id);
		return rolemapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public int insert(Role record) {
		int effect = rolemapper.insert(record);
		for(Permission p : record.getPermissions()){
			rolemapper.insertRelation(record.getId(), p.getId());
		}
		return effect;
	}

	@Override
	public Role selectByPrimaryKey(Long id) {
		return rolemapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Role> selectAll() {
		return rolemapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		 int effectCount = rolemapper.updateByPrimaryKey(record);
		 rolemapper.deleteRelation(record.getId());
		 for(Permission p:record.getPermissions()){
			 rolemapper.insertRelation(record.getId(),p.getId());
		 }
		 return effectCount;
	}


	@Override
	public PageResult queryForPage(RoleQueryObject qo) {
		Long count = rolemapper.queryForPageCount(qo);
		if(count==0){
			return new PageResult(0,Collections.EMPTY_LIST);
		}
		List<Role> list = rolemapper.queryForPage(qo);
		return new PageResult(count.intValue(), list);
	}
}