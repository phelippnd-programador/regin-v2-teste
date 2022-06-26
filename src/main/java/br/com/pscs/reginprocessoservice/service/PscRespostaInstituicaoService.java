package br.com.pscs.reginprocessoservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pscs.reginprocessoservice.model.entity.PscRespostaInstituicao;
import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscRespostaInstituicaoPK;
import static br.com.pscs.reginprocessoservice.model.enums.StatusProcesso.*;
import br.com.pscs.reginprocessoservice.repository.PscRespostaInstituicaoRepository;

@Service
public class PscRespostaInstituicaoService {
	@Autowired
	private PscRespostaInstituicaoRepository repository;
	public boolean isFinalizado(String cnpjInstituicao, String numeroProcesso) {
		PscRespostaInstituicaoPK id = new PscRespostaInstituicaoPK();
		id.setPriTinCnpj(cnpjInstituicao);
		id.setPriPraProtocolo(numeroProcesso);
		return isFinalizado(id);
	}
	public boolean isFinalizado(PscRespostaInstituicaoPK id) {
		PscRespostaInstituicao respostaInstituicao = repository.findById(id).orElseThrow(()->new RuntimeException("Processo não encontrado !"));
		return (respostaInstituicao.getPriStatus().compareTo(FINALIZADO.getValue()) == 0 ||
				respostaInstituicao.getPriStatus().compareTo(FINALIZADO_AGUARDADNO_LICENCA_PAGAMENTO.getValue()) == 0 );
		
	}

}
