package br.com.pscs.reginprocessoservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pscs.reginprocessoservice.model.enums.TipoProtocolo;
import br.com.pscs.reginprocessoservice.repository.PscRegistraArquivoRepository;

@Service
public class PscRegistraArquivoService {
	@Autowired
	private PscRegistraArquivoRepository repository;

	public TipoProtocolo pesquisaTipoProtocolo(String numeroProcesso) {
		Integer tipoProtocolo = repository.findPraTipoProtocoloByPraProtocolo(numeroProcesso)
				.orElseThrow(() -> new RuntimeException("Protocolo não encontrado !"));
		return converterTipoProtocolo(tipoProtocolo).orElse(TipoProtocolo.NULL);
	}

	public Optional<TipoProtocolo> converterTipoProtocolo(Integer praTipoProtocolo) {
		List<TipoProtocolo> tipoProtocolo = Arrays.asList(TipoProtocolo.values()).stream()
				.filter(tipo -> tipo.getValue().compareTo(praTipoProtocolo) == 0).toList();
		return tipoProtocolo.size() > 0 ? Optional.of(tipoProtocolo.get(0)) : Optional.empty();
	}

	public String converterTipoProtocoloToDescricao(Integer praTipoProtocolo) {
		return converterTipoProtocolo(praTipoProtocolo).orElse(TipoProtocolo.NULL).getDescricao();

	}
}
