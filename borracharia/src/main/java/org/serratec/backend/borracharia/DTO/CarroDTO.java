package org.serratec.backend.borracharia.DTO;

import java.io.Serializable;
import java.util.List;

import org.serratec.backend.borracharia.model.Cliente;
import org.serratec.backend.borracharia.model.TabelaServico;

public class CarroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idCarro;
	private String modelo;
	private String marca;
	private int ano;
	private Integer idCliente;
//	private List<TabelaServico> listaTabelaServico;


	// Constructor
	public CarroDTO() {
	}

	// Getters and Setters
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
//	public List<TabelaServico> getListaTabelaServico() {
//		return listaTabelaServico;
//	}
	
//	public void setListaTabelaServico(List<TabelaServico> listaTabelaServico) {
//		this.listaTabelaServico = listaTabelaServico;
//	}
	
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
