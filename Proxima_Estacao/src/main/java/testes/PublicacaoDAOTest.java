package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.beans.Artista;
import model.beans.Publicacao;
import model.dao.PublicacaoDAO;

class PublicacaoDAOTest {
	PublicacaoDAO dao = new PublicacaoDAO();
	
	/*@Test
	public void inserirPublicacao() {
		
	
		Artista artista = new Artista();
		artista.setId_artista(1);
		
		Publicacao pub = new Publicacao
				("404NotFound", "404NotFound", false, "Essa foi uma publicacao para meus fãs #Culturo", 3,artista);

		if(dao.inserirPublicacao(pub)) {
			System.out.println("Publicacao inserida com sucesso!");
		}else {
			fail("Erro ao inserir ao publicação");
		}
	}*/
	
	@Test
	public void listarPublicacoes() {
		
		Publicacao pub = new Publicacao();
		
		for (Publicacao pub2 : dao.listarPublicacao()) {
			System.out.println(
			  "\nFoto: " + pub2.getId_artista().getId_usuario().getFotoPerfil()
            + "\nApelido: "+ pub2.getId_artista().getId_usuario().getApelido()
            + "\nConteudo: " + pub2.getConteudo()
            + "\nDescricao: " + pub2.getDescricao());	
		}
	
	
	}
	

	
	
	

}
