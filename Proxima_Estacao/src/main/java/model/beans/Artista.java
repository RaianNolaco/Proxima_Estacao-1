package model.beans;

public class Artista{
	
	private int    id_artista;
	private String descricao;
	private int    id_usuario; 
	private String rede_social;
	
	public Artista(int id_artista, String descricao, int id_usuario, String rede_social) {
		super();
		this.id_artista = id_artista;
		this.descricao = descricao;
		this.id_usuario = id_usuario;
		this.rede_social = rede_social;
	}

	public Artista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_artista() {
		return id_artista;
	}

	public void setId_artista(int id_artista) {
		this.id_artista = id_artista;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getRede_social() {
		return rede_social;
	}

	public void setRede_social(String rede_social) {
		this.rede_social = rede_social;
	}
	
}