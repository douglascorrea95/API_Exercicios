package org.serratec.backend.borracharia.controller;

import java.util.List;

import org.serratec.backend.borracharia.DTO.CarroDTO;
import org.serratec.backend.borracharia.DTO.ExibicaoCarroDTO;
import org.serratec.backend.borracharia.exception.CarroException;
import org.serratec.backend.borracharia.model.Carro;
import org.serratec.backend.borracharia.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	CarroService carroService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Void> salvar(@RequestBody CarroDTO carroDTO) {
		carroService.salvar(carroDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/buscar/{idCarro}")
	public ResponseEntity<CarroDTO> buscarPorId(@PathVariable Integer idCarro) throws CarroException {
		return ResponseEntity.ok(carroService.buscarPorId(idCarro));
	}

	@PutMapping("/atualizar/{idCarro}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idCarro, @RequestBody CarroDTO carroDTO) {
		carroService.atualizar(idCarro, carroDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{idCarro}")
	public ResponseEntity<Void> delete(@PathVariable Integer idCarro) {
		carroService.delete(idCarro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/lista")
	public ResponseEntity<List<ExibicaoCarroDTO>> listaTodos() {
		return ResponseEntity.ok(carroService.listarTodos());
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<CarroDTO> listaCarroDTO) {
		carroService.salvarListaCarro(listaCarroDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
