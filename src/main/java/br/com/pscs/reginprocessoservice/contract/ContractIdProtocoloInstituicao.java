package br.com.pscs.reginprocessoservice.contract;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ContractIdProtocoloInstituicao implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank(message = "Numero de processo não pode ficar em branco")
	@NotNull
	@JsonProperty("numeroProcesso")
	private String ppiProProtocolo;
	@NotNull
	@NotBlank(message = "Numero do cnpj não pode ficar em branco")
	@JsonProperty("cnpjInstituicao")
	private String ppiTigTinCnpj;
	@NotNull
	@JsonProperty("tipoTabela")
	private Integer ppiTigTgeTipTab;
	@NotNull
	@JsonProperty("codigoTipoTabela")
	private Integer ppiTigTgeCodTipTab;
}
