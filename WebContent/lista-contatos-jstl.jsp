<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Projeto fj21-agenda</title>
</head>
<body>
	<div class="container">

		<c:import url="cabecalho.jsp"></c:import>
		
				
		<label class=""></label>
		<div class="alert alert-success">
		  <strong>Successo!</strong> Contato ${param.nome} adicionado com sucesso!!
		</div>
		<jsp:useBean id="dao" class="br.jus.tjdft.dao.ContatoDAO"></jsp:useBean>
			<form action="agenda">
		      <div class="jumbotron">

				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Endereco</th>
						<th>Data Nascimento</th>
					</tr>
					<c:forEach var="contato" items="${dao.buscarContatos()}">
						<tr>
							<td>${contato.id}</td>
							<td>${contato.nome}</td>
						  <c:if test="${!empty contato.email}">
							<td> <a href="mailto:${contato.email}">${contato.email}</a></td>
						  </c:if>
						  <c:if test="${empty contato.email}">
							<td>${contato.email}</td>
						  </c:if>					
							<td>${contato.endereco}</td>
							<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
						</tr>
					</c:forEach>
					
				</table>
				
			  </div>
			</form>
		
		<c:import url="rodape.jsp"></c:import>
		
	</div>
</body>
</html>