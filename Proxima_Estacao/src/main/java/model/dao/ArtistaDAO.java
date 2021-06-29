package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.beans.Artista;

public class ArtistaDAO {
	

	private Connection con = null;
	
	public boolean inserirArtista(Artista artista) {
		String sql ="INSERT INTO artista(descricao, id_usuario, rede_social) VALUES (?,?,?)";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, artista.getDescricao());
			stmt.setInt	  (2, artista.getId_usuario().getIdUsuario());
			stmt.setString(3, artista.getRede_social());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao inserir o artista!");
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	
	
}
