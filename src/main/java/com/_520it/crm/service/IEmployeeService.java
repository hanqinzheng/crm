package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;

public interface IEmployeeService {
    int deleteByPrimaryKey(Long id);
    int insert(Employee record);
    Employee selectByPrimaryKey(Long id);
    List<Employee> selectAll();
    int updateByPrimaryKey(Employee record);
    Employee getEmployeeForLogin(String username, String password);
	PageResult queryForPage(EmployeeQueryObject qo);
	void updateState(Long id);
	List role_queryByID(Long eid);
}
