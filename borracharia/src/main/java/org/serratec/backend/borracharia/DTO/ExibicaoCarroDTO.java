package org.serratec.backend.borracharia.DTO;

import java.util.List;

import org.serratec.backend.borracharia.model.TabelaServico;

public class ExibicaoCarroDTO {

	private Integer idCarro;
	private String modelo;
	private String marca;
	private int ano;
	private Integer idCliente;
	private List<TabelaServicoDTO> listaTabela;
//	private List<TabelaServico> listaTabelaServico;

	public void setListaTabela(List<TabelaServicoDTO> listaTabela) {
		this.listaTabela = listaTabela;
	}

	public ExibicaoCarroDTO() {
	}

	public List<TabelaServicoDTO> getListaTabela() {
		return listaTabela;
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

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}
