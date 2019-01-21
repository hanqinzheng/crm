package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Department;
import com._520it.crm.service.IDepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;

	@RequestMapping("/department_list")
	@ResponseBody
	public List<Department> department_list(){
		List<Department> result = null;
		result = departmentService.queryForDept();
		return result;
	}
	@RequestMapping("/department_all")
	@ResponseBody
	public List<Department> department_all(){
		List<Department> list = departmentService.selectAll();
		return list;
	}
}
