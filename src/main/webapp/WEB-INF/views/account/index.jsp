<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/account/add">ADD NEW</a>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>User Name</th>
			<th>Full Name</th>
			<th>gender</th>
			<th>action</th>
		</tr>

		<c:forEach items="${accounts}" var="a">
			<tr>
				<td>${a.id}</td>
				<td>${a.userName}</td>
				<td>${a.fullName}</td>
				<td>${a.gender}</td>
				<td><a href="/account/edit/${a.id}"> Edit</a></td>
				<td><input type="button" onclick="del(${a.id})" value="Del"
					class="btn btn-danger"></td>
			</tr>

		</c:forEach>
	</table>

	<script>
	function del(accId) {
		 /* console.log("/account/del/"+accId);*/
		  fetch("/account/del/"+accId, {
		    method : "delete"
		    
		  }).then(function() {
		    console.log("thanhcong");
		    /*window.location.href = "/account";*/
		    location.reload();
		  })
		  

		}
	</script>

</body>

</html>