package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Permission;
import com._520it.crm.mapper.PermissionMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PermissionQueryObject;
import com._520it.crm.service.IPermissionService;
@Service
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	private PermissionMapper permissionmapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return permissionmapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Permission record) {
		return permissionmapper.insert(record);
	}

	@Override
	public Permission selectByPrimaryKey(Long id) {
		return permissionmapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Permission> selectAll() {
		return permissionmapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Permission record) {
		return permissionmapper.updateByPrimaryKey(record);
	}


	@Override
	public PageResult queryForPage(PermissionQueryObject qo) {
		Long count = permissionmapper.queryForPageCount(qo);
		if(count==0){
			return new PageResult(0,Collections.EMPTY_LIST);
		}
		List<Permission> list = permissionmapper.queryForPage(qo);
		return new PageResult(count.intValue(), list);
	}


}
