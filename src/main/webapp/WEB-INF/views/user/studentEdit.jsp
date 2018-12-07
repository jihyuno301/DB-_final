<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h1>개인정보 수정</h1>
		<hr />
		<form method="post" modelAttribute="student">
			<div class="form-group">
				<label>아이디(학번):</label> 
				<input type="text" name="id" value=${student.id} class="form-control w200" />
			</div>

			<div class="form-group">
				<label>학과:</label> <input type="text" name="departmentName" value=${student.departmentName} 
					class="form-control w200" />
			</div>
			<div class="form-group">
				<label>이름:</label> <input type="text" name="name" value=${student.name} 
					class="form-control w200" />
			</div>
			<div class="form-group">
				<label>성별:</label> <input type="text" name="sex" value=${student.sex} 
					class="form-control w200" />
			</div>
			<div class="form-group">
				<label>학년:</label> <input type="text" name="grade" value=${student.grade} 
					class="form-control w200" />
			</div>
			<div class="form-group">
				<label>휴대번호:</label> <input type="text" name="tel" value=${student.tel} 
					class="form-control w200" />
			</div>
			<div class="form-group">
				<label>이메일:</label> <input type="email" name="email" value=${student.email} 
					class="form-control w200" />
			</div>
			<div>
				<input type="hidden" name="password" value="test1234"
					class="form-control w200" />
			</div>
			<div>
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-ok"></span>수정
				</button>
			</div>
		</form>

	</div>
</body>
</html>