package com._520it.crm.web.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.UserContext;


@Controller
public class EmployeeControl {
	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping("/employee_list")
	@ResponseBody
	public PageResult employee_list(EmployeeQueryObject qo){
		PageResult result = null;
		result = employeeService.queryForPage(qo);
		return result;
	}
	@RequestMapping("/employee_save")
	@ResponseBody
	public AjaxResult employee_save(Employee emp){
		AjaxResult result = null;
		try{
			emp.setPassword("123456");
			emp.setState(true);
			emp.setAdmin(false);
			employeeService.insert(emp);
			result = new AjaxResult(true, "保存成功");
		}catch(Exception e){
			result = new AjaxResult("保存失败");
			
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/employee_update")
	@ResponseBody
	public AjaxResult employee_update(Employee emp){
		AjaxResult result = null;
		try{	
			employeeService.updateByPrimaryKey(emp);
			result = new AjaxResult(true, "修改成功");
		}catch(Exception e){
			result = new AjaxResult("修改失败");
			e.printStackTrace();
		}
		return result;
	}
	@RequestMapping("/employee_delete")
	@ResponseBody
	public AjaxResult employee_delete(Long id){
		AjaxResult result = null;
		try{	
			employeeService.updateState(id);
			result = new AjaxResult(true, "离职成功");
		}catch(Exception e){
			result = new AjaxResult("离职失败");
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/role_queryByID")
	@ResponseBody
	public List<Long> role_queryByID(Long eid){
		List result = null;
		result = employeeService.role_queryByID(eid);
		return result;
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public AjaxResult login(String username,String password,HttpServletRequest request){
		UserContext.set(request);
		AjaxResult result =null;
		Employee employee = employeeService.getEmployeeForLogin(username,password);
		if(employee!=null){
			request.getSession().setAttribute(UserContext.UserSession, employee);
			result = new AjaxResult(true,"登录成功");
			
		}else{
			result = new AjaxResult("用户名或者密码错误");
		}
		return result;	
	}
}
