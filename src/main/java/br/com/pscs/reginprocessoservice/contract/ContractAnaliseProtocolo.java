package br.com.pscs.reginprocessoservice.contract;

import java.io.Serializable;

import br.com.pscs.reginprocessoservice.model.enums.StatusAreaAnalise;
import lombok.Data;

@Data
public class ContractAnaliseProtocolo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ppiTigTgeTipTab;
	private Integer ppiTigTgeCodTipTab;
	private String descricao;
	private StatusAreaAnalise status;
	private String cpfResposnsavel;
}
