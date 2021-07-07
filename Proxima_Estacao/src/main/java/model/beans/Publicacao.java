package model.beans;

public class Publicacao {

	private int id_publicacao;
	private String thumb;
	private String conteudo;
	private boolean conteudo_NSFW;
	private String descricao;
	private int views;
	private Artista id_artista;

	public Publicacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Publicacao(String thumb, String conteudo, boolean conteudo_NSFW, String descricao, int views,
			Artista id_artista) {
		super();

		this.thumb = thumb;
		this.conteudo = conteudo;
		this.conteudo_NSFW = conteudo_NSFW;
		this.descricao = descricao;
		this.views = views;
		this.id_artista = id_artista;
	}

	public int getId_publicacao() {
		return id_publicacao;
	}

	public void setId_publicacao(int id_publicacao) {
		this.id_publicacao = id_publicacao;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public boolean getConteudo_NSFW() {
		return conteudo_NSFW;
	}

	public void setConteudo_NSFW(boolean conteudo_NSFW) {
		this.conteudo_NSFW = conteudo_NSFW;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Artista getId_artista() {
		return id_artista;
	}

	public void setId_artista(Artista id_artista) {
		this.id_artista = id_artista;
	}

}