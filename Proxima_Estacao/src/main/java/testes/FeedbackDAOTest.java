package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.beans.Feedback;
import model.beans.Publicacao;
import model.beans.Usuario;
import model.dao.FeedbackDAO;

class FeedbackDAOTest {

	@Test
	public void inserirFeedback() {
		FeedbackDAO dao = new FeedbackDAO();
		Usuario usuario = new Usuario();
		Publicacao publi = new Publicacao();
		
		usuario.setIdUsuario(4);
		publi.setId_publicacao(1);
		
		
		Feedback feed = new Feedback
				("Que publicacao legal", "Gostei muito de ver esta publicacao cara haha", 'S', usuario, publi);
		
		if(dao.inserirFeedback(feed)) {
			System.out.println("Feedback inserido com sucesso!");
		}else {
			fail("Erro ao inserir o feedback!");
		}
		
	}

}
