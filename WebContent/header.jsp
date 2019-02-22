<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" />

<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

<script>
$(document).ready(function ($) {
	 
	window.setTimeout(function() {
	    $("#alert").hide();
	}, 5000);
	
	
	$('#fone').mask('(00) 00000-0000');
	
	$('#valor').mask('#.##0,00', {reverse: true});

	 
});
	
	
</script>

</head>
<body>
<div class="container">	
	<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #4682B4; color: #FFFFFF;">
		  <a class="navbar-brand" href="#"></a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
	  <!-- Links -->
	  
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
	      <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="acessoliberado.jsp">Home</a>
		      </li>
		      
		      <li class="nav-item active">
		        <a class="nav-link" href="UsuarioServlet?acao=listAllUsers">Usuários</a>
		      </li>
		      
		      <li class="nav-item active">
		        <a class="nav-link" href="ProdutoServlet?acao=listAllProdutos">Produtos</a>
		      </li>
		      	      
		      <li class="nav-item active">
		        <a class="nav-link" href="/cadastro-jsp/index.jsp">Sair</a>
		      </li>
		  </ul>
		</div>
	</nav>

