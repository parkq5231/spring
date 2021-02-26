package com.company.yedam.emp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class EmpDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// 전체조회 select * from employees
	public ArrayList<EmpVO> selectList() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT "//
					+ "EMPLOYEE_ID, "//
					+ "FIRST_NAME, "//
					+ "LAST_NAME, "//
					+ "EMAIL, "//
					+ "PHONE_NUMBER, "//
					// + "to_char(HIRE_DATE,'yyyy-MM') hire_date, "//
					+ "HIRE_DATE, "//
					+ "JOB_ID, "//
					+ "SALARY, "//
					+ "COMMISSION_PCT, "//
					+ "MANAGER_ID, "//
					+ "DEPARTMENT_ID "//
					+ "FROM EMPLOYEES "//
					+ "ORDER BY EMPLOYEE_ID";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString(1));
//				vo.setEmployee_id(rs.getString("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString(4));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setSalary(rs.getString("salary"));
				vo.setCommission_pct(rs.getString("commission_pct"));
				vo.setManager_id(rs.getString("manager_id"));
				vo.setDepartment_id(rs.getString("department_id"));
				if (vo.getCommission_pct() == null || vo.getManager_id() == null) {
					vo.setCommission_pct("추가수당 x");
					vo.setManager_id(rs.getString("employee_id"));
				}
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.disconnect(conn);
		}

		return list;
	}

	// 단건조회 select * from employees where employee_id = ?;
	public EmpVO selectOne(String id) {
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT "//
					+ "EMPLOYEE_ID, "//
					+ "FIRST_NAME, "//
					+ "LAST_NAME, "//
					+ "EMAIL, "//
					+ "PHONE_NUMBER, "//
					+ "HIRE_DATE, "//
					+ "JOB_ID, "//
					+ "SALARY, "//
					+ "COMMISSION_PCT, "//
					+ "MANAGER_ID, "//
					+ "DEPARTMENT_ID "//
					+ "FROM EMPLOYEES "//
					+ "WHERE EMPLOYEE_ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new EmpVO();
				// vo.setEmployee_id(rs.getString(1));
				vo.setEmployee_id(rs.getString("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setSalary(rs.getString("salary"));
				vo.setCommission_pct(rs.getString("commission_pct"));
				vo.setManager_id(rs.getString("manager_id"));
				vo.setDepartment_id(rs.getString("department_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}

	// 이메일 조회
	public EmpVO selectOneByEmail(String id) {
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT "//
					+ "EMPLOYEE_ID, "//
					+ "FIRST_NAME, "//
					+ "LAST_NAME, "//
					+ "EMAIL, "//
					+ "PHONE_NUMBER, "//
					+ "HIRE_DATE, "//
					+ "JOB_ID, "//
					+ "SALARY, "//
					+ "COMMISSION_PCT, "//
					+ "MANAGER_ID, "//
					+ "DEPARTMENT_ID "//
					+ "FROM EMPLOYEES "//
					+ "WHERE EMAIL = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString(1));
//				vo.setEmployee_id(rs.getString("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}

	// EMP 등록용
	public void empInsert(EmpVO vo) {
		try {
			// 1.connect
			conn = JdbcUtil.connect();
			// 2. statement(sql구문)
			String sql = "INSERT INTO EMPLOYEES "//
					+ "EMPLOYEE_ID, " //
					+ "FIRST_NAME, "//
					+ "LAST_NAME, "//
					+ "EMAIL, "//
					+ "PHONE_NUMBER, "//
					+ "HIRE_DATE, "//
					+ "JOB_ID "//
					+ "DEPARTMENT_ID, "//
					+ "MANAGER_ID "//
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			// 3.execute
			psmt.setString(1, vo.getEmployee_id());
			psmt.setString(2, vo.getFirst_name());
			psmt.setString(3, vo.getLast_name());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getPhone_number());
			psmt.setDate(6, vo.getHire_date());
			psmt.setString(7, vo.getJob_id());
			psmt.setString(8, vo.getDepartment_id());
			psmt.setString(9, vo.getManager_id());
			int r = psmt.executeUpdate();
			System.out.println(r + "건이 등록됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.close
			JdbcUtil.disconnect(conn);
		}
	}

	// insert
	public void insert(EmpVO vo) {
		try {
			// 1.connect
			conn = JdbcUtil.connect();
			// 2. statement(sql구문)
			String sql = "INSERT INTO EMPLOYEES "//
					+ "(EMPLOYEE_ID, " //
					+ "LAST_NAME, "//
					+ "EMAIL, "//
					+ "HIRE_DATE, "//
					+ "JOB_ID)"//
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			// 3.execute
			psmt.setString(1, vo.getEmployee_id());
			psmt.setString(2, vo.getLast_name());
			psmt.setString(3, vo.getEmail());
			psmt.setDate(4, vo.getHire_date());
			psmt.setString(5, vo.getJob_id());
			int r = psmt.executeUpdate();
			System.out.println(r + "건이 등록됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.close
			JdbcUtil.disconnect(conn);
		}
	} // end of insert

	// update
	public void update(EmpVO vo) {
		try {
			// 1.connect
			conn = JdbcUtil.connect();
			String sql = "UPDATE EMPLOYEES "//
					+ "SET LAST_NAME = ?, "//
					+ "EMAIL =  ?, "//
					+ "JOB_ID = ?, "//
					+ "MANAGER_ID = ? "//
					+ "WHERE EMPLOYEE_ID = ?";
			// 2.psmt(sql구문)
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getLast_name());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getJob_id());
			psmt.setString(4, vo.getManager_id());
			psmt.setString(5, vo.getEmployee_id());
			// 3.execute
			int r = psmt.executeUpdate();
			System.out.println(r + "건 업데이트.");
			// 4.resultset(select = 조회결과)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.close
			JdbcUtil.disconnect(conn);
		}
	} // end of update

} // end of class