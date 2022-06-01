package org.serratec.backend.exercicioCrud.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.exercicioCrud.model.Banco;
import org.springframework.stereotype.Service;

@Service
public class BancoService {

	List<Banco> conta = new ArrayList<>();

	public void adicionar(Banco banco) {
		conta.add(banco);
	}

	public List<Banco> contaBanco() {
		return this.conta;
	}
	
	public Banco bancoId(int idBanco) {
		Banco pesquisaBanco = new Banco();
		for (Banco banco : conta) {
			if(banco.getId().equals(idBanco)) {
				pesquisaBanco = banco;
			}
		}
		return pesquisaBanco;
	}

	public void atualizar(Integer posicaoLista, Banco contaDaApi) {

		Banco contaDaListaSalva = new Banco();
		contaDaListaSalva = conta.get(posicaoLista);

		contaDaListaSalva.setId(contaDaApi.getId());
		contaDaListaSalva.setNome(contaDaApi.getNome());
		contaDaListaSalva.setCpf(contaDaApi.getCpf());
		contaDaListaSalva.setBanco(contaDaApi.getBanco());
		contaDaListaSalva.setCidade(contaDaApi.getCidade());

	}

	public void deletar(int posicaoLista) {
		conta.remove(posicaoLista);
	}
}
