package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.beans.Grupo;
import model.dao.GrupoDAO;

class GrupoDAOTest {

	@Test
	public void inserirGrupo() {

		GrupoDAO dao = new GrupoDAO();

		Grupo grupo = new Grupo("Proxima Estação", "PE", "Culturo é oportunidades para todo brasil");

		if (dao.inserirGrupo(grupo)) {

			System.out.println("Grupo criado com sucesso!");

		} else {

			System.out.println("Fail");
		}

	}

}
