package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Role;
import com._520it.crm.mapper.EmployeeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeMapper employeemapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		employeemapper.deleteRelation(id);
		int effectCount = employeemapper.deleteByPrimaryKey(id);
		return effectCount;
	}

	@Override
	public int insert(Employee record) {
		int effect = employeemapper.insert(record);
		for(Role r:record.getRoles()){
			employeemapper.insertRelation(record.getId(),r.getId());
		}
		
		return effect;
	}

	@Override
	public Employee selectByPrimaryKey(Long id) {
		return employeemapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Employee> selectAll() {
		return employeemapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		int effectCount = employeemapper.updateByPrimaryKey(record);
		employeemapper.deleteRelation(record.getId());
		for(Role r:record.getRoles()){
			employeemapper.insertRelation(record.getId(),r.getId());
		}
		return effectCount;
		
	}

	@Override
	public Employee getEmployeeForLogin(String username, String password) {
		// TODO Auto-generated method stub
		return employeemapper.getEmployeeForLogin(username,password);
		
	}

	@Override
	public PageResult queryForPage(EmployeeQueryObject qo) {
		Long count = employeemapper.queryForPageCount(qo);
		if(count==0){
			return new PageResult(0,Collections.EMPTY_LIST);
		}
		List<Employee> list = employeemapper.queryForPage(qo);
		return new PageResult(count.intValue(), list);
	}

	@Override
	public void updateState(Long id) {
		employeemapper.updateState(id);
	}

	@Override
	public List role_queryByID(Long eid) {
		
		return employeemapper.role_queryByID(eid);
	}

}
