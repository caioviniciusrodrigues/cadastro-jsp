<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acesso</title>
<link rel="stylesheet" type="text/css" href="assets/css/login.css" />
</head>
<body>
	
	<div class="login-page">
	<h1 style="text-align: center;">XPTO</h1>
		<div class="form">
			<form class="login-form"  method="POST" action="LoginServlet">
				<input type="text" name="login" placeholder="Login" /> 
				<input type="password" name="password" placeholder="password" />
				<button>login</button>
			</form>
		</div>
	</div>
</body>
</html>