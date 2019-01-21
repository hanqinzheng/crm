package com._520it.crm.util;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class AjaxResult {
	private boolean success = false;
	private String msg;
	public AjaxResult(String msg) {
		super();
		this.msg = msg;
	}
	public AjaxResult(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
}
