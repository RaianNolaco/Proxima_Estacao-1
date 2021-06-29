package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.beans.Artista;
import model.beans.Publicacao;
import model.dao.PublicacaoDAO;

class PublicacaoDAOTest {

	@Test
	public void inserirPublicacao() {
		
		PublicacaoDAO dao = new PublicacaoDAO();
		Artista artista = new Artista();
		artista.setId_artista(1);
		
		Publicacao pub = new Publicacao
				("PublicacaoZika", "404NotFound", "404NotFound", 'N', "Essa foi uma publicacao para meus fãs #Culturo", 3,artista);
		
		if(dao.inserirPublicacao(pub)) {
			System.out.println("Publicacao inserida com sucesso!");
		}else {
			fail("Erro ao inserir ao publicação");
		}
		
		
		
	}

}
