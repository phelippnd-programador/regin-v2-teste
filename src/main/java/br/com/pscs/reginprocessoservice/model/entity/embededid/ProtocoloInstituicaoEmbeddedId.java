package br.com.pscs.reginprocessoservice.model.entity.embededid;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ProtocoloInstituicaoEmbeddedId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String priPraProtocolo;
	private String priTinCnpj;
}
