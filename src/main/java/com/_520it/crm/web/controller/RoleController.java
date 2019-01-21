package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Role;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.RoleQueryObject;
import com._520it.crm.service.IRoleService;
import com._520it.crm.util.AjaxResult;

@Controller
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	@RequestMapping("/role_save")
	@ResponseBody
	public AjaxResult Role_save(Role role){
		AjaxResult result = null;
		try {
			roleService.insert(role);
			result = new AjaxResult(true,"保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult("保存失败");
		}
		return result;
	}
	@RequestMapping("/role_list")
	@ResponseBody
	public PageResult Role_list(RoleQueryObject qo){
		PageResult result = null;
		result = roleService.queryForPage(qo);
		return result;
	}
	
	@RequestMapping("/role_delete")
	@ResponseBody
	public AjaxResult Role_delete(Long id){
		AjaxResult result = null;
		try {
			roleService.deleteByPrimaryKey(id);
			result = new AjaxResult(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult("删除失败失败");
		}
		return result;
	}
	
	@RequestMapping("/role_update")
	@ResponseBody
	public AjaxResult role_update(Role role){
		AjaxResult result = null;
		try {
			roleService.updateByPrimaryKey(role);
			result = new AjaxResult(true,"更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult("更新失败");
		}
		return result;
	}
	
	@RequestMapping("/RoleList")
	@ResponseBody
	public List<Role> RoleList(){
		 List<Role> list = roleService.selectAll();
		return list;
	}
}
