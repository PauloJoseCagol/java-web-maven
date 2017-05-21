package com.javaweb.maven;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.maven.persistencia.entidade.Usuario;
import com.javaweb.maven.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		// testeSalvar();
		// testeFindById();
		//testeGetUsuarios();
		testeAutenticar();
	}

	private static void testeAutenticar() {
		// TODO Auto-generated method stub
		UsuarioDAO usuDao = new UsuarioDAO();
		
		Usuario usu = new Usuario();
		usu.setLogin("Login teste");
		usu.setSenha("Senha teste");
		
		System.out.println(usuDao.autenticar(usu));
		
	}

	private static void testeGetUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> list = new ArrayList<Usuario>();
		UsuarioDAO usuDao = new UsuarioDAO();
		list = usuDao.getUsuarios();
		for (Usuario usuario : list) {
			System.out.println(usuario.getNome() + "\n" + usuario.getLogin() + "\n" + usuario.getSenha() + "\n\n");
		}
	}

	private static void testeFindById() {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		usuario.setId(1);
		UsuarioDAO usuDao = new UsuarioDAO();
		usuario = usuDao.findByID(usuario.getId());
		System.out.println(usuario.getNome() + "\n" + usuario.getLogin() + "\n" + usuario.getSenha());
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

	public static void testeSalvar() {

		Usuario usuario = new Usuario();
		// usuario.setId(1);
		usuario.setNome("Robertal");
		usuario.setLogin("Login Roberval");
		usuario.setSenha("Senha Roberval");

		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.salvar(usuario);

	}
}
