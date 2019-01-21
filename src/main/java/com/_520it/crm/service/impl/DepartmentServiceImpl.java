package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com._520it.crm.domain.Department;
import com._520it.crm.mapper.DepartmentMapper;
import com._520it.crm.service.IDepartmentService;
@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private DepartmentMapper departmentmapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return departmentmapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Department record) {
		return departmentmapper.insert(record);
	}

	@Override
	public Department selectByPrimaryKey(Long id) {
		return departmentmapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Department> selectAll() {
		return departmentmapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Department record) {
		return departmentmapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Department> queryForDept() {
		
		return departmentmapper.queryForDept();
	}

	@Override
	public List<Department> selectAllList() {
		departmentmapper.selectAllList();
		return null;
	}
}
