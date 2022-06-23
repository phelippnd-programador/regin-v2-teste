package br.com.pscs.reginprocessoservice.model.dto;

import java.util.List;

import lombok.Data;
@Data
public class AtividadeExercidaDto {
	private String regraUtilizada;
	private ClassificaoAtividadeEconomicaDto atividadePrincipal;
	private List<ClassificaoAtividadeEconomicaDto> atividadeSecundarias;
}
