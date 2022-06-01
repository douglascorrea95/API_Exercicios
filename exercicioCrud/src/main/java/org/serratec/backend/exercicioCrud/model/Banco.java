package org.serratec.backend.exercicioCrud.model;

public class Banco {

	private Integer id;
	private String nome;
	private String cpf;
	private String banco;
	private String cidade;

	// Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	// Constructor
	public Banco() {
		super();
	}

	public Banco(Integer id, String nome, String cpf, String banco, String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.banco = banco;
		this.cidade = cidade;
	}

}
