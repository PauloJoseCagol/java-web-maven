<%@page import="com.javaweb.maven.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.jsp" %>

<%
	Usuario u = (Usuario)request.getAttribute("usuario");
%>
<center>
		<form action="/javawebmaven/usucontroller" method="post">
			<label>ID</label> 
			<input type="number" name="id" value="<%=u.getId()%>" /> 
			<label>Nome</label> 
			<input type="text" name="nome" value="<%=u.getNome()%>" /> 
			<label>Login</label>
			<input type="text" name="login" value="<%=u.getLogin()%>" /> 
			<label>Senha</label> 
			<input type="password" name="senha" value="<%=u.getSenha()%>" /> 
			<input type="submit" value="Gravar" />
			<input type="button" value="Novo" onclick="javascript:novo()" />
		</form>
	</center>
</body>
</html>