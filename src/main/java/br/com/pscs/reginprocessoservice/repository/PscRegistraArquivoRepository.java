package br.com.pscs.reginprocessoservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pscs.reginprocessoservice.model.entity.PscRegistraArquivo;

@Repository
public interface PscRegistraArquivoRepository extends JpaRepository<PscRegistraArquivo, String> {
	@Query("Select pra.praTipoProtocolo from PscRegistraArquivo pra where pra.praProtocolo = :numeroProcesso ")
	Optional<Integer> findPraTipoProtocoloByPraProtocolo(String numeroProcesso);

}
