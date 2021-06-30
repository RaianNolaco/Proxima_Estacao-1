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
		
		

		String sql = "INSERT into feedback (titulo, comentario, gostei, id_usuario, id_publicacao) values (?,?,?,?,?)";
		
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
	
	public List<Feedback> listarFeedbacks(){
		String sql = "SELECT * FROM feedback";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Feedback> feeds = new ArrayList<Feedback>();
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Feedback feed  = new Feedback();
				Usuario 	u  = new Usuario();
				Publicacao pub = new Publicacao();
				
				feed.setTitulo(rs.getString("titulo"));
				feed.setComentario(rs.getString("comentario"));
				feed.setGostei(rs.getString("gostei").charAt(0));
				u.setIdUsuario(rs.getInt("id_usuario"));
				pub.setId_publicacao(rs.getInt("id_publicacao"));
				feed.setId_usuario(u);
				feed.setId_publicacao(pub);
				feeds.add(feed);

			}
		}catch(SQLException e) {
			System.err.print("Erro ao listar todos os feedbacks!");
			return null;
		}finally {
			ConnectionFactory.closeConnection(con, stmt,rs);
		}
		
		return feeds;
	}

}
