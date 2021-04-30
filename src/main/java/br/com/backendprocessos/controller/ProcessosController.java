package br.com.backendprocessos.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.backendprocessos.model.Processo;
import br.com.backendprocessos.repository.ProcessosRepository;

@RestController
@RequestMapping("/api")
public class ProcessosController {

	
	@Autowired
	private ProcessosRepository processosRepository;
	
	@GetMapping(path = "/processos")
	public List<Processo> listar() {
		return processosRepository.findAll();
	}
	
	@GetMapping(path = "/processo/{id}")
	public Optional<Processo> listarProcessoUnicoPeloId(@PathVariable (value ="id")Integer id) {
		return processosRepository.findById(id);
	}
	
	@GetMapping(path = "/processo/numero-processo/{nuProcesso}")
	public Optional<Processo> listarProcessoUnicoPeloNumero(@PathVariable (value ="nuProcesso")Integer nuProcesso) {
		return processosRepository.findByNuProcesso(nuProcesso);
	}

	@PostMapping(path = "/adicionar-processo")
	@ResponseStatus(HttpStatus.CREATED)
	public Processo adicionar(@RequestBody Processo processo) {
		return processosRepository.save(processo);
	}
}
