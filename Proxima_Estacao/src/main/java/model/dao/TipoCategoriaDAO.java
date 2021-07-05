package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.beans.Tipo_Categoria;

public class TipoCategoriaDAO {

	private Connection con = null;

	public TipoCategoriaDAO() {
		con = ConnectionFactory.getConnection();
	}

	public List<Tipo_Categoria> listarTipos() {

		String sql = "SELECT * FROM tipo_categoria";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Tipo_Categoria> tipos = new ArrayList<Tipo_Categoria>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Tipo_Categoria tipo = new Tipo_Categoria();
				tipo.setId_tipo_categoria(rs.getInt("id_tipo_categoria"));
				tipo.setNome_categoria(rs.getString("nome_tipo"));
				tipos.add(tipo);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar todos os tipos de categoria!");
			return null;
		} finally {
			ConnectionFactory.closeConnection(con, stmt,rs);
		}
		
		return tipos;

	}

}
