package br.com.backendprocessos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.backendprocessos.exception.ProcessoException;
import br.com.backendprocessos.model.Processo;
import br.com.backendprocessos.repository.ProcessosRepository;
import br.com.backendprocessos.service.ProcessosService;

@RestController
@RequestMapping("/api/processos")
public class ProcessosController {

	
	@Autowired
	private ProcessosRepository processosRepository;
	
	@Autowired
	private ProcessosService processosService;
	
	@GetMapping()
	public List<Processo> listar() {
		return processosRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Processo> listarProcessoUnicoPeloId(@PathVariable (value ="id")Integer id) {
		return processosRepository.findById(id);
	}
	
	@GetMapping(path = "/numero-processo/{nuProcesso}")
	public Optional<Processo> listarProcessoUnicoPeloNumero(@PathVariable (value ="nuProcesso")Integer nuProcesso) {
		return processosRepository.findByNuProcesso(nuProcesso);
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Processo adicionar(@RequestBody Processo processo) {
		return processosRepository.save(processo);
	}
	
	@PutMapping(path = "/{id}")
	public Processo editarProcesso(@PathVariable (value = "id")Integer id, @RequestBody Processo processo){
		try {
			processosService.editarProcesso(id,processo);
			
		}
		catch(ProcessoException e){
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, e.getMessage());
		}
		return processo;
		
	}
	@DeleteMapping(path = "/{id}")
	public void deletarProcesso(@PathVariable (value = "id") Integer id){
		try {
			processosService.deletarProcesso(id);
		}
		catch (ProcessoException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
