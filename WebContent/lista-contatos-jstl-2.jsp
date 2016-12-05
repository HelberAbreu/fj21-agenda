<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Projeto fj21-agenda</title>
</head>
<body>
	<div class="container">

		<c:import url="cabecalho.jsp"></c:import>
		      <div class="jumbotron">
			<form action="mvc">
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Endereco</th>
						<th>Data Nascimento</th>
						<th></th>
					</tr>
					<c:forEach var="contato" items="${contatos}">
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
							<td>
								<input type="hidden" name="logica" value="ListarContatoLogica"/>
								<input type="hidden" name="id" value="${contato.id}"/>
							    
							    <a href="/agenda/mvc?id=${contato.id}&logica=ListarContatoLogica" ><i class="fa fa-edit"></i></a>
							    <a href="/agenda/mvc?id=${contato.id}&logica=RemoverContatoLogica"><i class="fa fa-remove"></i></a>
							    
							 </td>							
						</tr>
					</c:forEach>
				</table>	
			</form>			
					<a href="/agenda/index.jsp" class="btn btn-primary">Cadastrar novo Contato</a>
			  </div>
		
		<c:import url="rodape.jsp"></c:import>
		
	</div>
</body>
</html>