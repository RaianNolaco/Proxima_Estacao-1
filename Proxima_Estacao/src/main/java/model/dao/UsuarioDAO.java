package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.beans.Usuario;
import connection.ConnectionFactory;

public class UsuarioDAO {
		
	
	private Connection con = null;
	
	
	public boolean inserirUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario (id_usuario , nome, sobrenome, apelido, email, senha, numero, id_status, data_nascimento, cpf)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt   (1,  usuario.getIdUsuario());
			stmt.setString(2,  usuario.getNomeUsuario());
			stmt.setString(3,  usuario.getSobrenomeUsuario());
			stmt.setString(4,  usuario.getApelido());
			stmt.setString(5,  usuario.getEmail());
			stmt.setString(6,  usuario.getSenha());
			stmt.setString(7,  usuario.getNumero());
			stmt.setInt   (8,  usuario.getIdStatus().getId_status());
			stmt.setDate  (9,  usuario.getData_nascimento());
			stmt.setString(10, usuario.getCpf());
			stmt.executeUpdate();
            return true;
			
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
	    }
		
		System.out.println("Teste da porra menor kk");
	
}
