<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${R}res/common.js"></script>
<link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
	<div class="container">
		<h1>My Page</h1>
		<hr />
		<table border=2>
			<thead>
				<tr>
					<td>학번</td>
					<td>학과</td>
					<td>이름</td>
					<td>성별</td>
					<td>학년</td>
					<td>휴대폰</td>
					<td>이메일</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${student.id}</td>
					<td>${student.departmentName}</td>
					<td>${student.name}</td>
					<td>${student.sex}</td>
					<td>${student.grade}</td>
					<td>${student.tel}</td>
					<td>${student.email}</td>
			</tbody>
		</table>
		<br>
		<u><a href="${R}user/studentEdit">정보수정 </a></u>
		<br><br>
		<form:form method="post" modelAttribute="myFile" enctype="multipart/form-data">
			<form:input path="file" type="file" accept=".xls,xlsx" style="width:250px;background-color:skyblue;" />
			<button type="submit">저장</button>
		</form:form>
		<br><br>
		<u><a href="${R}user/list">수강내역 보기</a></u>
		<br><br>
		<u><a href="${R}user/searchIndex">수강과목 검색</a></u>
		<br><br>
		<sec:authorize access="authenticated">
		<a href="${R}user/logout_processing">로그아웃</a>
		</sec:authorize>
		
</body>
</html>