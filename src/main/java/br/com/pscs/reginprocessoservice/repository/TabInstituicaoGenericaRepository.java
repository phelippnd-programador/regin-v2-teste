package br.com.pscs.reginprocessoservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pscs.reginprocessoservice.model.entity.TabInstituicaoGenerica;
import br.com.pscs.reginprocessoservice.model.entity.pk_composta.TabInstituicaoGenericaPK;

@Repository
public interface TabInstituicaoGenericaRepository
		extends JpaRepository<TabInstituicaoGenerica, TabInstituicaoGenericaPK> {
	@Query("Select tig from TabInstituicaoGenerica tig " + "where 1=1 "
			+ "and tig.id.tigTgeCodTipTab not in :codTipTabAtivas " 
			+ "and tig.id.tigTinCnpj = :cnpjInstituicao "
			+ "and tig.id.tigTipo = :tipoArea " 
			+ "and tig.id.tigTgeTipTab = :tigTgeTipTab "
			+ "and tig.tigTipPesquisa in :tipoPesquisas")
	Optional<List<TabInstituicaoGenerica>> findAreasExetoCodTipTabs(List<Integer> codTipTabAtivas,
			List<Integer> tipoPesquisas, Integer tipoArea, Integer tigTgeTipTab, String cnpjInstituicao);
	
	@Query("Select tig from TabInstituicaoGenerica tig " + "where 1=1 "
			+ "and tig.id.tigTgeCodTipTab = :codTipTab " 
			+ "and tig.id.tigTgeTipTab = :tigTgeTipTab "
			+ "and tig.id.tigTinCnpj = :cnpjInstituicao "
			+ "and tig.id.tigTipo = :tipoArea " 
			+ "and tig.tigTipPesquisa in (1,3)")
	Optional<TabInstituicaoGenerica> existAtivo(Integer codTipTab,Integer tigTgeTipTab, String cnpjInstituicao,Integer tipoArea);

}
