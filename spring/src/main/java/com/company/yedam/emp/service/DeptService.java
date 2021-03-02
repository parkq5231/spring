package com.company.yedam.emp.service;

import java.util.ArrayList;

import com.company.yedam.emp.dao.DeptVO;
import com.company.yedam.emp.dao.EmpVO;

public interface DeptService {

	// insert
	void deptInsert(DeptVO vo);

	// list
	ArrayList<DeptVO> deptList();

	// selectOne
	EmpVO selectOne(DeptVO vo);

}
