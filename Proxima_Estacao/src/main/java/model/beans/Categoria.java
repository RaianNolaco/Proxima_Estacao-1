package model.beans;

public class Categoria{
	
	private int     id_categoria;
	private String  nome_categoria;
	private int     id_tipo_categoria;
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categoria(int id_categoria, String nome_categoria, int id_tipo_categoria) {
		super();
		this.id_categoria = id_categoria;
		this.nome_categoria = nome_categoria;
		this.id_tipo_categoria = id_tipo_categoria;
	}
	
	public int getId_categoria() {
		return id_categoria;
		}
	
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNome_categoria() {
		return nome_categoria;
	}
	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}
	public int getId_tipo_categoria() {
		return id_tipo_categoria;
	}
	public void setId_tipo_categoria(int id_tipo_categoria) {
		this.id_tipo_categoria = id_tipo_categoria;
	}
	
	
	
	
}