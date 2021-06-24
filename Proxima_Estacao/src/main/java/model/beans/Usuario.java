package model.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
	
	private int    idUsuario;
	private String nomeUsuario;
	private String sobrenomeUsuario;
	private String apelido;
	private String email;
	private Status idStatus;
	private String senha;
	private String numero;
	private Date   data_nascimento;
	private String cpf;
	
	
	public Usuario(String nomeUsuario, String sobrenomeUsuario, String apelido, String email,
	   Status idStatus, String senha, String numero, String data_nascimento, String cpf) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.sobrenomeUsuario = sobrenomeUsuario;
		this.apelido = apelido;
		this.email = email;
		this.idStatus = idStatus;
		this.senha = senha;
		this.numero = numero;
		this.data_nascimento = converteData(data_nascimento);
		this.cpf = cpf;
	}

	public Usuario() {
		super();

	}
	
	public Date converteData(String data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = null;
		try {
			dataFormatada = formatador.parse(data);
		} catch (ParseException e) {
			System.err.print("Erro ao formatar");
		}
		return dataFormatada;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSobrenomeUsuario() {
		return sobrenomeUsuario;
	}

	public void setSobrenomeUsuario(String sobrenomeUsuario) {
		this.sobrenomeUsuario = sobrenomeUsuario;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Status idStatus) {
		this.idStatus = idStatus;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
		
}
