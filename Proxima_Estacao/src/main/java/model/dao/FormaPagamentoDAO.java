package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionFactory;
import model.beans.Forma_pagamento;

public class FormaPagamentoDAO {
	
	private Connection con = null;
	
	public FormaPagamentoDAO() {
		con = ConnectionFactory.getConnection();
	}
	
	
	public List<Forma_pagamento> listarFormas(){
		String sql = "SELECT * FROM forma_pagamento";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Forma_pagamento> formas = new ArrayList<Forma_pagamento>();
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Forma_pagamento forma = new Forma_pagamento();
				forma.setId_forma_pag(rs.getInt("id_forma_Pag"));
				forma.setNome(rs.getString("nome"));
				formas.add(forma);
			}
	
		} catch (SQLException e) {
			System.err.println("Erro ao listar as formas de pagamento!" + e);
			return null;
		} finally {
			ConnectionFactory.closeConnection(con, stmt,rs);
		}
		
		return formas;
	}
	
	
	

}
