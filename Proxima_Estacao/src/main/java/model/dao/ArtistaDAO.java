package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.beans.Artista;
import model.beans.Usuario;

public class ArtistaDAO {

	private Connection con = null;

	public ArtistaDAO() {
		con = ConnectionFactory.getConnection();
	}

	public boolean inserirArtista(Artista artista) {
		String sql = "INSERT INTO artista(descricao, id_usuario, rede_social) VALUES (?,?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, artista.getDescricao());
			stmt.setInt(2, artista.getId_usuario().getIdUsuario());
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

	public List<Artista> listarArtistas() {
		String sql = "SELECT * FROM artista";
		PreparedStatement stmt = null;

		ResultSet rs = null;
		List<Artista> artistas = new ArrayList<Artista>();

		try {

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Artista artista = new Artista();
				Usuario usuario = new Usuario();

				artista.setId_artista(rs.getInt("id_artista"));
				artista.setDescricao(rs.getString("descricao"));
				artista.setRede_social(rs.getString("rede_social"));
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				artista.setId_usuario(usuario);
				artistas.add(artista);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar os artistas!");
			return null;
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return artistas;

	}

	// Update artista
	public boolean elterarArtista(Artista artista) {

		String sql = "UPDADE artista SET descricao =?, rede_social = ? WHERE id_artista = ?";

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, artista.getDescricao());
			stmt.setString(2, artista.getRede_social());
			stmt.setInt(3, artista.getId_artista());
			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			System.err.println("Erro ao atualizar dados");
			return false;

		} finally {

			ConnectionFactory.closeConnection(con, stmt);

		}

	}
	
	
	//Excluir artista
	public boolean deletarArtista(Artista artista) {
			String sql = "DELETE FROM artista WHERE id_artista = ?";
			
			PreparedStatement stmt = null;
			
			try {
				
				stmt = con.prepareStatement(sql);
				
				stmt.setInt(1, artista.getId_artista());
				stmt.executeUpdate();
				
				return true;
				
			} catch (SQLException e) {
				
				System.err.println("Erro ao tentar excluir arista!");
				return false;
				
			}finally {
				ConnectionFactory.closeConnection(con,stmt);
			}
			
	}

}
