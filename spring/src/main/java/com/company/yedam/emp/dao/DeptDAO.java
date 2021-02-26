package com.company.yedam.emp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DeptDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	private static DeptDAO instance;

	
	//
	public static DeptDAO getInstance() {
		if (instance == null) {
			instance = new DeptDAO();
		}
		return instance;
	}

	// 전체 리스트 조회
	public ArrayList<DeptVO> selectAll() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		DeptVO vo;
		String sql = "SELECT "//
				+ "DEPARTMENT_ID, "//
				+ "DEPARTMENT_NAME, "//
				+ "MANAGER_ID, "//
				+ "LOCATION_ID "//
				+ "FROM DEPARTMENTS "//
				+ "ORDER BY DEPARTMENT_ID";
		try {
			conn = JdbcUtil.connect();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new DeptVO();
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setManager_id(rs.getInt("manager_id"));
				vo.setLocation_id(rs.getInt("location_id"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}

}
