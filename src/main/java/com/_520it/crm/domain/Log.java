package com._520it.crm.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Setter@Getter
public class Log {
    private Long id;
    private Employee opuser;
    private Date optime;
    private String opip;
    private String function;
    private String params;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employee getOpuser() {
		return opuser;
	}
	public void setOpuser(Employee opuser) {
		this.opuser = opuser;
	}
	public Date getOptime() {
		return optime;
	}
	public void setOptime(Date optime) {
		this.optime = optime;
	}
	public String getOpip() {
		return opip;
	}
	public void setOpip(String opip) {
		this.opip = opip;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
}