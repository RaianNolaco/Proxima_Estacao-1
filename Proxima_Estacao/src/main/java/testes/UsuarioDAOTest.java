package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		Date date = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = formatter.parse("17/07/2002");
		} catch (ParseException e) {
			System.err.print("Erro ao formatar");
		}
		
		Usuario usuario = new Usuario("William", "Araujo", "Will", "w@gmail.com", status, "zees", "8976543", date, "7654321");
		if(dao.inserirUsuario(usuario)) {
			System.out.println("deu certo");
		}else {
			fail("Puts");
		}
		
		
		
	}

}
