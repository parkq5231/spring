package com.company.yedam.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.emp.dao.DeptVO;
import com.company.yedam.emp.service.DeptService;

@Controller
public class DeptController {

	Logger logger = LoggerFactory.getLogger(DeptController.class);

	@Autowired
	DeptService deptService;

	// 부서목록
	@RequestMapping("/deptList")
	public String deptList(Model model) {
		model.addAttribute("deptList", deptService.deptList());
		return "dept/deptList";

	}

	// 등록폼
	@GetMapping("/deptInsert")
	public String deptInsert(HttpServletRequest request) {
		// request.setAttribute("deptList", deptService.selectAll());
		return "dept/deptInsert";
	}

	// 등록처리
	@PostMapping("/deptInsert")
	public String deptInsertPro(DeptVO vo) {
		logger.debug(vo.toString());
		deptService.deptInsert(vo);
		return "redirect:deptList";
	}
}
