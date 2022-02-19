<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="myForm" action="" method="post">
		username <input type="text" id="e1" name="userName"> <br />
		fullname <input type="text" id="e2" name="fullName"> <br />
		password <input type="password" id="e3" name="password"> <br />
		gender<input type="radio" id="e6" name="gender" value=1> Male
		<input type="radio" value=0 name="gender" id="e5"> FeMale <br />
		dob :<input type="date" id="e4" name="birthday"> <br /> <input
			onclick="add()" type="submit" value="Gui">
	</form>
</body>

<script>
	function add() {
		event.preventDefault();
		data = {};
		data["userName"] = document.getElementById('e1').value;
		data["fullName"] = document.getElementById('e2').value;
		data["password"] = document.getElementById('e3').value;
		if (document.getElementById('e6').value !== null) {
			data["gender"] = document.getElementById('e6').value;

		} else {
			data["gender"] = document.getElementById('e5').value;
		}

		data["birthday"] = document.getElementById('e4').value;

		console.log(data);

		fetch("/account/add", {
			method : "post",
			body : JSON.stringify(data),
			headers : {
				"Content-Type" : "application/json",
			},
		}).then(function(res) {
			console.log(res);
			window.location.href = "/account";
		})

	}
</script>
</html>