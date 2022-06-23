package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.pscs.reginprocessoservice.model.entity.embededid.TabGenericaEmbeddedId;
import lombok.Data;

@Entity
@Data
@Table(name = "tab_generica")
public class TabGenericaEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private TabGenericaEmbeddedId id;
	private String tgeNombDesc;
}
