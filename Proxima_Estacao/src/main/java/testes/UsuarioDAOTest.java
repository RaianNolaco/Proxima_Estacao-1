package testes;

import static org.junit.jupiter.api.Assertions.*;
import model.beans.Status;
import model.beans.Usuario;
import model.dao.UsuarioDAO;

import org.junit.jupiter.api.Test;

class UsuarioDAOTest {

	@Test
	public void InserirUsuario() {
		
		UsuarioDAO dao = new UsuarioDAO();
		Status status = new Status();
		status.setId_status(1);
		
		Usuario usuario = new Usuario("William", "Araujo", "Will", "w@gmail.com", status, "zees", "8976543", "17/07/2002", "7654321");
		
		if(dao.inserirUsuario(usuario)) {
			System.out.println("deu certo");
		}else {
			fail("Deu erro");
		}
		
	}

}
