package br.com.pscs.reginprocessoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("areasprocesso")
public class AreasAnaliseController {
	@GetMapping("/cnpjInstituicao/{cnpjInstituicao}/processo/{numeroProcesso}")
	public boolean consultarAreas (@PathVariable String cnpjInstituicao ,@PathVariable String numeroProcesso) {
		return true;
	}
	@PutMapping
	public boolean adicionarArea (@RequestBody Object area) {
		return true;
	}
}
