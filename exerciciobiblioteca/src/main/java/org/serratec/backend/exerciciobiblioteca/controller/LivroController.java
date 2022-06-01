package org.serratec.backend.exerciciobiblioteca.controller;

import java.util.List;

import org.serratec.backend.exerciciobiblioteca.DTO.LivroDTO;
import org.serratec.backend.exerciciobiblioteca.exception.BibliotecaException;
import org.serratec.backend.exerciciobiblioteca.service.LivroService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	LivroService livroService;

	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody LivroDTO livroDTO) {
		return ResponseEntity.ok(livroService.salvar(livroDTO));
	}

	@GetMapping("/buscar/{idLivro}")
	public ResponseEntity<LivroDTO> buscarPorId(@PathVariable Integer idLivro) throws BibliotecaException {
		return ResponseEntity.ok(livroService.buscarPorId(idLivro));
	}

	@DeleteMapping("/{idLivro}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idLivro) {
		livroService.deletar(idLivro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/atualizar/{idLivro}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idLivro, @RequestBody LivroDTO livroDTO)
			throws BibliotecaException {
		return ResponseEntity.ok(livroService.atualizar(idLivro, livroDTO));
	}

	@GetMapping("/lista")
	public ResponseEntity<List<LivroDTO>> listarTodos() {
		return ResponseEntity.ok(livroService.buscarLivros());
	}

	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<LivroDTO> listaLivroDTO) {
		livroService.salvarListaLivros(listaLivroDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/lista/ordenada")
	public ResponseEntity<List<LivroDTO>> listaOrdenada(@RequestParam String ordem) throws BibliotecaException {
		return ResponseEntity.ok(livroService.listaOrdenada(ordem));
	}
}
