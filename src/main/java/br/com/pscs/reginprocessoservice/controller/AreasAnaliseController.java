package br.com.pscs.reginprocessoservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.pscs.reginprocessoservice.contract.ContractAnaliseProtocolo;
import br.com.pscs.reginprocessoservice.contract.ContractIdProtocoloInstituicao;
import br.com.pscs.reginprocessoservice.model.dto.AreaDto;
import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscProtocoloInstituicaoPK;
import br.com.pscs.reginprocessoservice.service.ProtocoloInstituicaoService;

@RestController
@RequestMapping("areasprocesso")
public class AreasAnaliseController {
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/cnpjInstituicao/{cnpjInstituicao}/processo/{numeroProcesso}")
	public boolean consultarAreas (@PathVariable String cnpjInstituicao ,@PathVariable String numeroProcesso) {
		return true;
	}
	@Autowired
	private ProtocoloInstituicaoService service;

	@GetMapping("/area_ativa/numeroProcesso/{numeroProcesso}/cnpjInstituicao/{cnpjInstituicao}/page/{page}/size/{size}")
	public Page<AreaDto> findAreaAtiva(@PathVariable String numeroProcesso, @PathVariable String cnpjInstituicao,
			@PathVariable Integer page, @PathVariable Integer size) {
		return service.carregaAreasAnaliseAtiva(numeroProcesso, cnpjInstituicao, page, size);
	}

	@GetMapping("/area_inativa/numeroProcesso/{numeroProcesso}/cnpjInstituicao/{cnpjInstituicao}")
	public List<AreaDto> findAreaInativa(@PathVariable String numeroProcesso, @PathVariable String cnpjInstituicao) {
		return service.carregaAreasAnaliseInativa(numeroProcesso, cnpjInstituicao)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NO_CONTENT));
	}

	@PatchMapping("/cnpjInstituicao/{cnpjInstituicao}/processo/{numeroProcesso}")
	public void analizarArea(@RequestBody @Valid ContractAnaliseProtocolo respostaArea,
			@PathVariable String cnpjInstituicao, @PathVariable String numeroProcesso) {
		service.analiseArea(cnpjInstituicao, numeroProcesso, respostaArea);
	}
	
	@PostMapping("/adicionaArea")
	public AreaDto adicionarArea (@Valid @RequestBody ContractIdProtocoloInstituicao area) {
		PscProtocoloInstituicaoPK id =modelMapper.map(area, PscProtocoloInstituicaoPK.class);
		return service.adicionaArea(id);
	}
}
