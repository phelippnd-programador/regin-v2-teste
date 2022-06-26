package br.com.pscs.reginprocessoservice.model.entity.pk_composta;

import java.io.Serializable;
import javax.persistence.*;

import br.com.pscs.reginprocessoservice.model.entity.TabGenerica;
import lombok.Data;

/**
 * The primary key class for the psc_protocolo_instituicao_copy database table.
 * 
 */
@Data
@Embeddable
public class PscProtocoloInstituicaoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="PPI_PRO_PROTOCOLO")
	private String ppiProProtocolo;

	@Column(name="PPI_TIG_TIN_CNPJ")
	private String ppiTigTinCnpj;

	@Column(name="PPI_TIG_TGE_TIP_TAB" , updatable = false,insertable = false)
	private Integer ppiTigTgeTipTab;

	@Column(name="PPI_TIG_TGE_COD_TIP_TAB", updatable = false,insertable = false)
	private Integer ppiTigTgeCodTipTab;
	
	
}