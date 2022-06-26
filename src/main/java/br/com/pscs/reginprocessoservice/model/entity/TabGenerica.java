package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.pscs.reginprocessoservice.model.entity.pk_composta.TabGenericaPK;
import lombok.Data;


/**
 * The persistent class for the tab_generica database table.
 * 
 */
@Entity
@Table(name="tab_generica")
@Data
public class TabGenerica implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TabGenericaPK id;

	@Column(name="TGE_NOMB_DESC")
	private String tgeNombDesc;

	

}