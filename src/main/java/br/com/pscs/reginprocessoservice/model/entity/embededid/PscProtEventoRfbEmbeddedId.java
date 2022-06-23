package br.com.pscs.reginprocessoservice.model.entity.embededid;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Embeddable
@Data

public class PscProtEventoRfbEmbeddedId implements Serializable{
	private String pevProProtocolo;
	private String pevCodEvento;
	private String pevNomeEvento;
}
