package br.com.pscs.reginprocessoservice.model.entity.embededid;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class RucEstabEmbeddedId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer resIdeEstab;

	private String resRgePraProtocolo;
}
