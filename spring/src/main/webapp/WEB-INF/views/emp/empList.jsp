<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/empList.jsp</title>
</head>
<body>
	<h3>사원목록</h3>
	<c:forEach items="${list}" var="emp">
		${emp.first_name} ${emp.email} ${emp.salary}<br>
	</c:forEach>
</body>
</html>