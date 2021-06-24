package model.beans;

public class Feedback{
	
	private int    id_feedback;
	private String titulo; 
	private String comentario;
	private char   gostei; 
	private int    id_usuario;
	private int    id_publicacao;
	
	public Feedback(int id_feedback, String titulo, String comentario, char gostei, int id_usuario, int id_publicacao) {
		super();
		this.id_feedback = id_feedback;
		this.titulo = titulo;
		this.comentario = comentario;
		this.gostei = gostei;
		this.id_usuario = id_usuario;
		this.id_publicacao = id_publicacao;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_feedback() {
		return id_feedback;
	}

	public void setId_feedback(int id_feedback) {
		this.id_feedback = id_feedback;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public char getGostei() {
		return gostei;
	}

	public void setGostei(char gostei) {
		this.gostei = gostei;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_publicacao() {
		return id_publicacao;
	}

	public void setId_publicacao(int id_publicacao) {
		this.id_publicacao = id_publicacao;
	}
	
}