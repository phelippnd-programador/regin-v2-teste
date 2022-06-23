package br.com.pscs.reginprocessoservice.model.entity.embededid;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class TabGenericaEmbeddedId implements Serializable {
	private String tieProtocolo;

	/** The tie tipo relacao. */
	private Integer tieTipoRelacao;

	/** The tie cpf cnpj. */
	private String tieCpfCnpj;
}
