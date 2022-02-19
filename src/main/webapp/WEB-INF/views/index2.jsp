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
	<c:if test="${errs !=null}">
		<h5 style="color: red">${errs}</h5>
	</c:if>

	<br>
	<br>
	<c:if test="${errs == null}">

	<br>
		<c:forEach items="${productDto}" var="p">
     ${p.id} --- ${p.name} --- have price: ${p.price}
			<br>

		</c:forEach>
	</c:if>
</body>
</html>