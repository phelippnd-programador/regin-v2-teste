package br.com.pscs.reginprocessoservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.pscs.reginprocessoservice.model.entity.TabInstituicaoGenerica;
import br.com.pscs.reginprocessoservice.model.enums.TipoProtocolo;
import br.com.pscs.reginprocessoservice.repository.TabInstituicaoGenericaRepository;

@Service
public class TabInstituicaoGenericaService {
	@Autowired
	private TabInstituicaoGenericaRepository repository;

	public List<TabInstituicaoGenerica> areasDesativadas(List<Integer> codTipTabAtivas, TipoProtocolo tipoProtocolo,
			String cnpjInstituicao) {
//		return repository.findAll();
		if(tipoProtocolo.getTipoArea()>0) {
		 return repository.findAreasExetoCodTipTabs(codTipTabAtivas,
				Arrays.asList(1,3),
				tipoProtocolo.getTipoArea(),
				tipoProtocolo.getTipTab(),
				cnpjInstituicao).orElseThrow(()-> new ResponseStatusException(HttpStatus.NO_CONTENT));
		}
		throw new RuntimeException("Processo não possui areas vinculadas");
	}
	/**
	 * Retorna verdadeiro quando existe area ativa na prefeitura
	 * @param codTipTab
	 * @param tigTgeTipTab
	 * @param cnpjInstituicao
	 * @param tipoArea
	 * @return
	 */
	public boolean existAtivo(Integer codTipTab,Integer tigTgeTipTab, String cnpjInstituicao,Integer tipoArea) {
		return repository.existAtivo(codTipTab, tigTgeTipTab, cnpjInstituicao, tipoArea).isPresent();
	}

}
