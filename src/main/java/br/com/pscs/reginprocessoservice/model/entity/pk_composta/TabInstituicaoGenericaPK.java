package br.com.pscs.reginprocessoservice.model.entity.pk_composta;

import java.io.Serializable;
import javax.persistence.*;

import br.com.pscs.reginprocessoservice.model.entity.TabGenerica;
import lombok.Data;

/**
 * The primary key class for the tab_instituicao_generica database table.
 * 
 */
@Data
@Embeddable
public class TabInstituicaoGenericaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TIG_TIN_CNPJ")
	private String tigTinCnpj;

	@Column(name="TIG_TGE_TIP_TAB")
	private Integer tigTgeTipTab;
    
	@Column(name="TIG_TGE_COD_TIP_TAB")
	private Integer tigTgeCodTipTab;
 
	
	@Column(name="TIG_TIPO")
	private Integer tigTipo;

}