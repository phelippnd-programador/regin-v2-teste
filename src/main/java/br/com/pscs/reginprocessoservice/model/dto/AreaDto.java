package br.com.pscs.reginprocessoservice.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscProtocoloInstituicaoPK;
import br.com.pscs.reginprocessoservice.model.enums.StatusAreaAnalise;
import lombok.Data;
@Data
public class AreaDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private PscProtocoloInstituicaoPK id;
	@JsonProperty("descricao")
	private String ppiDescPesquisa;
	@JsonProperty("status")
	private StatusAreaAnalise status;
	@JsonProperty("titulo")
	private String tabGenericaTgeNombDesc;

}
