package br.com.pscs.reginprocessoservice.model.entity.embededid;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class TabTipoUnidadeEmbeddedId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ttu_id;
	private String ttu_codigo;
}
