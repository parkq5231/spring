<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
  <script>
  	$(function(){
  		//이메일중복채크
  		$("#btnEmail").on("click",function(){
  			//var param = {email : $("[name=email]").val()};
  			var param = "email=" + $("[name=email]").val();
  			//ajax
  			$.ajax({
  					url: "../EmailCheck?",
  					data : param,		// 서버에 보낼 parameter
  					dataType:"xml",	// 결과 타입을 의미함
  					//data : {email : $("[name=email]").val()},
  					success : function(response) {
  						//result span tag
  						
  						//json
  						/* if(response.email){	//true false를 의미
  							$("#emailResult").html("<font color='blue'>사용가능</font>");
  						}else{
  							$("#emailResult").html("<font color='red'>사용불가능</font>");
  						} */
  						
  						//xml
  							$("#emailResult").html($(response).find("email").html());
  						
  					}//end of success
  				});//end of ajax
  		});//end of btnEmail
  		$("#search").on("click",function(){
  			//매니저 ,이름
  			var id = "managerId=" + $("[name=manager_id]").val();
  			//search 눌렀을 때의 화면
  			$.ajax({
  				url: "../EmpSearch?",
  				data : id,
  				success: function(response){
  			window.open("../EmpSearch","매니저 조회", "toolbar=yes,scrollbars=yes,resizable=yes,top=100,left=600,width=400,height=400");
  				}
  			})
  		})
  	})
  </script>
</head>
<body>
<h3 id="top">사원등록</h3>
<c:set var="url" value="empInsert" />
<c:if test="${not empty empVO.employee_id}">
<c:set var="url" value="empUpdate" />
</c:if>
<form action="${url}" method="post" name="frm">
	employee_id <input type="number" name="employee_id" value="${empVO.employee_id}"
				<c:if test="${not empty empVO.employee_id}"> readonly="readonly"</c:if> ><br>
	first_name  <input name="first_name" value="${empVO.first_name}"><br>
	last_name   <input name="last_name" value="${empVO.last_name}"><br>
	email       <input type="email" name="email" value="${empVO.email}">
				<button type="button" id="btnEmail">중복채크</button>
				<span id ="emailResult"></span><br>
	phone_number<input type="text" name="phone_number" value="${empVO.phone_number}"><br>
	hire_date   <input type="date" name="hire_date" value="${empVO.hire_date}"><br>
	job_id       
	<select name="job_id">
	<c:forEach var="job" items="${jobList}" >
		<option value="${job.job_id}"
		<c:if test="${job.job_id==empVO.job_id}">
		selected="selected"</c:if>>
		${job.job_title}</option>
	</c:forEach>	
	</select><br>
	department_id 
	<c:forEach var="dept" items="${deptList}">
		<input type="radio" name = "deptid" value="${dept.department_id}"
			<c:if test="${dept.department_id == empVO.department_id}">
			checked="checked"</c:if>>
		${dept.department_name}
	</c:forEach><br>
	manager_id 
	<input type="text" name="manager_id">
	<input type="text" name="name">
	<button type="button" onclick="window.open('empSearch','emp',' top=100,left=600, width=600, height=600')">사원검색</button><br>	

	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>

</body>
</html>
