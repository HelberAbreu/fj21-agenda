<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			

			<form action="mvc">
			
				<div class="jumbotron">
				  <div class="form-group" >
				    <label for="exampleInputEmail1">Nome</label>
				    <input type="text" class="form-control" name="nome" value="${contato.nome}">
				  </div>			  
				  <div class="form-group">
				    <label for="exampleInputEmail1">E-mail</label>
				    <input type="text" class="form-control" name="email" value="${contato.email}">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Endereco</label>
				    <input type="text" class="form-control" name="endereco" value="${contato.endereco}">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Data de Nascimento</label>
				    <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" var="data"/>
				    <input type="text" class="form-control" name="dtNascimento" value="${data}">
				  </div>
				  
				  
				  <input type="hidden" name="id" value="${contato.id}" />
				  <input type="hidden" name="logica" value="ManterContatoLogica" />
				  		
				  <button type="submit" class="btn btn-primary btn-lg btn-block">Alterar</button>
			  </div>
			</form>

	</div>
</body>
</html>