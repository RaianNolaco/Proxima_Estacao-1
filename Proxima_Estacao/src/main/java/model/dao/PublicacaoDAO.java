package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.beans.Artista;
import model.beans.Publicacao;

public class PublicacaoDAO {
	private Connection con = null;

	public PublicacaoDAO() {
		con = ConnectionFactory.getConnection();
	}

	// metodo responsável por inserir uma publicação
	public boolean inserirPublicacao(Publicacao pub) {
		String sql = "INSERT INTO publicacao ( thumb, conteudo, conteudo_sensi, descricao, visualizacao, id_artista)"
				+ "VALUES (?,?,?,?,?,?,?)";

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, pub.getThumb());
			stmt.setString(2, pub.getConteudo());
			stmt.setString(3, String.valueOf(pub.getConteudo_NSFW()));
			stmt.setString(4, pub.getDescricao());
			stmt.setInt(5, pub.getViews());
			stmt.setInt(6, pub.getId_artista().getId_artista());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " + e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Publicacao> listarPublicacao() {
		String sql = "SELECT * FROM publicacao";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Publicacao> publicacoes = new ArrayList<Publicacao>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Publicacao pub = new Publicacao();
				Artista art = new Artista();

				pub.setId_publicacao(rs.getInt("id_publicacao"));
				pub.setThumb(rs.getString("thumb"));
				pub.setConteudo(rs.getString("conteudo"));
				pub.setConteudo_NSFW(rs.getString("conteudo_sensi").charAt(0));
				pub.setDescricao(rs.getString("descricao"));
				pub.setViews(rs.getInt("visualizacao"));
				art.setId_artista(rs.getInt("id_artista"));
				pub.setId_artista(art);
				publicacoes.add(pub);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar as publicações!");
			return null;
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return publicacoes;
	}

	//update publicação
	public boolean alterarPublicacao(Publicacao publicacao) {
			String sql  = "UPDATE publicacao SET thumb = ?,descricao = ? WHERE id_publicacao = ?";
		
			PreparedStatement stmt =  null;
			
		try {
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,publicacao.getThumb());
			stmt.setString(2,publicacao.getDescricao());
			stmt.setInt(3,publicacao.getId_publicacao());
			stmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.err.println("Erro ao tentar atualizar dados!");
			return false;
		} finally {
			ConnectionFactory.closeConnection(con,stmt);
		}

	}
	
	
	public boolean deletarPublicacao(Publicacao publicacao){
		String sql = "DELETE FROM publicacao WHERE id_publicacao = ?";
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1,publicacao.getId_publicacao());
			stmt.executeUpdate();
			
			return true;
					
		} catch (SQLException e) {
			System.err.println("Erro ao tentar excluir publicação");
			return false;
		} finally {
			
			ConnectionFactory.closeConnection(con,stmt);
			
		}
		
	}

}
