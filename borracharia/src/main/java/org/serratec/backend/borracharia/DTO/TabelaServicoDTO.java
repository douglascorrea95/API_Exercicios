package org.serratec.backend.borracharia.DTO;

import java.util.Date;

import org.serratec.backend.borracharia.model.Carro;

public class TabelaServicoDTO {

	private Integer idTabela;
	private Double valor;
	private String servicoPrestado;
	private Date dataManutencao;
	private Integer idCarro;
	

	// Constructor
	public TabelaServicoDTO () {}

	// Getters and Setters
	public Integer getIdCarro() {
		return idCarro;
	}
	
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	public Integer getIdTabela() {
		return idTabela;
	}

	public void setIdTabela(Integer idTabela) {
		this.idTabela = idTabela;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getServicoPrestado() {
		return servicoPrestado;
	}

	public void setServicoPrestado(String servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}
	
	
}
