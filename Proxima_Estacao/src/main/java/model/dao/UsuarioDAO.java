package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Status;
import model.beans.Usuario;
import connection.ConnectionFactory;

public class UsuarioDAO {
	private Connection con = null;

	public UsuarioDAO() {
		con = ConnectionFactory.getConnection();
	}

	// metodo responsável por dar insert no usuario
	public boolean inserirUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario (nome, sobrenome, apelido, email, senha, numero, id_status, data_nascimento, cpf)"
				+ "VALUES (?,?,?,?,?,?,?,?,?)";

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
			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao inserir o usuario" + e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	// metodo responsável por retornar todos os usuarios do banco de dados
	public List<Usuario> listarUsuarios() {

		String sql = "SELECT * FROM usuario";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Usuario usuario = new Usuario();
				Status status = new Status();
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome"));
				usuario.setSobrenomeUsuario(rs.getString("sobrenome"));
				usuario.setApelido(rs.getString("apelido"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNumero(rs.getString("numero"));
				status.setId_status(rs.getInt("id_status"));
				usuario.setData_nascimento(rs.getDate("data_nascimento"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setIdStatus(status);
				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar todos os usuarios" + e);
			return null;
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return usuarios;
	}
	
	//Método responsável por atualizar o ususario
	public boolean alterarUsuario(Usuario usuario) {
		
		String sql = "UPDATE usuario SET nome = ?, sobrenome = ?, apelido = ?, email = ?, senha = ?, numero = ?, id_status = ?, data_nascimento = ?, cpf = ?"
				+ "WHERE id_usuario = ?";

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
			stmt.setInt(10, usuario.getIdUsuario());
			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao inserir o usuario" + e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	//Método responsável por deletar o usuario
	public boolean deletarUsuario(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE id_usuario = ? ";
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getIdUsuario());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
		}finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
	}
}
