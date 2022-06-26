package br.com.pscs.reginprocessoservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusAreaAnalise {
	APROVADO(2),PENDENTE(3),REPROVADO(4),NAO_INFORMADO(1);
	private final Integer value;
}
