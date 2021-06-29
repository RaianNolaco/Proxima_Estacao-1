package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.beans.Publicacao;
import model.beans.Usuario;

public class PublicacaoDAO {
	private Connection con = null;

	// metodo responsável
	public boolean inserirPublicacao(Publicacao pub) {
		String sql = "INSERT INTO publicacao (titulo, thumb, conteudo, conteudo_sensi, descricao, visualizacao, id_artista)"
				+ "VALUES (?,?,?,?,?,?,?)";

		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, pub.getTitulo());
			stmt.setString(2, pub.getThumb());
			stmt.setString(3, pub.getConteudo());
			stmt.setString(4, String.valueOf(pub.getConteudo_NSFW()));
			stmt.setString(5, pub.getDescricao());
			stmt.setInt(6, pub.getViews());
			stmt.setInt(7, pub.getId_artista().getId_artista());
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println("Erro: " + e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
