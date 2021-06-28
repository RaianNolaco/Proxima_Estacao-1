package testes;

import org.junit.jupiter.api.Test;
import model.beans.Artista;
import model.beans.Usuario;
import model.dao.ArtistaDAO;

class ArtistaDAOTest {
	@Test
	public void inserirArtista() {
		ArtistaDAO     dao = new ArtistaDAO();
		   
		   Usuario usuario = new    Usuario();
		   usuario.setIdUsuario(4);
		   
		   Artista artista = new   Artista("O melhor tocador de Ocarina do Brasil", usuario ,"Facebook: ArtistaEmpadão");
		   
		   
		   if(dao.inserirArtista(artista)) {
			   System.out.println("Artista salvo com sucesso!");
		   }else {
			   System.out.println("Erro");
		   }
		
		   

	}
}
