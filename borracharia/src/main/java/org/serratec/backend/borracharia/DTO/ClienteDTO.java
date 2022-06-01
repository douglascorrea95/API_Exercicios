package org.serratec.backend.borracharia.DTO;

import java.io.Serializable;
import java.util.List;

import org.serratec.backend.borracharia.model.Carro;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idCliente;
	private String nomeCliente;
	private String cpf;
	private String numeroTelefone;
	private String email;
//private List<Carro> listaCarro;


	// Constructor
	public ClienteDTO() {
	}

	// Getters and Setters
//	public List<Carro> getListaCarro() {
//		return listaCarro;
//	}
	
//	public void setListaCarro(List<Carro> listaCarro) {
//		this.listaCarro = listaCarro;
//	}
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

}
