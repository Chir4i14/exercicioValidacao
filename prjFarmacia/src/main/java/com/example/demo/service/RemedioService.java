package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Remedio;
import com.example.demo.repository.RemedioRepository;

@Service
public class RemedioService {
	
	private final RemedioRepository remedioRepository;

	@Autowired
	public RemedioService(RemedioRepository remedioRepository) {
		this.remedioRepository = remedioRepository;
	}
	
	public Remedio salvarRemedio(Remedio remedio) {
		return remedioRepository.save(remedio);
	}

	public void excluirRemedio(Long id) {
		remedioRepository.deleteById(id);
	}
	public Remedio atualizarRemedio(Long id, Remedio remedioAtualizado) {
		Optional<Remedio> remedioExistente = remedioRepository.findById(id);
		if (remedioExistente.isPresent()) {
			Remedio remedio = remedioExistente.get();
			remedio.setNome(remedioAtualizado.getNome());
			remedio.setBula(remedioAtualizado.getBula());
			remedio.setIdFornecedor(remedioAtualizado.getIdFornecedor());
			remedio.setDataValidade(remedioAtualizado.getDataValidade());
			return remedioRepository.save(remedio);
		} else {
			return null;
		}
	}
	
	public List<Remedio> buscarTodosRemedio() {
		return remedioRepository.findAll();
	}
	public Remedio buscarRemedioPorId(Long id) {
		return remedioRepository.findById(id).orElse(null);
	}
}
