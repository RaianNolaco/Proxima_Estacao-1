package testes;

import org.junit.jupiter.api.Test;
import model.beans.Forma_pagamento;
import model.dao.FormaPagamentoDAO;

class FormaPagamentoDAOTest {
	FormaPagamentoDAO dao = new FormaPagamentoDAO();

	@Test
	public void listarPublicacoes() {

		for (Forma_pagamento forma : dao.listarFormas()) {
			System.out.println("\nId: " + forma.getId_forma_pag() + "\nNome: " + forma.getNome());
		}

	}

}
