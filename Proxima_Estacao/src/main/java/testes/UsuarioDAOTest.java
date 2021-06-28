package testes;

import static org.junit.jupiter.api.Assertions.*;
import model.beans.Status;
import model.beans.Usuario;
import model.dao.UsuarioDAO;

import org.junit.jupiter.api.Test;

import connection.ConnectionFactory;

class UsuarioDAOTest {

	@Test
	public void testeBanco() {
		ConnectionFactory.getConnection();
	}
	
	
	


}
