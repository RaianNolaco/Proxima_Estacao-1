package model.beans;

public class Recompensa{
	
	private int    id_recompensa;
	private String nome; 
	private String descricao;
	private String emblema;
	
	public Recompensa( String nome, String descricao, String emblema) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.emblema = emblema;
	}

	public Recompensa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_recompensa() {
		return id_recompensa;
	}

	public void setId_recompensa(int id_recompensa) {
		this.id_recompensa = id_recompensa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmblema() {
		return emblema;
	}

	public void setEmblema(String emblema) {
		this.emblema = emblema;
	}
	
}