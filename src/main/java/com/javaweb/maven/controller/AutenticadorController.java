package com.javaweb.maven.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaweb.maven.persistencia.entidade.Usuario;
import com.javaweb.maven.persistencia.jdbc.UsuarioDAO;
 
@WebServlet("/autenticador")
public class AutenticadorController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//Com false, se ele não encontrar a sessão ele não irá criar outra.
		//Pois se ele não achar o getSession sem o poder de criar sessões.
		HttpSession sessao = request.getSession(false);
		
		if(sessao!=null){
			sessao.invalidate();
		}
		response.sendRedirect("login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);

		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuAutenticado = usuDao.autenticar(usuario);

		if (usuAutenticado != null) {
			// Pegando, ou criando a sessão onde o usuário está autenticado.
			HttpSession sessao = request.getSession();
			// Atribuindo o usuário autenticado em uma chave.
			sessao.setAttribute("usuAutenticado", usuAutenticado);
			
			sessao.setMaxInactiveInterval(60*5);
			// Rdirecionando usuário para a tela principal.
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

		} else {
			response.getWriter()
					.print("<script> alert('Usuário não encontrado!'); " 
			+ "location.href='login.html' </script>");
		}

	}
}