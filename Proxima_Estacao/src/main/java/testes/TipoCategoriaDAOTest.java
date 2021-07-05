package testes;

import org.junit.jupiter.api.Test;

import model.beans.Tipo_Categoria;
import model.dao.TipoCategoriaDAO;

class TipoCategoriaDAOTest {
	TipoCategoriaDAO dao = new TipoCategoriaDAO();

	@Test
	public void listarTipoCategoria() {

		for (Tipo_Categoria tipo : dao.listarTipos()) {
			System.out.println("\nId: " + tipo.getId_tipo_categoria() + "\nNome: " + tipo.getNome_categoria());
		}
	}
}
