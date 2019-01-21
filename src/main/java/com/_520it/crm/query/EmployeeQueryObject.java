package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class EmployeeQueryObject extends QueryObject {
	private String keyWord;
	private String State;
	private Integer dept_id;

}
