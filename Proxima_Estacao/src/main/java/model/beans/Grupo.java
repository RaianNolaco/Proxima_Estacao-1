package model.beans;

public class Grupo{
	
	private int    id_grupo;
	private String nome_grupo;
	private String tag_grupo;
	private String descricao_grupo;
	
	
	public Grupo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Grupo(int id_grupo, String nome_grupo, String tag_grupo, String descricao_grupo){
		
		super();
		this.id_grupo = id_grupo;
		this.nome_grupo = nome_grupo;
		this.tag_grupo = tag_grupo;
		this.descricao_grupo = descricao_grupo;
		
	}


	public int getId_grupo() {
		return id_grupo;
	}
	public void setId_grupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}
	public String getNome_grupo() {
		return nome_grupo;
	}
	public void setNome_grupo(String nome_grupo) {
		this.nome_grupo = nome_grupo;
	}
	public String getTag_grupo() {
		return tag_grupo;
	}
	public void setTag_grupo(String tag_grupo) {
		this.tag_grupo = tag_grupo;
	}
	public String getDescricao_grupo() {
		return descricao_grupo;
	}
	public void setDescricao_grupo(String descricao_grupo) {
		this.descricao_grupo = descricao_grupo;
	}
		
}