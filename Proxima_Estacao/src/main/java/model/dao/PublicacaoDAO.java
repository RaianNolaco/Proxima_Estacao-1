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
import model.beans.Usuario;

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
			stmt.setBoolean(3, pub.getConteudo_NSFW());
			stmt.setString(4, pub.getDescricao());
			stmt.setInt(5, pub.getViews());
			stmt.setInt(6, pub.getId_artista().getId_usuario().getIdUsuario());
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
		String sql = "SELECT vw.foto_perfil, vw.apelido, vw.conteudo, vw.descricao FROM vw_post_user AS vw";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Publicacao> publicacoes = new ArrayList<Publicacao>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Publicacao pub = new Publicacao();
				Artista art = new Artista();
				Usuario usuario = new Usuario();
				
				usuario.setFotoPerfil(rs.getString(1));
				usuario.setApelido(rs.getString(2));
				art.setId_usuario(usuario);
				pub.setId_artista(art);
				pub.setConteudo(rs.getString(3));
				pub.setDescricao(rs.getString(4));
				publicacoes.add(pub);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar as publicações!" + e);
			return null;
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return publicacoes;
	}
	
	public List<Publicacao> listarPublicacaoSeguidor(Usuario usuario) {
		
		String sql = "SELECT DISTINCT vw_post_user.foto_perfil, vw_post_user.apelido, vw_post_user.conteudo, vw_post_user.descricao FROM seguidores"
				+ " JOIN   publicacao "  
				+ " JOIN   vw_post_user "
				+ " ON    seguidores.id_artista   = vw_post_user.id_artista" 
				+ " AND    publicacao.id_artista  = seguidores.id_artista"
				+ " WHERE  seguidores.id_usuario  =" + usuario.getIdUsuario();

		PreparedStatement stmt = null;
		ResultSet           rs = null;
		List<Publicacao> publicacoes = new ArrayList<Publicacao>();
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Publicacao pub = new Publicacao();
				Artista art = new Artista();
				usuario = new Usuario();
				
				usuario.setFotoPerfil(rs.getString(1));
				usuario.setApelido(rs.getString(2));
				art.setId_usuario(usuario);
				pub.setId_artista(art);
				pub.setConteudo(rs.getString(3));
				pub.setDescricao(rs.getString(4));
				publicacoes.add(pub);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar as publicações!" + e);
			return null;
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return publicacoes;
	
	}
	
	// update publicação
	public boolean alterarPublicacao(Publicacao publicacao) {
		String sql = "UPDATE publicacao SET thumb = ?,descricao = ? WHERE id_publicacao = ?";

		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(sql);

			stmt.setString(1, publicacao.getThumb());
			stmt.setString(2, publicacao.getDescricao());
			stmt.setInt(3, publicacao.getId_publicacao());
			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao tentar atualizar dados!");
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public boolean deletarPublicacao(Publicacao publicacao) {
		String sql = "DELETE FROM publicacao WHERE id_publicacao = ?";

		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(sql);

			stmt.setInt(1, publicacao.getId_publicacao());
			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao tentar excluir publicação");
			return false;
		} finally {

			ConnectionFactory.closeConnection(con, stmt);

		}

	}

}
