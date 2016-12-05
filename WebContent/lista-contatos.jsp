<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.jus.tjdft.factory.ConnectionFactory"%>
<%@page import="br.jus.tjdft.pojo.Contato"%>
<%@page import="br.jus.tjdft.dao.ContatoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Projeto fj21-agenda</title>
	<style>
	</style>
</head>
<body>
	<div class="container">

			<form action="agenda">
		      <div class="jumbotron">

				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Endereco</th>
						<th>Data Nascimento</th>
						<th>Excluir</th>
					</tr>
					<%
						ContatoDAO dao = new ContatoDAO(ConnectionFactory.getConexao());
						
						SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
					
						for(Contato c : dao.buscarContatos()){
							%>
								<tr>
									<td><%=c.getId() %></td>
									<td><%=c.getNome() %></td>
									<td><%=c.getEmail() %></td>
									<td><%=c.getEndereco() %></td>
									<td><%=sd.format(new Date(c.getDataNascimento().getTimeInMillis()))%></td>
									<td><button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-trash"></i></button></td>
								</tr>
							<%
						}
					 %>
				</table>
				
			  </div>
			</form>

	</div>
</body>
</html>