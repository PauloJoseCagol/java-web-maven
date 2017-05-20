package com.javaweb.maven.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.maven.persistencia.entidade.Usuario;

public class UsuarioDAO {

	Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usu) {
		// TODO Auto-generated method stub
		String sql = "insert into usuario (nome, login,senha) values (?,?,?)";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, usu.getNome());
			stmt.setString(2, usu.getLogin());
			stmt.setString(3, usu.getSenha());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void alterar(Usuario usu) {
		// TODO Auto-generated method stub
		String sql = "update usuario set nome=?, login=?, senha=? where id =?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, usu.getNome());
			stmt.setString(2, usu.getLogin());
			stmt.setString(3, usu.getSenha());
			stmt.setInt(4, usu.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void excluir(Usuario usu) {
		// TODO Auto-generated method stub
		String sql = "delete from usuario where id =?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, usu.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void salvar(Usuario usuario) {

		if (usuario.getId() != null) {
			alterar(usuario);
			System.out.println("Usuario alterado!");
		} else {
			cadastrar(usuario);
			System.out.println("Usuario cadastrado!");
		}
	}

	// Documentando o método.
	/**
	 * Busca de um registro no banco de dados pelo ID do usuario.
	 * 
	 * @param id
	 *            é um inteiro que representa o numero do ID do usuario.
	 * @return null quando não encontra o ID do usuario, ou retora o objeto do
	 *         usuario quando encontra o id.
	 */
	public Usuario findByID(int id) {

		Usuario resultUsu = null;

		String sql = "select * from usuario where id = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				resultUsu = new Usuario();
				resultUsu.setId(rs.getInt("id"));
				resultUsu.setNome(rs.getString("nome"));
				resultUsu.setLogin(rs.getString("login"));
				resultUsu.setSenha(rs.getString("senha"));
			}
			return resultUsu;

		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getUsuarios() {

		Usuario resultUsu = null;
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "select * from usuario ";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				resultUsu = new Usuario();
				resultUsu.setId(rs.getInt("id"));
				resultUsu.setNome(rs.getString("nome"));
				resultUsu.setLogin(rs.getString("login"));
				resultUsu.setSenha(rs.getString("senha"));
				lista.add(resultUsu);
			}
			return lista;

		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}
