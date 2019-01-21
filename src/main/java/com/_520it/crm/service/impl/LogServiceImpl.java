package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Log;
import com._520it.crm.mapper.LogMapper;
import com._520it.crm.service.ILogService;
@Service
public class LogServiceImpl implements ILogService {
	@Autowired
	private LogMapper logmapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return logmapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Log record) {
		return logmapper.insert(record);
	}

	@Override
	public Log selectByPrimaryKey(Long id) {
		return logmapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Log> selectAll() {
		return logmapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Log record) {
		return logmapper.updateByPrimaryKey(record);
	}

}
