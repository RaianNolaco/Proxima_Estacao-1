package model.beans;

public class Tipo_Categoria{
	
	private int id_tipo_categoria;
	private String nome_categoria;
	
	
	
	
	public Tipo_Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tipo_Categoria(int id_tipo_categoria, String nome_categoria) {
		super();
		this.id_tipo_categoria = id_tipo_categoria;
		this.nome_categoria = nome_categoria;
	}
	
	//get e set
	
	public int getId_tipo_categoria() {
		return id_tipo_categoria;
	}
	public void setId_tipo_categoria(int id_tipo_categoria) {
		this.id_tipo_categoria = id_tipo_categoria;
	}
	public String getNome_categoria() {
		return nome_categoria;
	}
	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}
	
	
	
}