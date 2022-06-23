package br.com.pscs.reginprocessoservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoProtocolo {
	TIPO_PROTOCOLO_ALVARA(3,""),
	TIPO_PROTOCOLO_VIABILIDADE(5,""),
	TIPO_PROTOCOLO_VIABILIDADE_UNIDADE_DEPENDENTE(21,""),
	TIPO_PROTOCOLO_MEI(7,""),
	TIPO_PROTOCOLO_VIABILIDADE_MEI(8,""),
	TIPO_PROTOCOLO_ALTERACAO_MEI(28,""),
	TIPO_PROTOCOLO_ALTERACAO_SEM_VALIDACAO(2,""),
	TIPO_PROTOCOLO_PROCESSO_RFB(27,"");
	
	private final Integer value;
	private final String descricao;
}
