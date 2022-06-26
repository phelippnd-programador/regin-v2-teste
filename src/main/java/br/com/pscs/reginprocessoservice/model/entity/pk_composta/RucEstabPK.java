package br.com.pscs.reginprocessoservice.model.entity.pk_composta;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ruc_estab database table.
 * 
 */
@Embeddable
public class RucEstabPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="RES_RGE_PRA_PROTOCOLO")
	private String resRgePraProtocolo;

	@Column(name="RES_IDE_ESTAB")
	private long resIdeEstab;

	public RucEstabPK() {
	}
	public String getResRgePraProtocolo() {
		return this.resRgePraProtocolo;
	}
	public void setResRgePraProtocolo(String resRgePraProtocolo) {
		this.resRgePraProtocolo = resRgePraProtocolo;
	}
	public long getResIdeEstab() {
		return this.resIdeEstab;
	}
	public void setResIdeEstab(long resIdeEstab) {
		this.resIdeEstab = resIdeEstab;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RucEstabPK)) {
			return false;
		}
		RucEstabPK castOther = (RucEstabPK)other;
		return 
			this.resRgePraProtocolo.equals(castOther.resRgePraProtocolo)
			&& (this.resIdeEstab == castOther.resIdeEstab);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.resRgePraProtocolo.hashCode();
		hash = hash * prime + ((int) (this.resIdeEstab ^ (this.resIdeEstab >>> 32)));
		
		return hash;
	}
}