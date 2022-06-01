package org.serratec.backend.borracharia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carro_cd_idCarro")
	private Integer idCarro;
	
	@Column(name = "carro_tx_modelo")
	private String modelo;
	
	@Column(name = "carro_tx_marca")
	private String marca;
	
	@Column(name = "carro_num_ano")
	private int ano;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "cliente_cd_id")
	private Cliente cliente;
	

	@OneToMany(mappedBy = "carro")
	private List<TabelaServico> listaTabelaServico;
	
	// Constructor
	public Carro () {}

	// Getters and Setters
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<TabelaServico> getListaTabelaServico() {
		return listaTabelaServico;
	}
	
	public void setListaTabelaServico(List<TabelaServico> listaTabelaServico) {
		this.listaTabelaServico = listaTabelaServico;
	}
	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
