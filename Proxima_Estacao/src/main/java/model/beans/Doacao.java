package model.beans;

public class Doacao {

	private int id_doacao;
	private float quantidade;
	private Artista id_artista;
	private Usuario id_usuario;
	private Forma_pagamento id_forma_pag;

	public Doacao(float quantidade, Artista id_artista, Usuario id_usuario, Forma_pagamento id_forma_pag) {
		super();

		this.quantidade = quantidade;
		this.id_artista = id_artista;
		this.id_usuario = id_usuario;
		this.id_forma_pag = id_forma_pag;
	}

	public Doacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_doacao() {
		return id_doacao;
	}

	public void setId_doacao(int id_doacao) {
		this.id_doacao = id_doacao;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public Artista getId_artista() {
		return id_artista;
	}

	public void setId_artista(Artista id_artista) {
		this.id_artista = id_artista;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Forma_pagamento getId_forma_pag() {
		return id_forma_pag;
	}

	public void setId_forma_pag(Forma_pagamento id_forma_pag) {
		this.id_forma_pag = id_forma_pag;
	}

}