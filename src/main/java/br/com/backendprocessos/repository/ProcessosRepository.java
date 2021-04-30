package br.com.backendprocessos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.backendprocessos.model.Processo;

@Repository
public interface ProcessosRepository extends JpaRepository<Processo, Integer> {

	Optional<Processo> findById(Integer id);
	Optional<Processo> findByNuProcesso(Integer numero);

}
