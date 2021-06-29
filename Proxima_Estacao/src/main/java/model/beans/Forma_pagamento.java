package model.beans;


public class Forma_pagamento{
	
	private int id_forma_pag;
	private String nome;
	
	public Forma_pagamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Forma_pagamento(String nome) {
		super();
	
		this.nome = nome;
	}
	
	public int getId_forma_pag() {
		return id_forma_pag;
	}
	public void setId_forma_pag(int id_forma_pag) {
		this.id_forma_pag = id_forma_pag;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}