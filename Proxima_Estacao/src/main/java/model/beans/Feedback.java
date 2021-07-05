package model.beans;

public class Feedback{
	
	private int    		id_feedback;
	private String		titulo;	
	private String 		comentario;
	private boolean     gostei; 
	private Usuario     id_usuario;
	private Publicacao  id_publicacao;
	
	public Feedback( String titulo,String comentario, boolean gostei, Usuario id_usuario, Publicacao id_publicacao) {
		
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

	public boolean getGostei() {
		return gostei;
	}

	public void setGostei(boolean gostei) {
		this.gostei = gostei;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Publicacao getId_publicacao() {
		return id_publicacao;
	}

	public void setId_publicacao(Publicacao id_publicacao) {
		this.id_publicacao = id_publicacao;
	}
	
}