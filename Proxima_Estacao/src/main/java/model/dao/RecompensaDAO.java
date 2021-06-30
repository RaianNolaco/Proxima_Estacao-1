package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.beans.Recompensa;

public class RecompensaDAO {
	
	private Connection con = null;

	public RecompensaDAO() {
		con = ConnectionFactory.getConnection();
	}

	
	public List<Recompensa> listaRecompensa(){
		
		String sql = "SELECT * FROM recompensa";
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		List<Recompensa> recompensas = new ArrayList<Recompensa>();
		
		try{
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				Recompensa recompensa = new Recompensa();
				
				recompensa.setId_recompensa(rs.getInt("id_recompensa"));
				recompensa.setNome(rs.getString("nome"));
				recompensa.setDescricao(rs.getString("descricao"));
				recompensa.setEmblema(rs.getString("emblema"));
				
			}
			
			
		} catch (SQLException e) {
			
			System.err.println("Erro ao listar as recompensas ");			
			return null;
			
		} finally {
			
			ConnectionFactory.closeConnection(null, stmt, rs);
			
		}
		
		return recompensas;
		
	}	

}
