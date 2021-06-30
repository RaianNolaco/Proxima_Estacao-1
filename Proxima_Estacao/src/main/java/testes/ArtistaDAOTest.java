package testes;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import model.beans.Artista;
import model.beans.Usuario;
import model.dao.ArtistaDAO;

class ArtistaDAOTest {
	ArtistaDAO dao = new ArtistaDAO();

	
	  @Test
	  public void inserirArtista() {
	 
	 
	  Usuario usuario = new Usuario(); usuario.setIdUsuario(4);
	  Artista artista = new Artista("O melhor tocador de Ocarina do Brasil",
	  usuario ,"Facebook: ArtistaEmpadão");
	  
	  if(dao.inserirArtista(artista)) {
	 System.out.println("Artista salvo com sucesso!"); }else { fail("Erro"); }
	  }
	 
	@Test
	public void listraTodosArtistas() {

		for (Artista artista : dao.listarArtistas()) {
			System.out.println("\nID Artista :  " + artista.getId_artista() + "\nDescrição  :  "
					+ artista.getDescricao() + "\nID Usuario :  " + artista.getId_usuario().getIdUsuario()
					+ "\nRede social:  " + artista.getRede_social());
		}
	}
}
