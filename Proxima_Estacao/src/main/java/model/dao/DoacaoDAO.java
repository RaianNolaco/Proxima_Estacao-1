	package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import connection.ConnectionFactory;
import model.beans.Artista;
import model.beans.Doacao;
import model.beans.Forma_pagamento;
import model.beans.Usuario;

public class DoacaoDAO {


	private Connection con = null;

	public DoacaoDAO(){
		con = ConnectionFactory.getConnection();
	}
	
	
	public boolean inserirDoacao(Doacao doacao){
		
		String sql = "INSERT INTO doacao (valor,id_artista,id_usuario,id_forma_pag) VALUES (?,?,?,?)";
		
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
	
	public List<Doacao> listarDoacao(){
		
		String sql = "SELECT * FROM doacao";
	    PreparedStatement stmt = null;
	    
	    ResultSet rs = null;
	    List<Doacao> doacoes = new ArrayList<Doacao>();
	    
	    try{
	    	
	    	stmt = con.prepareStatement(sql);
	    	rs = stmt.executeQuery(sql);
	    	
	    	while(rs.next()){
	    		
	    		Doacao  doacao  = new Doacao();
	    		Artista artista = new Artista();
	    		Usuario usuario = new Usuario();
	    		Forma_pagamento forma_pag = new Forma_pagamento();
	    		
	    		doacao.setId_doacao(rs.getInt("id_doacao"));
	    		doacao.setQuantidade(rs.getFloat("valor"));
	    		artista.setId_artista(rs.getInt("id_artista"));
	    		doacao.setId_artista(artista);
	    		usuario.setIdUsuario(rs.getInt("id_usuario"));
	    		doacao.setId_usuario(usuario);
	    		forma_pag.setId_forma_pag(rs.getInt("id_forma_pag"));
	    		doacao.setId_forma_pag(forma_pag);
	    		doacoes.add(doacao);
	    		
	    	}
	    	
	    }catch(SQLException e){
	    	
	    	System.err.println("Erro ao listar as doacoes");
	    	return null;
	    	
	    }finally{
	    	
	    	ConnectionFactory.closeConnection(con, stmt, rs);
	    	
	    }
	    
	    return doacoes;
	}

}
