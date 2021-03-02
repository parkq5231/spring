package com.company.yedam.emp.service;

import java.util.ArrayList;

import com.company.yedam.emp.dao.EmpVO;

public interface EmpService {
	// insert
	void empInsert(EmpVO vo);

	// update
	void empUpdate(EmpVO vo);

	// delete
	void empDelete(EmpVO vo);

	// select
	EmpVO empSearch(EmpVO vo);

	// list
	ArrayList<EmpVO> empList();

	// selectOne
	EmpVO selectOne(EmpVO vo);

}
