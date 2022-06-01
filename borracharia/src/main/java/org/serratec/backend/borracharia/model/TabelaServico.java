package org.serratec.backend.borracharia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tabela")
public class TabelaServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "tabela_cd_id")
	private Integer idTabela;
	
	@Column(name = "tabela_num_valor")
	private Double valor;
	
	@Column(name = "tabela_tx_servico")
	private String servicoPrestado;
	
	@Column(name = "tabela_dt_data")
	private Date dataManutencao;
	
	@ManyToOne
	@JoinColumn(name = "carro_id", referencedColumnName = "carro_cd_idCarro")
	private Carro carro;
	

	// Constructor
	public TabelaServico () {}

	// Getters and Setters
	public Carro getCarro() {
		return carro;
	}
	
	public void setCarro(Carro carro) {
		this.carro = carro;
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
