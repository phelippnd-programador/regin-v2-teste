package br.com.pscs.reginprocessoservice.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClassificaoAtividadeEconomicaDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String cnae;
	private String descricao;
	private String classificao;
}
