package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.beans.Grupo;

public class GrupoDAO {

	private Connection con = null;
	
	public boolean inserirGrupo(Grupo grupo){
		
		String sql = "INSERT INTO grupo(nome_grupo,tag_grupo,descricao_grupo) VALUES (?,?,?)";
		
		con  = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,grupo.getNome_grupo());
			stmt.setString(2,grupo.getTag_grupo());
			stmt.setString(3,grupo.getDescricao_grupo());
		    stmt.execute();
			return true;	
		}catch(SQLException e){
			
			System.out.println("Erro ao criar o grupo");
			
			return false;
			
		}finally{
			
			
				ConnectionFactory.closeConnection(con, stmt);
			
		}
		
		
	} 
	
}
