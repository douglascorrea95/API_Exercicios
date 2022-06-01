package org.serratec.backend.exercicioBanco.service;

import java.util.List;

import org.serratec.backend.exercicioBanco.exception.ContaException;
import org.serratec.backend.exercicioBanco.exception.OperacaoException;
import org.serratec.backend.exercicioBanco.model.Conta;
import org.serratec.backend.exercicioBanco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;

	// Lista das Contas
	public List<Conta> listaDasContas() {
		return contaRepository.findAll();
	}

	// Buscar Conta
	public Conta buscarConta(Integer numeroConta) throws ContaException {
		Conta buscarConta = new Conta();
		for (Conta conta : listaDasContas()) {
			if (conta.getNumeroConta().equals(numeroConta)) {
				buscarConta = conta;
			}
		}

		if (buscarConta.getNumeroConta() == null) {
			throw new ContaException(numeroConta);
		}

		return buscarConta;
	}

	// Adicionar Conta
	public void salvarConta(Conta contaNova) {
		contaRepository.save(contaNova);
	}

	// Atualizar Conta
	public void atualizarConta(Integer numeroConta, Conta atualizar) throws ContaException {
		Conta novaConta = new Conta();
		for (Conta conta : listaDasContas()) {
			if (conta.getNumeroConta().equals(numeroConta)) {
				novaConta = conta;

				if (atualizar.getNomeTitular() != null) {
					novaConta.setNomeTitular(atualizar.getNomeTitular());
				}

				if (atualizar.getNumeroConta() != null) {
					novaConta.setNumeroConta(atualizar.getNumeroConta());
				}

				contaRepository.save(novaConta);

			}
		}

		if (novaConta.getNumeroConta() == null) {
			throw new ContaException(numeroConta);
		}
	}

	// Deletar Conta
	public void deletarConta(Integer numeroConta) {
		Conta delete = new Conta();
		for (Conta conta : listaDasContas()) {
			if (conta.getNumeroConta().equals(numeroConta)) {
				delete = conta;
			}
		}
		contaRepository.delete(delete);
	}

	// Saque
	public void sacar(Integer numeroConta, float valor) throws OperacaoException {
		Conta contaOperacao = new Conta();
		for (Conta conta : listaDasContas()) {
			if (conta.getNumeroConta().equals(numeroConta)) {
				contaOperacao = conta;
				contaOperacao.setSaldo(contaOperacao.getSaldo() - valor);
			}
		}

		if (contaOperacao.getSaldo() < valor) {
			throw new OperacaoException(valor);
		}

		contaRepository.save(contaOperacao);
	}

	// Depósito
	public void depositar(Integer numeroConta, float valor) throws ContaException {
		Conta contaOperacao = new Conta();
		for (Conta conta : listaDasContas()) {
			if (conta.getNumeroConta().equals(numeroConta)) {
				contaOperacao = conta;
				contaOperacao.setSaldo(contaOperacao.getSaldo() + valor);
			}
		}

		if (contaOperacao.getNumeroConta() == null) {
			throw new ContaException(numeroConta);
		}

		contaRepository.save(contaOperacao);
	}
}
