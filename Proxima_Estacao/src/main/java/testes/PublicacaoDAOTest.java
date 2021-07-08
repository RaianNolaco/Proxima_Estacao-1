package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.beans.Artista;
import model.beans.Publicacao;
import model.beans.Usuario;
import model.dao.PublicacaoDAO;

class PublicacaoDAOTest {
	PublicacaoDAO dao = new PublicacaoDAO();
	Usuario usuario = new Usuario();
	
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
	public void listarPublicacaoSeguidor() {
		
		Publicacao pub = new Publicacao();
		usuario.setIdUsuario(2);

		ArrayList<Publicacao> pubs = new ArrayList<Publicacao>();
	
		for (Publicacao pub2 : dao.listarPublicacaoSeguidor(usuario)) {
			pubs.add(pub2);
		}
		
		
		for(int i = 0; i < pubs.size(); i++)
		{
			System.out.println(pubs.get(i).getDescricao());
			
			pubs.
		}

	}
	
	

}
