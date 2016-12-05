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

		      <div class="jumbotron">
				<form action="mostra-idade.jsp">
					Idade: <input type="text" name="idade"/>
					<input type="submit"/>
				</form>
			  </div>

	</div>
</body>
</html>