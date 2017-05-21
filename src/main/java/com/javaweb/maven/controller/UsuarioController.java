package com.javaweb.maven.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.maven.persistencia.entidade.Usuario;
import com.javaweb.maven.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usucontroller")
public class UsuarioController extends HttpServlet {

	public UsuarioController() {
		// TODO Auto-generated constructor stub
		System.out.println("Construtor");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init()...");
		super.init();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy()...");
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		if (request.getParameter("acao").equals("exc")) {
			Usuario usu = new Usuario();
			if (request.getParameter("id") != null)
				usu.setId(Integer.parseInt(request.getParameter("id")));

			UsuarioDAO usuDao = new UsuarioDAO();
			usuDao.excluir(usu);
			response.sendRedirect("usucontroller?acao=lis");

		} else if (request.getParameter("acao").equals("lis")) {
			UsuarioDAO usuDao = new UsuarioDAO();
			List<Usuario> listaUsuario = usuDao.getUsuarios();

			// Atribuindo a lisa de usuarios em um atribudo com o nome de list.
			request.setAttribute("lista", listaUsuario);

			/**
			 * Criando um dispatcher, quando fizer uma request do tipo get com a
			 * acao lis retornará a lista de usuários, carregando um jsp
			 * listausuario.jsp que passa como atributo a lista, redirecionando
			 * com forward.
			 */
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listausuario.jsp");
			dispatcher.forward(request, response);

		} else if (request.getParameter("acao").equals("alt")) {
			UsuarioDAO usuDao = new UsuarioDAO();
			
			Usuario usuario = usuDao.findByID(Integer.parseInt(request.getParameter("id")));

			request.setAttribute("usuario", usuario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/formusuario.jsp");
			dispatcher.forward(request, response);

		} else if (request.getParameter("acao").equals("cad")) {
			UsuarioDAO usuDao = new UsuarioDAO();
			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setNome("");
			usuario.setLogin("");
			usuario.setSenha("");
			request.setAttribute("usuario", usuario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/formusuario.jsp");
			dispatcher.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Usuario usu = new Usuario();
		if (request.getParameter("id") != "")
			usu.setId(Integer.parseInt(request.getParameter("id")));
		usu.setNome(request.getParameter("nome"));
		usu.setLogin(request.getParameter("login"));
		usu.setSenha(request.getParameter("senha"));

		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.salvar(usu);

		response.getWriter().println("Salvo com sucesso.");
	}

}
