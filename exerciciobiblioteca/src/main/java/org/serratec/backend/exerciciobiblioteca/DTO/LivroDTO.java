package org.serratec.backend.exerciciobiblioteca.DTO;

import java.util.Date;

public class LivroDTO {

	private static final long serialVersionUID = 1L;

	private Integer idLivro;
	private String tituloLivro;
	private String tipoLivro;
	private String autor;
	private Date dataDaPublicacao;

	// Constructor
	public LivroDTO() {
	}

	// Getters and Setters
	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getTipoLivro() {
		return tipoLivro;
	}

	public void setTipoLivro(String tipoLivro) {
		this.tipoLivro = tipoLivro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataDaPublicacao() {
		return dataDaPublicacao;
	}

	public void setDataDaPublicacao(Date dataDaPublicacao) {
		this.dataDaPublicacao = dataDaPublicacao;
	}

}
