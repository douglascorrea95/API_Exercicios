package org.serratec.backend.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.borracharia.DTO.CarroDTO;
import org.serratec.backend.borracharia.DTO.ClienteDTO;
import org.serratec.backend.borracharia.DTO.ExibicaoClienteDTO;
import org.serratec.backend.borracharia.exception.ClienteException;
import org.serratec.backend.borracharia.model.Carro;
import org.serratec.backend.borracharia.model.Cliente;
import org.serratec.backend.borracharia.repository.CarroRepository;
import org.serratec.backend.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CarroRepository carroRepository;

	// Salvar
	public void salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		Cliente clienteSalvar = transformarClienteDTOEmClienteModel(clienteDTO, cliente);
		clienteRepository.save(clienteSalvar);
	}

	public ClienteDTO transformarClienteModelEmClienteDTO(ClienteDTO clienteDTO, Cliente cliente) {

		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setNomeCliente(cliente.getNomeCliente());
		clienteDTO.setCpf(cliente.getCpf().replace(".", "").replace("-", ""));
		clienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());
		clienteDTO.setEmail(cliente.getEmail());
//		clienteDTO.setListaCarro(cliente.getListaCarro());

		return clienteDTO;
	}

	public Cliente transformarClienteDTOEmClienteModel(ClienteDTO clienteDTO, Cliente cliente) {

		cliente.setNomeCliente(clienteDTO.getNomeCliente());
		cliente.setCpf(clienteDTO.getCpf().replace(".", "").replace("-", ""));
		cliente.setNumeroTelefone(clienteDTO.getNumeroTelefone());
		cliente.setEmail(clienteDTO.getEmail());

		return cliente;
	}
	
	public ExibicaoClienteDTO transformarClienteModelEmClienteExibicao(ExibicaoClienteDTO exibicaoClienteDTO, Cliente cliente) {

		exibicaoClienteDTO.setIdCliente(cliente.getIdCliente());
		exibicaoClienteDTO.setNomeCliente(cliente.getNomeCliente());
		exibicaoClienteDTO.setCpf(cliente.getCpf().replace(".", "").replace("-", ""));
		exibicaoClienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());
		exibicaoClienteDTO.setEmail(cliente.getEmail());

		List<CarroDTO> listaCarro = new ArrayList<>();
		
		for(Carro carro : cliente.getListaCarro()) {
			CarroDTO carroDTO = new CarroDTO();
			carroDTO.setAno(carro.getAno());
			carroDTO.setMarca(carro.getMarca());
			carroDTO.setModelo(carro.getModelo());
			
			listaCarro.add(carroDTO);
		}

		exibicaoClienteDTO.setListaCarro(listaCarro);
		return exibicaoClienteDTO;
	}
	

	// Buscar Por ID
	public ExibicaoClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);

		Cliente clienteNoBanco = new Cliente();

		ExibicaoClienteDTO exibicaoClienteDTO = new ExibicaoClienteDTO();

		if (cliente.isPresent()) {
			clienteNoBanco = cliente.get();
			exibicaoClienteDTO = transformarClienteModelEmClienteExibicao(exibicaoClienteDTO, clienteNoBanco);

			return exibicaoClienteDTO;
		}

		throw new ClienteException("Cliente não encontrado");
	}

	// Atualizar
	public void atualizar(Integer idCliente, ClienteDTO clienteDTO) {

		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNoBanco = new Cliente();

		if (cliente.isPresent()) {
			clienteNoBanco = cliente.get();
			if (clienteDTO.getCpf() != null) {
				clienteNoBanco.setCpf(clienteDTO.getCpf());
			}
			if (clienteDTO.getNomeCliente() != null) {
				clienteNoBanco.setNomeCliente(clienteDTO.getNomeCliente());
			}
			if (clienteDTO.getEmail() != null) {
				clienteNoBanco.setEmail(clienteDTO.getEmail());
			}
			if (clienteDTO.getNumeroTelefone() != null) {
				clienteNoBanco.setNumeroTelefone(clienteDTO.getNumeroTelefone());
			}
			clienteRepository.save(clienteNoBanco);
		}
	}

	// Deletar
	public void delete(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}

	// Listar Todos
	public List<ExibicaoClienteDTO> listarTodos() {
		List<Cliente> listaCliente = clienteRepository.findAll();
		List<ExibicaoClienteDTO> listaClienteExibicaoDTO = new ArrayList<>();
		
		for (Cliente cliente : listaCliente) {
			
			ExibicaoClienteDTO exibicaoClienteDTO = new ExibicaoClienteDTO();
			
			transformarClienteModelEmClienteExibicao(exibicaoClienteDTO, cliente);
			listaClienteExibicaoDTO.add(exibicaoClienteDTO);
		}
		
		return listaClienteExibicaoDTO;
	}

	// Salvar Varios
	public void salvarListaCliente(List<ClienteDTO> lista) {
		List<Cliente> listaCliente = new ArrayList<>();


		for (ClienteDTO clienteDTO : lista) {
			Cliente cliente = new Cliente();
			transformarClienteDTOEmClienteModel(clienteDTO, cliente);
			listaCliente.add(cliente);
		}

		clienteRepository.saveAll(listaCliente);
	}
}
