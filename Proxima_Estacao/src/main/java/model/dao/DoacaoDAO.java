package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connection.ConnectionFactory;
import model.beans.Doacao;

public class DoacaoDAO {

	private Connection con = null;

	public boolean inserirDoacao(Doacao doacao){
		
		String sql = "INSERT INTO doacao (quantidade,id_artista,id_usuario,id_form_pag) VALUES (?,?,?,?)";
		
		con =  ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null; 
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setFloat(1,doacao.getQuantidade());
			stmt.setInt(2,  doacao.getId_artista().getId_artista());
			stmt.setInt(3,  doacao.getId_usuario().getIdUsuario());
			stmt.setInt(4,  doacao.getId_forma_pag().getId_forma_pag());
			stmt.execute();
			
			return true;
			
			
		}catch(SQLException e){
			
			System.out.println("Erro ao efetuar a doação");
			
			return false;
			
		}finally{

			ConnectionFactory.closeConnection(con, stmt);
		}
	
	}

}
