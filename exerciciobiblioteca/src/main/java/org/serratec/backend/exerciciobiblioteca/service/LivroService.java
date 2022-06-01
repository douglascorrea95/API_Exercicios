package org.serratec.backend.exerciciobiblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.exerciciobiblioteca.DTO.LivroDTO;
import org.serratec.backend.exerciciobiblioteca.exception.BibliotecaException;
import org.serratec.backend.exerciciobiblioteca.model.Livro;
import org.serratec.backend.exerciciobiblioteca.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	BibliotecaRepository bibliotecaRepository;

	// Transformar Model em LivroDTO
	public LivroDTO transformarModelEmDTO(Livro livro, LivroDTO livroDTO) {

		livroDTO.setIdLivro(livro.getIdLivro());
		livroDTO.setTituloLivro(livro.getTituloLivro());
		livroDTO.setTipoLivro(livro.getTipoLivro());
		livroDTO.setAutor(livro.getAutor());
		livroDTO.setDataDaPublicacao(livro.getDataDaPublicacao());

		return livroDTO;
	}

	// Transformar LivroDTO em Model
	public Livro transformarDTOEmModel(Livro livro, LivroDTO livroDTO) {

		livro.setTituloLivro(livroDTO.getTituloLivro());
		livro.setTipoLivro(livroDTO.getTipoLivro());
		livro.setAutor(livroDTO.getAutor());
		livro.setDataDaPublicacao(livroDTO.getDataDaPublicacao());

		return livro;
	}

	// Salvar Livro
	public String salvar(LivroDTO livroDTO) {
		Livro livro = new Livro();
		transformarDTOEmModel(livro, livroDTO);
		bibliotecaRepository.save(livro);

		return "Id do livro criado:  " + livro.getIdLivro();

	}

	// Buscar por ID
	public LivroDTO buscarPorId(Integer idLivro) throws BibliotecaException {
		Optional<Livro> livro = bibliotecaRepository.findById(idLivro);
		Livro livroNoBanco = new Livro();
		LivroDTO livroDTO = new LivroDTO();
		if (livro.isPresent()) {
			livroNoBanco = livro.get();
			transformarModelEmDTO(livroNoBanco, livroDTO);
			return livroDTO;
		}
		throw new BibliotecaException("Livro com o id informado não encontrado");
	}

	// Delete
	public void deletar(Integer idLivro) {
		bibliotecaRepository.deleteById(idLivro);
	}

	// Atualizar
	public String atualizar(Integer idLivro, LivroDTO livroDTO) throws BibliotecaException {
		Optional<Livro> livro = bibliotecaRepository.findById(idLivro);
		Livro livroBanco = new Livro();
		if (livro.isPresent()) {
			livroBanco = livro.get();

			if (livroDTO.getTituloLivro() != null) {
				livroBanco.setTituloLivro(livroDTO.getTituloLivro());
			}
			if (livroDTO.getTipoLivro() != null) {
				livroBanco.setTipoLivro(livroDTO.getTipoLivro());
			}
			if (livroDTO.getAutor() != null) {
				livroBanco.setAutor(livroDTO.getAutor());
			}
			if (livroDTO.getDataDaPublicacao() != null) {
				livroBanco.setDataDaPublicacao(livroDTO.getDataDaPublicacao());
			}
			bibliotecaRepository.save(livroBanco);
			return "O livro com id: " + livroBanco.getIdLivro() + " foi atualizado";
		}
		return "O livro não foi atualizado";
	}

	// Buscar Todos
	public List<LivroDTO> buscarLivros() {
		List<Livro> listaLivroModel = bibliotecaRepository.findAll();
		List<LivroDTO> listaLivroDTO = new ArrayList<>();

		for (Livro livro : listaLivroModel) {
			LivroDTO livroDTO = new LivroDTO();
			transformarModelEmDTO(livro, livroDTO);
			listaLivroDTO.add(livroDTO);
		}
		return listaLivroDTO;
	}

	// Salvar Varios Livros
	public void salvarListaLivros(List<LivroDTO> listaLivroDTO) {
		List<Livro> listaLivro = new ArrayList<>();

		for (LivroDTO livroDTO : listaLivroDTO) {
			Livro livro = new Livro();
			transformarDTOEmModel(livro, livroDTO);
			listaLivro.add(livro);
		}
		bibliotecaRepository.saveAll(listaLivro);
	}
	
	public List<LivroDTO> listaOrdenada(String ordem) throws BibliotecaException{
		List<Livro> listaModel = new ArrayList<>();
		List<LivroDTO> listaDTO = new ArrayList<>();
		
		String nomeAtributo = null; 
		
		switch (ordem) { 
		
		case "titulo" :
			nomeAtributo = "tituloLivro";
		break;
		
		case "autor":
			nomeAtributo = "autor";
		break;
		
		case "tipo":
			nomeAtributo = "tipoLivro";
		break;
		
		case "data":
			nomeAtributo = "dataDaPublicacao";
		break;
		
		default:
			throw new BibliotecaException("Parâmetro não aceito. Os parâmetros aceitos são: titulo, autor, categoria, data.");
			
		}
			
		
		listaModel = bibliotecaRepository.findAll(Sort.by(Order.by(nomeAtributo)));

		
		for (Livro livroModel : listaModel) {
			LivroDTO livroDTO = new LivroDTO();
			transformarModelEmDTO(livroModel, livroDTO);
			listaDTO.add(livroDTO);
		}		
		
		return listaDTO;		
	}
}
