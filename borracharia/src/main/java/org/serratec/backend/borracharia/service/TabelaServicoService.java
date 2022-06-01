package org.serratec.backend.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.backend.borracharia.DTO.ExibicaoTabelaServicoDTO;
import org.serratec.backend.borracharia.DTO.RelatorioDTO;
import org.serratec.backend.borracharia.DTO.TabelaServicoDTO;
import org.serratec.backend.borracharia.exception.EmailException;
import org.serratec.backend.borracharia.exception.TabelaServicoException;
import org.serratec.backend.borracharia.model.TabelaServico;
import org.serratec.backend.borracharia.repository.CarroRepository;
import org.serratec.backend.borracharia.repository.TabelaServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabelaServicoService {

	@Autowired
	TabelaServicoRepository tabelaServicoRepository;
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	EmailService emailService;
	
	



	public TabelaServicoDTO transformarTabelaModelEmTabelaDTO(TabelaServicoDTO tabelaServicoDTO,
			TabelaServico tabelaServico) {

		tabelaServicoDTO.setIdTabela(tabelaServico.getIdTabela());
		tabelaServicoDTO.setValor(tabelaServico.getValor());
		tabelaServicoDTO.setServicoPrestado(tabelaServico.getServicoPrestado());
		tabelaServicoDTO.setDataManutencao(tabelaServico.getDataManutencao());
		

		return tabelaServicoDTO;
	}

	public TabelaServico transformarTabelaDTOEmTabelaModel(TabelaServicoDTO tabelaServicoDTO,
			TabelaServico tabelaServico) {

		tabelaServico.setValor(tabelaServicoDTO.getValor());
		tabelaServico.setServicoPrestado(tabelaServicoDTO.getServicoPrestado());
		tabelaServico.setDataManutencao(tabelaServicoDTO.getDataManutencao());
		
		if(tabelaServicoDTO.getIdCarro() != null) {
			tabelaServico.setCarro(carroRepository.findById(tabelaServicoDTO.getIdCarro()).get());
		}

		return tabelaServico;
	}
	
	public ExibicaoTabelaServicoDTO transformarTabelaModelEmTabelaExibicao(ExibicaoTabelaServicoDTO exibicaoTabelaServicoDTO,
			TabelaServico tabelaServico) {

		exibicaoTabelaServicoDTO.setIdTabela(tabelaServico.getIdTabela());
		exibicaoTabelaServicoDTO.setValor(tabelaServico.getValor());
		exibicaoTabelaServicoDTO.setServicoPrestado(tabelaServico.getServicoPrestado());
		exibicaoTabelaServicoDTO.setDataManutencao(tabelaServico.getDataManutencao());
		

		return exibicaoTabelaServicoDTO;
	}

	public TabelaServicoDTO buscarPorId(Integer idTabela) throws TabelaServicoException {
		Optional<TabelaServico> tabelaServico = tabelaServicoRepository.findById(idTabela);

		// Cliente Vazio
		TabelaServico tabelaServicoNoBanco = new TabelaServico();

		// ClienteDTO Vazio
		TabelaServicoDTO tabelaSevicoDTO = new TabelaServicoDTO();

		if (tabelaServico.isPresent()) {
			tabelaServicoNoBanco = tabelaServico.get();
			tabelaSevicoDTO = transformarTabelaModelEmTabelaDTO(tabelaSevicoDTO, tabelaServicoNoBanco);

			return tabelaSevicoDTO;
		}

		throw new TabelaServicoException("TabelaServico não encontrado");
	}
	// Salvar
	public void salvar(TabelaServicoDTO tabelaServicoDTO) throws MessagingException, EmailException {
		TabelaServico tabelaServico = new TabelaServico();
		TabelaServico tabelaServicoSalvar = transformarTabelaDTOEmTabelaModel(tabelaServicoDTO, tabelaServico);
		tabelaServicoRepository.save(tabelaServicoSalvar);
		
		emailService.emailTeste(tabelaServicoDTO);
	}

	
	// Atualizar
	public void atualizar(Integer idTabela, TabelaServicoDTO tabelaSevicoDTO) {

		Optional<TabelaServico> tabelaServico = tabelaServicoRepository.findById(idTabela);
		TabelaServico tabelaNoBanco = new TabelaServico();

		if (tabelaServico.isPresent()) {
			tabelaNoBanco = tabelaServico.get();
			if (tabelaSevicoDTO.getValor() != 0) {
				tabelaNoBanco.setValor(tabelaSevicoDTO.getValor());
			}
			if (tabelaSevicoDTO.getServicoPrestado() != null) {
				tabelaNoBanco.setServicoPrestado(tabelaSevicoDTO.getServicoPrestado());
			}
			if (tabelaSevicoDTO.getDataManutencao() != null) {
				tabelaNoBanco.setDataManutencao(tabelaSevicoDTO.getDataManutencao());
			}

			tabelaServicoRepository.save(tabelaNoBanco);
		}
	}

	// Deletar
	public void delete(Integer idTabela) {
		tabelaServicoRepository.deleteById(idTabela);
	}

	// Listar Todos
	public List<ExibicaoTabelaServicoDTO> listarTodos() {
		List<TabelaServico> listaTabela = tabelaServicoRepository.findAll();
		List<ExibicaoTabelaServicoDTO> listaTabelaExibicaoDTO = new ArrayList<>();
		
		for (TabelaServico tabelaServico : listaTabela) {
			
			ExibicaoTabelaServicoDTO exibicaoTabelaServicoDTO = new ExibicaoTabelaServicoDTO();
			
			transformarTabelaModelEmTabelaExibicao(exibicaoTabelaServicoDTO, tabelaServico);
			listaTabelaExibicaoDTO.add(exibicaoTabelaServicoDTO);
		}
		
		return listaTabelaExibicaoDTO;
	}

	// Salvar Varios
	public void salvarListaTabela(List<TabelaServicoDTO> lista) {
		List<TabelaServico> listaTabela = new ArrayList<>();


		for (TabelaServicoDTO tabelaServicoDTO : lista) {
			TabelaServico tabelaServico = new TabelaServico();
			transformarTabelaDTOEmTabelaModel(tabelaServicoDTO, tabelaServico);
			listaTabela.add(tabelaServico);
		}

		tabelaServicoRepository.saveAll(listaTabela);
	}
	
	// Relatorio
	public List<RelatorioDTO> relatorio() {
		return tabelaServicoRepository.relatorio();
	}
	
}
