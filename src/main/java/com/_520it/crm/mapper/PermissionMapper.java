package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Permission;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.query.PermissionQueryObject;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Permission record);
    Permission selectByPrimaryKey(Long id);
    List<Permission> selectAll();
    int updateByPrimaryKey(Permission record);
    Long queryForPageCount(PermissionQueryObject qo);
    List<Permission> queryForPage(PermissionQueryObject qo);
}