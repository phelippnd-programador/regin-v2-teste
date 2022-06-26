package br.com.pscs.reginprocessoservice.model.entity.pk_composta;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the psc_prot_evento_rfb database table.
 * 
 */
@Embeddable
public class PscProtEventoRfbPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PEV_PRO_PROTOCOLO")
	private String pevProProtocolo;

	@Column(name="PEV_COD_EVENTO")
	private int pevCodEvento;

	public PscProtEventoRfbPK() {
	}
	public String getPevProProtocolo() {
		return this.pevProProtocolo;
	}
	public void setPevProProtocolo(String pevProProtocolo) {
		this.pevProProtocolo = pevProProtocolo;
	}
	public int getPevCodEvento() {
		return this.pevCodEvento;
	}
	public void setPevCodEvento(int pevCodEvento) {
		this.pevCodEvento = pevCodEvento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PscProtEventoRfbPK)) {
			return false;
		}
		PscProtEventoRfbPK castOther = (PscProtEventoRfbPK)other;
		return 
			this.pevProProtocolo.equals(castOther.pevProProtocolo)
			&& (this.pevCodEvento == castOther.pevCodEvento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pevProProtocolo.hashCode();
		hash = hash * prime + this.pevCodEvento;
		
		return hash;
	}
}