package br.com.pscs.reginprocessoservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoProtocolo {
	TIPO_PROTOCOLO_ALTERACAO_SEM_VALIDACAO(2,"Alteração sem validação da prefeitura",904,-1),
	TIPO_PROTOCOLO_ALVARA(3,"Pedido Alvará",904,1),
	TIPO_PROTOCOLO_VIABILIDADE(5,"Estudo de viabilidade",903,3),
	TIPO_PROTOCOLO_MEI(7,"Pedido de MEI",904,7),
	TIPO_PROTOCOLO_VIABILIDADE_MEI(8,"Estudo de viabilidade de MEI",903,8),
	TIPO_PROTOCOLO_VIABILIDADE_UNIDADE_DEPENDENTE(21,"Pedido de Unidade Dependente",904,3),
	TIPO_PROTOCOLO_PROCESSO_RFB(27,"Processos da RFB",904,1),
	TIPO_PROTOCOLO_ALTERACAO_MEI(28,"Alteração de MEI",904,-1),
	NULL(-1,"N/A",-1,-1)
	;
	
	private final Integer value;
	private final String descricao;
	private final Integer tipTab;
	private final Integer tipoArea;
}
