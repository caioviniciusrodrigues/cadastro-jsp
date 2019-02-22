<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="header.jsp" />

	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title">Cadastro de Produtos</h5>	
	    <c:import url="mensagem.jsp" />    
	  </div>
	  
	  <div class="card-body">

		<form method="post" action="ProdutoServlet">

			<div class="form-group">
				<label for="nome">Id</label> 
					<input type="text" readonly class="form-control" name="id" id="id" value="${ produto.id }">
			</div>			

			<div class="form-group">
				<label for="nome">Nome</label> 
					<input type="text" class="form-control" name="nome" id="nome" value="${ produto.nome }" placeholder="Nome">
			</div>

			<div class="form-group">
				<label for="quantidade">Quantidade</label> 
					<input type="number"	class="form-control" name="quantidade" id="quantidade" value="${ produto.quantidade }" placeholder="quantidade">
			</div>

			<div class="form-group">
				<label for="valor">Valor</label> 
					<input type="text"	class="form-control" name="valor" maxlength="10" id="valor" value="${ produto.valor }" placeholder="Valor">
			</div>					

			<button type="submit" class="btn btn-primary">Salvar</button>
			
			<a class="btn btn-primary" href="ProdutoServlet?acao=listAllProdutos" >Cancelar</a>


		</form>

		<div class="table-responsive mt-4">
			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nome</th>
						<th scope="col">Quantidade</th>
						<th scope="col">Valor</th>						
						<th scope="col">Ação</th>
					</tr>
				</thead>
				<tbody>				 				 	
				
					<c:forEach var="lista" items="${lista}">
					<fmt:setLocale value="pt-BR" />
					<fmt:formatNumber var = "v" value="${lista.valor}" type="currency"/>
						<tr>
							<td><c:out value="${lista.id}" /></td>
							<td><c:out value="${lista.nome}" /></td>
							<td><c:out value="${lista.quantidade}" /></td>
							<td><c:out value="${v}" /></td>							
							<td>
								<a href="ProdutoServlet?acao=excluir&id=${lista.id}">
									<img src="assets/img/excluir.png" width="30" height="30" alt="excluir" title="excluir"/>
								</a> &nbsp; &nbsp; 
								<a href="ProdutoServlet?acao=editar&id=${lista.id}">
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