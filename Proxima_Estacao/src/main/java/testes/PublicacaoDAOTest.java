package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.beans.Artista;
import model.beans.Publicacao;
import model.dao.PublicacaoDAO;

class PublicacaoDAOTest {
	PublicacaoDAO dao = new PublicacaoDAO();
	
	@Test
	public void inserirPublicacao() {
		
	
		Artista artista = new Artista();
		artista.setId_artista(1);
		
		Publicacao pub = new Publicacao("404NotFound", "404NotFound", 'N', "Essa foi uma publicacao para meus fãs #Culturo", 3,artista);
		
		if(dao.inserirPublicacao(pub)) {
			System.out.println("Publicacao inserida com sucesso!");
		}else {
			fail("Erro ao inserir ao publicação");
		}
	}
	
	@Test
	public void listarPublicacoes() {
		
		for (Publicacao pub : dao.listarPublicacao()) {
			System.out.println("\nId: " + pub.getId_publicacao()
			+ "\nThumb: " + pub.getThumb()
            + "\nConteudo: "+ pub.getConteudo()
            + "\nNSFW: " + pub.getConteudo_NSFW()
            + "\nDescricao: " + pub.getDescricao()
            + "\nViews: " + pub.getViews()
            + "\nArtista: " + pub.getId_artista().getId_artista());
		}
		
		
	}

}
