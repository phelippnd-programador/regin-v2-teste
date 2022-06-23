package br.com.pscs.reginprocessoservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pscs.contracts.api_processo.ContractRespostaArea;
import br.com.pscs.reginprocessoservice.service.AnaliseService;

@RestController
@RequestMapping("analisar")
public class AnaliseController {
	@Autowired
	private AnaliseService analiseService;

	@PatchMapping("/cnpjInstituicao/{cnpjInstituicao}/processo/{numeroProcesso}")
	public void analizarArea(@RequestBody @Valid ContractRespostaArea respostaArea, @PathVariable String cnpjInstituicao,
			@PathVariable String numeroProcesso) {
		analiseService.analizarArea(respostaArea);
		
	}
}
