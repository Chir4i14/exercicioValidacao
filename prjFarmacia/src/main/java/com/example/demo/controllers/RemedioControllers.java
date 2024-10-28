package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Remedio;
import com.example.demo.service.RemedioService;


@RestController
@RequestMapping("/Remedio")
public class RemedioControllers {
	
private final RemedioService remedioService;
	
	@Autowired
	public RemedioControllers(RemedioService remedioService) {
		this.remedioService = remedioService;
	}
	@PostMapping("/criar")
	public Remedio criarRemedio(@RequestBody Remedio remedio) {
		return remedioService.salvarRemedio(remedio);
	}
	@GetMapping
	public List<Remedio> buscarTodos(){
		return remedioService.buscarTodosRemedio();
	}
	@GetMapping("/{id}")
	public Remedio buscarPorId(@PathVariable Long id) {
		return remedioService.buscarRemedioPorId(id);
	}
	@DeleteMapping("/{id}")
	public void deletarRemedio(@PathVariable Long id) {
		remedioService.excluirRemedio(id);
	}
	@PutMapping
	public ResponseEntity<Remedio> atualizarRemedio(@PathVariable Long id,@RequestBody Remedio remedio) {
		Remedio remedioAtualizado = remedioService.atualizarRemedio(id, remedio);
		if(remedioAtualizado !=null) {
			return ResponseEntity.ok(remedioAtualizado);
		}
		else {
			return null;
		}
	}
}
