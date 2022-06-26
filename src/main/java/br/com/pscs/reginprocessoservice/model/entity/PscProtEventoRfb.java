package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscProtEventoRfbPK;


/**
 * The persistent class for the psc_prot_evento_rfb database table.
 * 
 */
@Entity
@Table(name="psc_prot_evento_rfb")
@NamedQuery(name="PscProtEventoRfb.findAll", query="SELECT p FROM PscProtEventoRfb p")
public class PscProtEventoRfb implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PscProtEventoRfbPK id;

	@Column(name="PEV_NOME_EVENTO")
	private String pevNomeEvento;

	public PscProtEventoRfb() {
	}

	public PscProtEventoRfbPK getId() {
		return this.id;
	}

	public void setId(PscProtEventoRfbPK id) {
		this.id = id;
	}

	public String getPevNomeEvento() {
		return this.pevNomeEvento;
	}

	public void setPevNomeEvento(String pevNomeEvento) {
		this.pevNomeEvento = pevNomeEvento;
	}

}