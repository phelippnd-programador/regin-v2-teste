package br.com.pscs.reginprocessoservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusProcesso {
	ESPECIAL(0),
	NOVO(2),
	EM_ANDAMENTO(3),
	FINALIZADO(4),
	CANCELADO(8),
	FINALIZADO_AGUARDADNO_LICENCA_PAGAMENTO(10),
	DIVISA_VISA(11);
	private final Integer value;
	
}
