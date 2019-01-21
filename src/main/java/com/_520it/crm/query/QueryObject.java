package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class QueryObject {
	private Integer page;
	private Integer rows;
	public Integer getStart(){
		return this.page==null?0:(this.page-1)*this.rows;
	}
}
