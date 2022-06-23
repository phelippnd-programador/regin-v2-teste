package br.com.pscs.reginprocessoservice.model.entity.embededid;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class TabInformExtraJuntaEmbeddedId implements Serializable {
	/** The tge tip tab. */
	private Integer tgeTipTab;

	/** The tge cod tip tab. */
	private Integer tgeCodTipTab;
}
