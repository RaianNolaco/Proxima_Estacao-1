package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.beans.Grupo;

public class GrupoDAO {

	private Connection con = null;

	public GrupoDAO() {
		con = ConnectionFactory.getConnection();
	}

	public boolean inserirGrupo(Grupo grupo) {

		String sql = "INSERT INTO grupo(nome_grupo,tag_grupo,descricao_grupo) VALUES (?,?,?)";

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, grupo.getNome_grupo());
			stmt.setString(2, grupo.getTag_grupo());
			stmt.setString(3, grupo.getDescricao_grupo());
			stmt.execute();
			return true;

		} catch (SQLException e) {

			System.out.println("Erro ao criar o grupo");

			return false;

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public List<Grupo> listarGrupos() {
		String sql = "SELECT * FROM grupo";
		PreparedStatement stmt = null;

		ResultSet rs = null;
		List<Grupo> grupos = new ArrayList<Grupo>();

		try {

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Grupo grupo = new Grupo();

				grupo.setId_grupo(rs.getInt("id_grupo"));
				grupo.setNome_grupo(rs.getString("nome_grupo"));
				grupo.setTag_grupo(rs.getString("tag_grupo"));
				grupo.setDescricao_grupo(rs.getString("descricao_grupo"));
				;
				grupos.add(grupo);

			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar os grupos!");
			return null;
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return grupos;
	}

	public boolean alterarGrupo(Grupo grupo) {
		String slq = "UPDATE grupo SET nome_grupo = ?, tag_grupo = ?, descricao_grupo WHERE id_grupo";

		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(slq);

			stmt.setString(1, grupo.getNome_grupo());
			stmt.setString(2, grupo.getTag_grupo());
			stmt.setString(3, grupo.getDescricao_grupo());
			stmt.setInt(4, grupo.getId_grupo());
			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			System.err.println("Erro ao atualizar grupo!");
			return false;

		} finally {

			ConnectionFactory.closeConnection(con, stmt);

		}

	}

	public boolean deletarGrupo(Grupo grupo) {
		String slq  = "DELETE FROM grupo WHERE id_grupo = ?";
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement(slq);
			
			stmt.setInt(1,grupo.getId_grupo());
			stmt.executeUpdate();
			
			return true;

		} catch (SQLException e) {

			System.err.println("Erro ao tentar excluir grupo!");
			return false;
			
		} finally {

			ConnectionFactory.closeConnection(con, stmt);

		}

	}

}
