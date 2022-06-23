package br.com.pscs.reginprocessoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pscs.contracts.api_processo.ContractFiltroProcesso;
import br.com.pscs.reginprocessoservice.model.dto.ProcessoDto;
import br.com.pscs.reginprocessoservice.service.ProcessoService;

@RequestMapping("processo")
@RestController
public class ProcessoController {
	@Autowired
	private ProcessoService service;
	/**
	 * End-point aonde será usado para enviar o processo para a junta ou prefeituras 
	 * @param numeroProcesso
	 * @param cnpjInstituicao
	 * @return
	 */
	@GetMapping("{numeroProcesso}/cnpjInstituicao/{cnpjInstituicao}")
	public boolean retornaProcesso(@PathVariable String numeroProcesso,@PathVariable String cnpjInstituicao) {
		service.retornarProcessoParaAJunta();
		return true;
	}
	
	@GetMapping("/pesquisar/cnpjInstituicao/{cnpjInstituicao}/size/{size}/page/{page}")
	public Page<ProcessoDto> listarProcessoPorInstituicao(@PathVariable String cnpjInstituicao, @PathVariable Integer page, @PathVariable Integer size) {
		ContractFiltroProcesso filter = new ContractFiltroProcesso();
		filter.setIdCnpjInstituicao(cnpjInstituicao);
		return filtraProcesso(filter,page,size);
	}
	@PostMapping("/pesquisar/size/{size}/page/{page}")
	public Page<ProcessoDto> filtraProcesso(@RequestBody ContractFiltroProcesso filter, @PathVariable Integer page,@PathVariable Integer size) {
		return service.listarProcesso(filter,page,size);
	}
	@PostMapping("/cnpjInstituicao/{cnpjInstituicao}")
	public boolean registraProcesso(@PathVariable String cnpj, @RequestBody Object processo) {
		return true;
	}
	@PatchMapping("/{numeroProcesso}/cnpjInstituicao/{cnpjInstituicao}")
	public void finalizarProcesso( @RequestBody Object dadosFinalizaProcesso , @PathVariable String numeroProcesso , @PathVariable String cnpjInstituicao ) {
		 service.finalizarProcesso(cnpjInstituicao, numeroProcesso, dadosFinalizaProcesso);
	}
	
}
