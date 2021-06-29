package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.beans.Usuario;
import connection.ConnectionFactory;

public class UsuarioDAO {
	private Connection con = null;

	// metodo responsável
	public boolean inserirUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario (nome, sobrenome, apelido, email, senha, numero, id_status, data_nascimento, cpf)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";

		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getSobrenomeUsuario());
			stmt.setString(3, usuario.getApelido());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getSenha());
			stmt.setString(6, usuario.getNumero());
			stmt.setInt(7, usuario.getIdStatus().getId_status());
			stmt.setDate(8, new java.sql.Date(usuario.getData_nascimento().getTime()));
			stmt.setString(9, usuario.getCpf());
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println("Erro: " + e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
