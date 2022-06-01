package org.serratec.backend.borracharia.DTO;

import java.util.List;

public class ExibicaoClienteDTO {

	private Integer idCliente;
	private String nomeCliente;
	private String cpf;
	private String numeroTelefone;
	private String email;
	private List<CarroDTO> listaCarro;

	public void setListaCarro(List<CarroDTO> listaCarro) {
		this.listaCarro = listaCarro;
	}

	public ExibicaoClienteDTO() {
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CarroDTO> getListaCarro() {
		return listaCarro;
	}

}
