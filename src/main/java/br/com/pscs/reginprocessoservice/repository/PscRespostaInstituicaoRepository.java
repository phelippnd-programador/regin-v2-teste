package br.com.pscs.reginprocessoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pscs.reginprocessoservice.model.entity.PscProtocoloInstituicaoEntity;
import br.com.pscs.reginprocessoservice.model.entity.PscRespostaInstituicaoEntity;
import br.com.pscs.reginprocessoservice.model.entity.embededid.RespostaInstituicaoEmbeddedId;

@Repository
public interface PscRespostaInstituicaoRepository extends JpaRepository<PscRespostaInstituicaoEntity, RespostaInstituicaoEmbeddedId>{

}
