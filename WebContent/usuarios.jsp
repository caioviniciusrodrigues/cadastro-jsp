<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<c:import url="header.jsp" />
		
	<div class="card">  
	  <div class="card-body">
	    <h5 class="card-title">Cadastro de Usuários</h5>   
	    <c:import url="mensagem.jsp" />     
	  </div>

	  <div class="card-body">
			<form method="post" action="UsuarioServlet">

			<div class="form-group">
				<label for="nome">Id</label> 
					<input type="text" readonly class="form-control" name="id" id="id" value="${ user.id }">
			</div>			

			<div class="form-group">
				<label for="nome">Nome</label> 
					<input type="text" class="form-control" name="name" id="name" value="${ user.name }" placeholder="Nome">
			</div>

			<div class="form-group">
				<label for="email">E-mail</label> 
					<input type="email"	class="form-control" name="email" id="email" value="${ user.email }" placeholder="name@example.com">
			</div>

			<div class="form-group">
				<label for="login">Login</label> 
					<input type="text"	class="form-control" name="login" id="login" value="${ user.login }" placeholder="Nome">
			</div>

			<div class="form-group">
				<label for="password">Password</label> 				
					<input type="password"	class="form-control" id="password" name="password"  value="${ user.password }">
			</div>
			
			<div class="form-group">
				<label for="fone">Fone</label> 
					<input type="text"	class="form-control" id="fone" name="fone" value="${ user.fone }">
			</div>

			<div class="form-group">
				<label for="status">Status</label> 
					<input type="text"	class="form-control" id="status" name="status" value="${ user.status }">
			</div>


			<button type="submit" class="btn btn-primary">Salvar</button>
			
			<a class="btn btn-primary" href="UsuarioServlet?acao=listAllUsers" >Cancelar</a>


		</form>

		<div class="table-responsive mt-4">
			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nome</th>
						<th scope="col">Login</th>
						<th scope="col">E-mail</th>
						<th scope="col">Fone</th>
						<th scope="col">Ação</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="lista" items="${lista}">
						<tr>
							<td><c:out value="${lista.id}" /></td>
							<td><c:out value="${lista.name}" /></td>
							<td><c:out value="${lista.login}" /></td>
							<td><c:out value="${lista.email}" /></td>
							<td><c:out value="${lista.fone}" /></td>
							<td>
								<a href="UsuarioServlet?acao=excluir&id=${lista.id}">
									<img src="assets/img/excluir.png" width="30" height="30" alt="excluir" title="excluir"/>
								</a> &nbsp; &nbsp; 
								<a href="UsuarioServlet?acao=editar&id=${lista.id}">
									<img src="assets/img/editar.png" width="30" height="30" alt="editar" title="editar" />
								</a>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	  </div>
	</div>
	

	
<c:import url="footer.jsp" />