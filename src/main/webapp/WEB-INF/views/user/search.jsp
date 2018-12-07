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
		<h1>수강과목</h1>
		<hr />
		<form action="search">
		<input type="text" name="subjectName" value="${myCell.subjectName}"/>
		<button type="submit" class="btn btn-primary">검색</button>
		</form>
		<br>
		<table border=2>
			<thead>
				<tr>
					<td>년도</td>
					<td>학기</td>
					<td>과목코드</td>
					<td>과목명</td>
					<td>이수구분</td>
					<td>학점</td>
					<td>성적 등급</td>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>${myCell.year}</td>
						<td>${myCell.semester }</td>
						<td>${myCell.subjectId }</td>
						<td>${myCell.subjectName }</td>
						<td>${myCell.completeType }</td>
						<td>${myCell.subjectScore }</td>
						<td>${myCell.grade }</td>
					</tr>
			</tbody>
		</table>
		<br>
		
		<sec:authorize access="authenticated">
		<p>
		<a href="${R}user/logout_processing">로그아웃</a>
		<a href="${R}user/index">되돌아가기</a>
		</p>
		</sec:authorize>
		
</body>
</html>