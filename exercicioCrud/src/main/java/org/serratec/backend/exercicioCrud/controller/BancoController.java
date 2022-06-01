package org.serratec.backend.exercicioCrud.controller;

import java.util.List;

import org.serratec.backend.exercicioCrud.model.Banco;
import org.serratec.backend.exercicioCrud.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banco")
public class BancoController {

	@Autowired
	BancoService bancoService;

	@GetMapping("/conta")
	public List<Banco> getBanco() {
		return bancoService.contaBanco();
	}

	@PostMapping("/adicionar")
	public void adicionar(@RequestBody Banco banco) {
		bancoService.adicionar(banco);

	}
	
	@GetMapping("/pesquisa/{idBanco}")
	public Banco bancoId(@PathVariable int idBanco) {
		return bancoService.bancoId(idBanco);
	}
	

	@PutMapping("/atualizar/{posicaoLista}")
	public void atualizar(@PathVariable Integer posicaoLista, @RequestBody Banco bancoDoApi) {
		bancoService.atualizar(posicaoLista, bancoDoApi);

	}

	@DeleteMapping("/delete/{posicaoLista}")
	public void deletar(@PathVariable int posicaoLista) {
		bancoService.deletar(posicaoLista);
	}

}
