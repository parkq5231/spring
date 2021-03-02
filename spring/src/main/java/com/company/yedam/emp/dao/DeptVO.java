package com.company.yedam.emp.dao;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class DeptVO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;

}
