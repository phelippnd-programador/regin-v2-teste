package br.com.pscs.reginprocessoservice.model.entity.pk_composta;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tab_inform_extra_junta database table.
 * 
 */
@Embeddable
public class TabInformExtraJuntaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TIE_PROTOCOLO")
	private String tieProtocolo;

	@Column(name="TIE_TIPO_RELACAO")
	private int tieTipoRelacao;

	@Column(name="TIE_CPF_CNPJ")
	private String tieCpfCnpj;

	public TabInformExtraJuntaPK() {
	}
	public String getTieProtocolo() {
		return this.tieProtocolo;
	}
	public void setTieProtocolo(String tieProtocolo) {
		this.tieProtocolo = tieProtocolo;
	}
	public int getTieTipoRelacao() {
		return this.tieTipoRelacao;
	}
	public void setTieTipoRelacao(int tieTipoRelacao) {
		this.tieTipoRelacao = tieTipoRelacao;
	}
	public String getTieCpfCnpj() {
		return this.tieCpfCnpj;
	}
	public void setTieCpfCnpj(String tieCpfCnpj) {
		this.tieCpfCnpj = tieCpfCnpj;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TabInformExtraJuntaPK)) {
			return false;
		}
		TabInformExtraJuntaPK castOther = (TabInformExtraJuntaPK)other;
		return 
			this.tieProtocolo.equals(castOther.tieProtocolo)
			&& (this.tieTipoRelacao == castOther.tieTipoRelacao)
			&& this.tieCpfCnpj.equals(castOther.tieCpfCnpj);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tieProtocolo.hashCode();
		hash = hash * prime + this.tieTipoRelacao;
		hash = hash * prime + this.tieCpfCnpj.hashCode();
		
		return hash;
	}
}