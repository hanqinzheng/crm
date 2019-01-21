package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Log;

public interface ILogService {
    int deleteByPrimaryKey(Long id);
    int insert(Log record);
    Log selectByPrimaryKey(Long id);
    List<Log> selectAll();
    int updateByPrimaryKey(Log record);
	
}
