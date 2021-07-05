package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.beans.Categoria;
import model.beans.Tipo_Categoria;

public class CategoriaDAO {
	
	
	private Connection con = null;
	
	public CategoriaDAO() {
		
		con = ConnectionFactory.getConnection(); 
	}

	public List<Categoria> listarCategoria(){
		
		String sql = "SELECT * FROM categoria";
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		List<Categoria> categorias = new  ArrayList<Categoria>();
		
		
		try {
		
			 stmt = con.prepareStatement(sql);
			 rs = stmt.executeQuery(sql);
			 
			 while(rs.next()){
				 
				 Categoria categoria          = new Categoria();
				 Tipo_Categoria TipoCategoria = new Tipo_Categoria();
				 
				 categoria.setId_categoria(rs.getInt("id_categoria"));
				 categoria.setNome_categoria(rs.getString("nome_categoria"));
				 TipoCategoria.setId_tipo_categoria(rs.getInt("id_tipo_categoria"));
				 categoria.setId_tipo_categoria(TipoCategoria);
				 categorias.add(categoria);
			 }
			
		} catch(SQLException e) {
		
			System.err.println("Erro ao listar as gategorias");
			return null;
		
		}finally{
			
			ConnectionFactory.closeConnection(con, stmt, rs);
			
		}
		
		
		return categorias;
				
		
	}
	
}
