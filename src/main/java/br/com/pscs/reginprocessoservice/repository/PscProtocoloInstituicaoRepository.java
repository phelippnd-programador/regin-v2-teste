package br.com.pscs.reginprocessoservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pscs.reginprocessoservice.model.entity.PscProtocoloInstituicao;
import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscProtocoloInstituicaoPK;

@Repository
public interface PscProtocoloInstituicaoRepository extends JpaRepository<PscProtocoloInstituicao, PscProtocoloInstituicaoPK>{
	@Query(value = "Select ppi from PscProtocoloInstituicao ppi "
			+ "join TabGenerica tg on (ppi.id.ppiTigTgeTipTab = tg.id.tgeTipTab and ppi.id.ppiTigTgeCodTipTab = tg.id.tgeCodTipTab )"
			+ "where "
			+ "ppi.id.ppiProProtocolo = :numeroProcesso and ppi.id.ppiTigTinCnpj = :cnpjInstituicao"
			)
	public Page<PscProtocoloInstituicao> findByNumeroProcessoAndCnpjInstituicao(String numeroProcesso,String cnpjInstituicao,Pageable pageable);
	@Query(value = "Select ppi from PscProtocoloInstituicao ppi "
			+ "join TabGenerica tg on (ppi.id.ppiTigTgeTipTab = tg.id.tgeTipTab and ppi.id.ppiTigTgeCodTipTab = tg.id.tgeCodTipTab )"
			+ "where "
			+ "ppi.id.ppiProProtocolo = :numeroProcesso and ppi.id.ppiTigTinCnpj = :cnpjInstituicao"
			)
	public Optional< List<PscProtocoloInstituicao> >findByNumeroProcessoAndCnpjInstituicao(String numeroProcesso,String cnpjInstituicao);

}
