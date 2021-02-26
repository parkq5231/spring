package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class JobDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	private static JobDAO instance;

	public static JobDAO getInstance() {
		if (instance == null) {
			instance = new JobDAO();
		}
		return instance;
	}

	// 전체 리스트 조회
	public ArrayList<JobVO> selectAll() {
		ArrayList<JobVO> list = new ArrayList<JobVO>();
		JobVO vo;
		String sql = "SELECT * FROM JOBS ";//
		try {
			conn = JdbcUtil.connect();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new JobVO();
				vo.setJob_id(rs.getString("job_id"));
				vo.setJob_title(rs.getString("job_title"));
				vo.setMin_salary(rs.getInt("min_salary"));
				vo.setMax_salary(rs.getInt("max_salary"));
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
