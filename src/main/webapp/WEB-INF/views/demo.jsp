<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.min.js"></script>


</head>
<body>
	<h3>Index</h3>
	<input id="btn1" type="button" value="demo1" />
	<div id="result1"></div>
	<input id="btn2" type="button" value="demo2" />
	<br>
	<input id="textBoxFullName" type="text" />
	<input type="button" value="demo3" id="btn3" />
	<br>
	<div id="result3"></div>
	<input id="textBoxFullNameP" type="text" />
	<input type="button" value="demo4" id="btn4" />
	<br>

	<input type="button" value="GetValue" id="btn5" />
	<div id="rsget"></div>
	<input type="button" value="GetManyValue" id="btn6" />
	<div id="rsgetN"></div>


	<script>
		$(document).ready(function() {
			$("#btn1").click(function() {

				$.ajax({
					type : 'GET',
					url : '/demo/demo1',
					success : function(data) {
						$("#result1").html(data);
					}

				})

			})
			$("#btn2").click(function() {

				$.ajax({
					type : 'POST',
					url : '/demo/demo2',
					success : function(data) {
						$("#result1").html(data);
					}

				})

			})
			//DUNG GET THI CO THAM SO TREN DUONG TRUYEN
			//viec chuyen huong trang hoan toan phu thuoc vao cuoc goi ajax
			//viec chuyen trang khac tren server se khong anh huong.
			//KHONG NEN DUNG AJAX GET NEU CO THONG TIN QUAN TRONG(SE BI HIEN THI)
			$("#btn3").click(function() {
				let fullName = $("#textBoxFullName").val();
				$.ajax({
					type : 'GET',
					url : '/demo/demo3',
					data : {
						fullName : fullName
					},
					success : function(data) {
						$("#result3").html(data);
					}

				})

			})
			//NEU DUNG AJAX POST THI SE KHONG CO THAM SO TREN DUONG TRUYEN
			$("#btn4").click(function() {
				let fullName = $("#textBoxFullNameP").val();
				$.ajax({
					type : 'POST',
					url : '/demo/demo3P',
					data : {
						fullName : fullName
					},
					success : function(data) {
						$("#result3").html(data);
					}

				})

			})

			//single value
			$("#btn5").click(function() {
				let fullName = $("#textBoxFullNameP").val();
				$.ajax({
					type : 'GET',
					url : '/demo/demo5',
					data : {
						fullName : fullName
					},
					success : function(product) {
						var rshtml = "id" + product.id;
						rshtml += "<br>name : " + product.name;
						rshtml += "<br> price: " + product.price;
						$("#rsget").html(rshtml);
					}

				})

			})
			//get array in json
			$("#btn6").click(function() {
				let fullName = $("#textBoxFullNameP").val();
				$.ajax({
					type : 'GET',
					url : '/demo/demo6',
					data : {
						fullName : fullName
					},
					success : function(products) {
						var rsn;
						
						products.map(function(proi){
						rsn += proi.name+" "+proi.price+"<br>";
						})
						
						$("#rsgetN").html(rsn);
					}

				})

			})

		})
	</script>
</body>
</html>