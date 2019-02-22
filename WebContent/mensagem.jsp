<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

	<c:if test="${not empty erro}">
		<div class="alert alert-danger" id="alert">
		    <button type="button" class="close" data-dismiss="alert">x</button>
		    <strong>Erro:  </strong>
		    ${erro}
		</div>
	</c:if>
	
	<c:if test="${not empty sucesso}">
		<div class="alert alert-success" id="alert">
		    <button type="button" class="close" data-dismiss="alert">x</button>
		    <strong>Sucesso:  </strong>
		    ${sucesso}
		</div>
	</c:if>