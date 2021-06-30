package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.Test;

import model.beans.Status;
import model.beans.Usuario;
import model.dao.UsuarioDAO;


class UsuarioDAOTest {
	UsuarioDAO dao = new UsuarioDAO();
	Status status = new Status();

	
	
	@Test

	public void InserirUsuario() {
		status.setId_status(1);
		Usuario usuario = new Usuario("William", "Araujo", "Will", "w", status, "zees", "76543", "17/07/2002",
				"76521");
		if (dao.inserirUsuario(usuario)) {
			System.out.println("deu certo");
		} else {
			fail("Deu erro");
		}

	}
	
	@Test
	public void todosUsuarios() {
		
		for(Usuario usuario: dao.listarUsuarios()) {
	
			System.out.println("Id: " + usuario.getIdUsuario()
							+ "\nNome: " + usuario.getNomeUsuario()
			                + "\nSobrenome: "+ usuario.getSobrenomeUsuario()
			                + "\nApelido: " + usuario.getApelido()
			                + "\nEmail: " + usuario.getEmail()
			                + "\nSenha: " + usuario.getSenha()
			                + "\nNumero: " + usuario.getNumero()
			                + "\nStatus: " + usuario.getIdStatus().getId_status()
			                + "\nData de Nascimento: " + usuario.getData_nascimento()
			                + "\nCPF: " + usuario.getCpf());
		}
		
	}

}
