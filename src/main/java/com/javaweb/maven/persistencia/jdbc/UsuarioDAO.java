package com.javaweb.maven.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
