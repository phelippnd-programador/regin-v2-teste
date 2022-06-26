package br.com.pscs.reginprocessoservice.model.entity.pk_composta;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The primary key class for the tab_generica database table.
 * 
 */
@Data
@Embeddable
public class TabGenericaPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
//	@Id
	@Column(name = "TGE_TIP_TAB", updatable = false)
	private int tgeTipTab;
//	@Id
	@Column(name = "TGE_COD_TIP_TAB", updatable = false)
	private int tgeCodTipTab;

}