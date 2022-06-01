package org.serratec.backend.borracharia.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.backend.borracharia.DTO.ExibicaoTabelaServicoDTO;
import org.serratec.backend.borracharia.DTO.RelatorioDTO;
import org.serratec.backend.borracharia.DTO.TabelaServicoDTO;
import org.serratec.backend.borracharia.exception.EmailException;
import org.serratec.backend.borracharia.exception.TabelaServicoException;
import org.serratec.backend.borracharia.service.TabelaServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tabela")
public class TabelaServicoController {

	@Autowired
	TabelaServicoService tabelaServicoService;

	@PostMapping("/salvar")
	public ResponseEntity<Void> salvar(@RequestBody TabelaServicoDTO tabelaServicoDTO) throws MessagingException, EmailException {
		tabelaServicoService.salvar(tabelaServicoDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/buscar/{idTabela}")
	public ResponseEntity<TabelaServicoDTO> buscarPorId(@PathVariable Integer idTabela) throws TabelaServicoException {
		return ResponseEntity.ok(tabelaServicoService.buscarPorId(idTabela));
	}

	@PutMapping("/atualizar/{idTabela}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idTabela,
			@RequestBody TabelaServicoDTO tabelaServicoDTO) {
		tabelaServicoService.atualizar(idTabela, tabelaServicoDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{idTabela}")
	public ResponseEntity<Void> delete(@PathVariable Integer idTabela) {
		tabelaServicoService.delete(idTabela);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/lista")
	public ResponseEntity<List<ExibicaoTabelaServicoDTO>> listaTodos() {
		return ResponseEntity.ok(tabelaServicoService.listarTodos());
	}

	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<TabelaServicoDTO> listaTabelaDTO) {
		tabelaServicoService.salvarListaTabela(listaTabelaDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/relatorio")
	public List<RelatorioDTO> relatorio() {
		return tabelaServicoService.relatorio();
	}
}
