package br.com.pscs.reginprocessoservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("solicitar")
public class SolicitacaoController {
//	@Autowired
//	private SolicitacaoService service;
//	@PostMapping("/documento/processo/{numeroProcesso}/cnpjInstituicao/{cnpjInstituicao}/responsavel/{cpfResponsavel}")
//	public void solicitarDocumento(@RequestBody String texto,@PathVariable String cnpjInstituicao,@PathVariable String numeroProcesso) {
//		service.solicitarDocumento(texto,cnpjInstituicao,numeroProcesso);
//	}
//	
//	//Trocar para Api de documentos
//	@GetMapping("/documento/processo/{numeroProcesso}/cnpjInstituicao/{cnpjInstituicao}/responsavel/{cpfResponsavel}/size/{size}/page/{page}")
//	public boolean pesquisarDocumento(@PathVariable String cnpjInstituicao,@PathVariable String numeroProcesso,@PathVariable String size,@PathVariable String page) {
//		return true;
//	}
}
