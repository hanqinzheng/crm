package com._520it.crm.mapper;

import com._520it.crm.domain.Role;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.query.RoleQueryObject;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Role record);
    Role selectByPrimaryKey(Long id);
    List<Role> selectAll();
    int updateByPrimaryKey(Role record);
    Long queryForPageCount(RoleQueryObject qo);
    List<Role> queryForPage(RoleQueryObject qo);
    void insertRelation(@Param("rid")Long rid,@Param("pid")Long pid);
    void deleteRelation(Long id);
}