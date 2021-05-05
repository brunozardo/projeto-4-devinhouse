package br.com.backendprocessos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backendprocessos.exception.ProcessoException;
import br.com.backendprocessos.model.Processo;
import br.com.backendprocessos.repository.ProcessosRepository;


@Service
public class ProcessosService {

	@Autowired
	public ProcessosRepository processosRepository;

	public void editarProcesso(Integer id, Processo processo) {
		Optional<Processo> processoEncontrado = processosRepository.findById(id);
		
		processoEncontrado.ifPresentOrElse(c ->{
			if (processo.getNuProcesso() != null) {
				c.setNuProcesso(processo.getNuProcesso());
				processosRepository.save(c);
			}
			if (processo.getChaveProcesso() != null) {
				c.setChaveProcesso(processo.getChaveProcesso());
				processosRepository.save(c);
			}
			if (processo.getSgOrgaoProcesso() != null) {
				c.setSgOrgaoProcesso(processo.getSgOrgaoProcesso());
				processosRepository.save(c);
			}
			if (processo.getNuAnoProcesso() != null) {
				c.setNuAnoProcesso(processo.getNuAnoProcesso());
				processosRepository.save(c);
			}
			if (processo.getDescricao() != null) {
				c.setDescricao(processo.getDescricao());
				processosRepository.save(c);
			}
			if (processo.getCdAssunto() != null) {
				c.setCdAssunto(processo.getCdAssunto());
				processosRepository.save(c);
			}
			if (processo.getDescricaoAssunto() != null) {
				c.setDescricaoAssunto(processo.getDescricaoAssunto());
				processosRepository.save(c);
			}
			if (processo.getCdInteressado() != null) {
				c.setCdInteressado(processo.getCdInteressado());
				processosRepository.save(c);
			}
			if (processo.getNmInteressado() != null) {
				c.setNmInteressado(processo.getNmInteressado());
				processosRepository.save(c);
			}
		}, () -> { throw new ProcessoException("Processo não encontrado!");});
	
	}

	public void deletarProcesso(Integer id) {
		Optional <Processo> processoEncontrado = processosRepository.findById(id);
		
		processoEncontrado.ifPresentOrElse(c -> {
			processosRepository.delete(c);
		}, () -> { throw new ProcessoException("Processo não encontrado!"); });
		
	}
}
