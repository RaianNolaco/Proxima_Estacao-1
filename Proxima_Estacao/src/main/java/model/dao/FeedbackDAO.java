package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.beans.Feedback;

public class FeedbackDAO {

	private Connection con = null;

	public boolean inserirFeedback(Feedback feed) {

		String sql = "INSERT into feedback (titulo, comentario, gostei, id_usuario, id_publicacao) values (?,?,?,?,?)";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, feed.getTitulo());
			stmt.setString(2, feed.getComentario());
			stmt.setString(3, String.valueOf(feed.getGostei()));
			stmt.setInt(4, feed.getId_usuario().getIdUsuario());
			stmt.setInt(5, feed.getId_publicacao().getId_publicacao());
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Erro ao inserir feedback!");
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

}
