package org.serratec.backend.exerciciobiblioteca.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "livro_cd_id")
	private Integer idLivro;

	@Column(name = "livro_tx_tituloLivro")
	@Size(min = 5, max = 30)
	@NotNull
	private String tituloLivro;

	@Column(name = "livro_tx_tipoLLivro")
	@Size(min = 3, max = 20)
	@NotNull
	private String tipoLivro;

	@Column(name = "livro_tx_autor")
	@Size(min = 10, max = 40)
	@NotNull
	private String autor;

	@Column(name = "livro_dt_dataDaPublicacao")
	@Past
	private Date dataDaPublicacao;

	// Constructor
	public Livro() {
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
