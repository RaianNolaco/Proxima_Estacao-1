package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.beans.Artista;
import model.beans.Doacao;
import model.beans.Forma_pagamento;
import model.beans.Usuario;
import model.dao.DoacaoDAO;

class DoacaoDAOTest {

	@Test

	public void inserirDoacao(){
		
		DoacaoDAO dao = new DoacaoDAO();
		
		Artista artista = new Artista();
		artista.setId_artista(1);
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(4);
		
		Forma_pagamento forma_pag = new Forma_pagamento(); 
		forma_pag.setId_forma_pag(1);
		
		Doacao doacao = new Doacao(50,artista,usuario,forma_pag);
		
		if(dao.inserirDoacao(doacao)){
			
			System.out.println("Deu certo :) hihi");
			
		}else{
			
			fail("Deu erro :(");
		}
		
	}

}
