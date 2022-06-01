package org.serratec.backend.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.borracharia.DTO.CarroDTO;
import org.serratec.backend.borracharia.DTO.ExibicaoCarroDTO;
import org.serratec.backend.borracharia.DTO.TabelaServicoDTO;
import org.serratec.backend.borracharia.exception.CarroException;
import org.serratec.backend.borracharia.model.Carro;
import org.serratec.backend.borracharia.model.TabelaServico;
import org.serratec.backend.borracharia.repository.CarroRepository;
import org.serratec.backend.borracharia.repository.ClienteRepository;
import org.serratec.backend.borracharia.repository.TabelaServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	TabelaServicoRepository tabelaServicoRepository;

	// Salvar
	public void salvar(CarroDTO carroDTO) {
		Carro carro = new Carro();
		Carro carroSalvar = transformarCarroDTOEmCarroModel(carroDTO, carro);
		carroRepository.save(carroSalvar);
	}

	public CarroDTO transformarCarroModelEmCarroDTO(CarroDTO carroDTO, Carro carro) {

		carroDTO.setIdCarro(carro.getIdCarro());
		carroDTO.setModelo(carro.getModelo());
		carroDTO.setMarca(carro.getMarca());
		carroDTO.setAno(carro.getAno());

		return carroDTO;
	}

	public Carro transformarCarroDTOEmCarroModel(CarroDTO carroDTO, Carro carro) {

		carro.setModelo(carroDTO.getModelo());
		carro.setMarca(carroDTO.getMarca());
		carro.setAno(carroDTO.getAno());
		
		if(carroDTO.getIdCliente() != null) {
			carro.setCliente(clienteRepository.findById(carroDTO.getIdCliente()).get());
		}

		return carro;
	}
	
	public ExibicaoCarroDTO transformarCarroModelEmCarroExibicao(ExibicaoCarroDTO exibicaoCarroDTO, Carro carro) {

		exibicaoCarroDTO.setIdCarro(carro.getIdCarro());
		exibicaoCarroDTO.setModelo(carro.getModelo());
		exibicaoCarroDTO.setMarca(carro.getMarca());
		exibicaoCarroDTO.setAno(carro.getAno());


		List<TabelaServicoDTO> listaTabela = new ArrayList<>();
		
		for(TabelaServico tabelaServico : carro.getListaTabelaServico()) {
			TabelaServicoDTO tabelaServicoDTO = new TabelaServicoDTO();
			tabelaServicoDTO.setValor(tabelaServico.getValor());
			tabelaServicoDTO.setDataManutencao(tabelaServico.getDataManutencao());
			tabelaServicoDTO.setServicoPrestado(tabelaServico.getServicoPrestado());
			
			listaTabela.add(tabelaServicoDTO);
		}	
		
		exibicaoCarroDTO.setListaTabela(listaTabela);
		return exibicaoCarroDTO;
	}

	// Buscar por Id
	public CarroDTO buscarPorId(Integer idCarro) throws CarroException {
		Optional<Carro> carro = carroRepository.findById(idCarro);

		// Cliente Vazio
		Carro carroNoBanco = new Carro();

		// ClienteDTO Vazio
		CarroDTO carroDTO = new CarroDTO();

		if (carro.isPresent()) {
			carroNoBanco = carro.get();
			carroDTO = transformarCarroModelEmCarroDTO(carroDTO, carroNoBanco);

			return carroDTO;
		}

		throw new CarroException("Carro não encontrado");
	}

	// Atualizar
	public void atualizar(Integer idCarro, CarroDTO carroDTO) {

		Optional<Carro> carro = carroRepository.findById(idCarro);
		Carro carroNoBanco = new Carro();

		if (carro.isPresent()) {
			carroNoBanco = carro.get();
			if (carroDTO.getAno() != 0) {
				carroNoBanco.setAno(carroDTO.getAno());
			}
			if (carroDTO.getMarca() != null) {
				carroNoBanco.setMarca(carroDTO.getMarca());
			}
			if (carroDTO.getModelo() != null) {
				carroNoBanco.setModelo(carroDTO.getModelo());
			}

			carroRepository.save(carroNoBanco);
		}
	}

	// Deletar
	public void delete(Integer idCarro) {
		carroRepository.deleteById(idCarro);
	}

	// Listar Todos
	public List<ExibicaoCarroDTO> listarTodos() {
		List<Carro> listaCarro = carroRepository.findAll();
		List<ExibicaoCarroDTO> listaCarroExibicaoDTO = new ArrayList<>();
		
		for (Carro carro : listaCarro) {
			
			ExibicaoCarroDTO exibicaoCarroDTO = new ExibicaoCarroDTO();
			
			transformarCarroModelEmCarroExibicao(exibicaoCarroDTO, carro);
			listaCarroExibicaoDTO.add(exibicaoCarroDTO);
		}
		
		return listaCarroExibicaoDTO;
	}

	// Salvar Varios
	public void salvarListaCarro(List<CarroDTO> lista) {
		List<Carro> listaCarro = new ArrayList<>();


		for (CarroDTO carroDTO : lista) {
			Carro carro = new Carro();
			transformarCarroDTOEmCarroModel(carroDTO, carro);
			listaCarro.add(carro);
		}

		carroRepository.saveAll(listaCarro);
	}
}
