<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept/deptList.jsp</title>
</head>
<body>
	<div align="center">
		<h3>부서목록</h3>
		<table border="1">
			<c:forEach items="${deptList}" var="dept">
				<tr>
					<td>${dept.department_id}</td>
					<td>${dept.department_name}</td>
					<td>${dept.manager_id}</td>
					<td>${dept.location_id}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>