package com.javaweb.maven;

import com.javaweb.maven.persistencia.entidade.Usuario;
import com.javaweb.maven.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		testeExcluir();
	}

	public static void testeAlterar() {
		// Criando o usuário.
		Usuario usu = new Usuario();
		usu.setId(3);
		usu.setNome("Nome teste Alteracao");
		usu.setLogin("Login teste Alteracao");
		usu.setSenha("Senha teste Alteracao");

		// Cadastrando usuário no banco de dados.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("Usuario cadastrado com sucesso!");
	}

	public static void testeCadastrar() {
		// Criando o usuário.
		Usuario usu = new Usuario();
		usu.setNome("Nome teste");
		usu.setLogin("Login teste");
		usu.setSenha("Senha teste");

		// Cadastrando usuário no banco de dados.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("Usuario alterado com sucesso!");
	}
	
	public static void testeExcluir() {
		// Criando o usuário.
		Usuario usu = new Usuario();
		usu.setId(3);

		// Cadastrando usuário no banco de dados.
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("Usuario excluido com sucesso!");
	}
}
