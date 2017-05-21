<%@page import="com.javaweb.maven.persistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function confirmaExclusao(id) {
	if(window.confirm("Confirma ação de exclusão?")){
		location.href=("/javawebmaven/usucontroller?acao=exc&id="+id);
	}
}
function novo() {
	location.href='/javawebmaven/usucontroller?acao=cad';
}
</script>
</head>
<body>

<%@include file="menu.jsp" %>

	<center>
		<h1>Lista de Usuários</h1>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Login</th>
				<th>Senha</th>
			</tr>

			<%
				List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
				for (Usuario u : lista) {
			%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getNome()%></td>
				<td><%=u.getLogin()%></td>
				<td><%=u.getSenha()%></td>
				<td><a href="javascript:confirmaExclusao(<%=u.getId()%>)">Exclir</a> || <a href="/javawebmaven/usucontroller?acao=alt&id=<%=u.getId()%>">Editar</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<input type="button" value="Novo" onclick="javascript:novo()" />
	</center>
</body>
</html>