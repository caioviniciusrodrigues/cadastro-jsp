<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" />

</head>
<body>

	<div class="container">
	
	<h1>Sistema XPTO</h1>
	<a class="nav-link" href="/cadastro-jsp/index.jsp">Sair</a>
		<hr>
		
		<div class="row">
			 <div class="col-sm-2">
				<div class="card" style="width: 8rem;">
				 	<a href="UsuarioServlet?acao=listAllUsers" role="button">
				  		<img class="card-img-top" src="assets/img/users.png" width="70" height="70"  alt="Cadastro de Usuarios" title="Cadastro de Usuarios">
				  	 </a>
				  <div class="card-body">
				    <p class="text-center"> Usuários </p>
				  </div>
				
				</div>
			</div>
			
			<div class="col-sm-2">
				<div class="card" style="width: 8rem;">
				 	<a href="ProdutoServlet?acao=listAllProdutos" role="button">
				  		<img class="card-img-top" src="assets/img/produtos.png" width="70" height="70"  alt="Cadastro de Usuarios" title="Cadastro de Usuarios">
				  	</a>
				  <div class="card-body">
				    <p class="text-center"> Produtos </p>
				  </div>				  
				</div>
			</div>			
		</div>
		
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/js/bootstrap.min.js"></script>

</body>
</html>