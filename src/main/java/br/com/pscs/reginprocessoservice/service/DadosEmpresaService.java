package br.com.pscs.reginprocessoservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pscs.reginprocessoservice.model.dto.EnderecoDto;
import br.com.pscs.reginprocessoservice.model.entity.RucComp;
import br.com.pscs.reginprocessoservice.model.entity.RucEstab;
import br.com.pscs.reginprocessoservice.model.entity.TabInformExtraJunta;

@Service
public class DadosEmpresaService {
	private RucEstab rucEstabEntity;
	private RucComp rucComp;
	public EnderecoDto carregaEndereco(String protocolo) {
		return EnderecoDto.builder()
			.cep(rucComp.getRcoZonaPostal())
			.numero(rucComp.getRcoNume())
			.bairro(rucComp.getRcoUrbanizacion())
			.estado(rucComp.getRcoRucExtUf())
			.referencia(rucComp.getRcoRefer())
			.logradouro(rucComp.getRcoDireccion())
		.build();
	}
	public List<String> telefoneEmpresa(String protocolo) {
		TabInformExtraJunta tabInformExtraJunta = null; 
		List<String> numerosTelefones = new ArrayList<String>();
		numerosTelefones.add(
				String.format("( %s ) %s ", tabInformExtraJunta.getTieDddFone1(), tabInformExtraJunta.getTieFone1()));
		numerosTelefones.add(
				String.format("( %s ) %s ", tabInformExtraJunta.getTieDddFone2(), tabInformExtraJunta.getTieFone2()));
		return numerosTelefones;
	}
}
