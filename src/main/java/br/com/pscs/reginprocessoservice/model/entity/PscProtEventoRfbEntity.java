package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.pscs.reginprocessoservice.model.entity.embededid.PscProtEventoRfbEmbeddedId;
import lombok.Data;

@Data
@Entity
@Table(name = "psc_prot_evento_rfb")
/**
 * Responsavel para informar o tipo de evento do protocolo
 * @author pdama
 *
 */
public class PscProtEventoRfbEntity implements Serializable {
	@EmbeddedId
	private PscProtEventoRfbEmbeddedId id;
	private String pevNomeEvento;
}
