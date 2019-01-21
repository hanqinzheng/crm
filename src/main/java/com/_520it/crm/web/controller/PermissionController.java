package com._520it.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.query.PermissionQueryObject;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.service.IPermissionService;

@Controller
public class PermissionController {
	@Autowired
	private IPermissionService permissionService;

	@RequestMapping("/permission_list")
	@ResponseBody
	public PageResult permission_list(PermissionQueryObject qo){
		PageResult result = null;
		result = permissionService.queryForPage(qo);
		return result;
	}
	@RequestMapping("/permission_ByRoleId")
	@ResponseBody
	public PageResult permission_ByRoleId(PermissionQueryObject qo){
		PageResult result = null;
		result = permissionService.queryForPage(qo);
		return result;
	}
}
