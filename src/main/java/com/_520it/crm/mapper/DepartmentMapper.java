package com._520it.crm.mapper;

import com._520it.crm.domain.Department;
import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();
    List<Department> selectAllList();
    int updateByPrimaryKey(Department record);

	List<Department> queryForDept();
}