package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.beans.Feedback;
import model.beans.Publicacao;
import model.beans.Usuario;

public class FeedbackDAO {

	private Connection con = null;

	public FeedbackDAO() {
		con = ConnectionFactory.getConnection();
	}

	public boolean inserirFeedback(Feedback feed) {

		String sql = "INSERT into feedback (titulo,comentario, gostei, id_usuario, id_publicacao) values (?,?,?,?,?)";

		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, feed.getTitulo());
			stmt.setString(2, feed.getComentario());
			stmt.setBoolean(3, feed.getGostei());
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

	public List<Feedback> listarFeedbacks() {
		String sql = "SELECT * FROM feedback";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Feedback> feeds = new ArrayList<Feedback>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Feedback feed = new Feedback();
				Usuario u = new Usuario();
				Publicacao pub = new Publicacao();
				
				feed.setTitulo(rs.getString("titulo"));
				feed.setComentario(rs.getString("comentario"));
				feed.setGostei(rs.getBoolean("gostei"));
				u.setIdUsuario(rs.getInt("id_usuario"));
				pub.setId_publicacao(rs.getInt("id_publicacao"));
				feed.setId_usuario(u);
				feed.setId_publicacao(pub);
				feeds.add(feed);

			}
		} catch (SQLException e) {
			System.err.print("Erro ao listar todos os feedbacks!");
			return null;
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return feeds;
	}

	public boolean alterarFeedback(Feedback feed) {
		String sql = "UPDATE feedback SET titulo = ?, comentario = ?, gostei = ? WHERE id_feedback";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, feed.getTitulo());
			stmt.setString(2, feed.getComentario());
			stmt.setBoolean(3, feed.getGostei());
			stmt.setInt	  (4, feed.getId_feedback());
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			System.err.println("Erro ao atualizar dado");
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public boolean deleteFeedback(Feedback feed) {

		String sql = "DELETE FROM feedback WHERE id_feedback";

		PreparedStatement stmt = null;

		try {
			
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1,feed.getId_feedback());
			stmt.executeUpdate();
			
			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao tentar excluir seu feedback");
			return false;
		} finally {

			ConnectionFactory.closeConnection(con,stmt);
			
		}

	}

}
