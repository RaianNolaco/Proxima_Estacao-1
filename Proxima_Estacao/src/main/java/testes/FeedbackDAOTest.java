package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.beans.Feedback;
import model.beans.Publicacao;
import model.beans.Usuario;
import model.dao.FeedbackDAO;

class FeedbackDAOTest {
	FeedbackDAO dao = new FeedbackDAO();
	
	@Test
	public void inserirFeedback() {
		
		Usuario usuario = new Usuario();
		Publicacao publi = new Publicacao();
		
		usuario.setIdUsuario(4);
		publi.setId_publicacao(1);
		
		
		Feedback feed = new Feedback
				("hihi","Gostei muito de ver esta publicacao cara haha", true, usuario, publi);
		
		if(dao.inserirFeedback(feed)) {
			System.out.println("Feedback inserido com sucesso!");
		}else {
			fail("Erro ao inserir o feedback!");
		}
		
	}
	
	
	@Test
	public void listarFeeds() {
		
		for(Feedback feed: dao.listarFeedbacks()) {
			System.out.println("\nTitulo: " + feed.getTitulo()
							 + "\nComentario: " + feed.getComentario()
							 + "\nGostei: " + feed.getGostei()
							 + "\nUsuario: " + feed.getId_usuario().getIdUsuario()
							 + "\nPublicação: " + feed.getId_publicacao().getId_publicacao()
			                  );
		}
		
	}

}
