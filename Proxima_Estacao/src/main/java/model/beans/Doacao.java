package model.beans;

public class Doacao{
	
	private int   id_doacao;
	private float quantidade;
	private int   id_artista;
	private int   id_usuario;
	private int   id_forma_pag;
	
	
	public Doacao(int id_doacao, float quantidade, int id_artista, int id_usuario, int id_forma_pag) {
		super();
		this.id_doacao = id_doacao;
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


	public int getId_artista() {
		return id_artista;
	}


	public void setId_artista(int id_artista) {
		this.id_artista = id_artista;
	}


	public int getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}


	public int getId_forma_pag() {
		return id_forma_pag;
	}


	public void setId_forma_pag(int id_forma_pag) {
		this.id_forma_pag = id_forma_pag;
	}
	
	
}