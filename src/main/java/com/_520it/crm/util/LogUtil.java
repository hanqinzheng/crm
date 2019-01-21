package com._520it.crm.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Log;
import com._520it.crm.service.ILogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LogUtil {
	@Autowired
	private ILogService logService;
	public void writeLog(JoinPoint jointPsoint){
		if(jointPsoint.getTarget() instanceof ILogService){
			return;
		}
		Log log = new Log();
		log.setOptime(new Date());
		HttpServletRequest request = UserContext.get();
		Employee employee = (Employee) request.getSession().getAttribute(UserContext.UserSession);
		log.setOpuser(employee);
		log.setOpip(request.getRemoteAddr());
		String function = jointPsoint.getTarget().getClass().getName()+":"+jointPsoint.getSignature().getName();
		log.setFunction(function);
		ObjectMapper mapper = new ObjectMapper();
		String params;
		try {
			params = mapper.writeValueAsString(jointPsoint.getArgs());
			log.setParams(params);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		logService.insert(log);
	}
}
