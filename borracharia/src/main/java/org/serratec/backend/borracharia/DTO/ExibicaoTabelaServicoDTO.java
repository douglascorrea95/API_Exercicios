package org.serratec.backend.borracharia.DTO;

import java.util.Date;

public class ExibicaoTabelaServicoDTO {

	private Integer idTabela;
	private Double valor;
	private String servicoPrestado;
	private Date dataManutencao;
	private Integer idCarro;
	
	public ExibicaoTabelaServicoDTO() {}

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

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	
	
}
