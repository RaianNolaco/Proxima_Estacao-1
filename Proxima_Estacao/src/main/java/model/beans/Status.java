package model.beans;

public class Status {
	
	private int id_status;
	private String descricao;
	
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId_status() {
	return id_status;
	}
	public void setId_status(int id_status) {
		this.id_status = id_status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Status(String descricao) {
		super();
		this.descricao = descricao;
	}
	
}
