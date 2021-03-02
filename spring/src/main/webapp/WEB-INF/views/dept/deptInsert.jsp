<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h3 id="top">부서등록</h3>
	<form id="frm" action="./deptInsert" method="post">
	DEPARTMENT_ID: <input type="number" name="department_id" value="${dept.department_id}"><br>
	DEPARTMENT_NAME: <input type="text" name="department_name" value="${dept.department_name}"><br>
	MANAGER_ID: <input type="number" name="manager_id" value="${dept.manager_id}"><br>
	LOCATION_ID: <input type="text" name="location_id" value="${dept.location_id}"><br>
	<button onclick="window.open('deptSearch','deptList','top=100,left=600,width=600,height=600')">부서검색</button><br>
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
	</form>
</div>
</body>
</html>