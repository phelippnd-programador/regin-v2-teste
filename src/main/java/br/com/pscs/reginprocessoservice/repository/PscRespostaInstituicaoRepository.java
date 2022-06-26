package br.com.pscs.reginprocessoservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pscs.reginprocessoservice.model.entity.PscRespostaInstituicao;
import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscRespostaInstituicaoPK;

@Repository
public interface PscRespostaInstituicaoRepository extends JpaRepository<PscRespostaInstituicao, PscRespostaInstituicaoPK>{
	 
}
