package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.pscs.reginprocessoservice.model.entity.pk_composta.TabInformExtraJuntaPK;


/**
 * The persistent class for the tab_inform_extra_junta database table.
 * 
 */
@Entity
@Table(name="tab_inform_extra_junta")
@NamedQuery(name="TabInformExtraJunta.findAll", query="SELECT t FROM TabInformExtraJunta t")
public class TabInformExtraJunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TabInformExtraJuntaPK id;

	@Column(name="TIE_CNPJ_REGISTRO")
	private String tieCnpjRegistro;

	@Column(name="TIE_DDD_FAX")
	private String tieDddFax;

	@Column(name="TIE_DDD_FONE1")
	private String tieDddFone1;

	@Column(name="TIE_DDD_FONE2")
	private String tieDddFone2;

	@Column(name="TIE_DISTRITO")
	private String tieDistrito;

	@Column(name="TIE_EMAIL")
	private String tieEmail;

	@Column(name="TIE_FAX")
	private String tieFax;

	@Column(name="TIE_FONE1")
	private String tieFone1;

	@Column(name="TIE_FONE2")
	private String tieFone2;

	@Column(name="TIE_FORMA_ATUACAO")
	private String tieFormaAtuacao;

	@Column(name="TIE_FORMA_ATUACAO_OUTROS")
	private String tieFormaAtuacaoOutros;

	@Column(name="TIE_ORGAO_REGISTRO")
	private String tieOrgaoRegistro;

	@Column(name="TIE_TIPO_UNIDADE")
	private String tieTipoUnidade;

	public TabInformExtraJunta() {
	}

	public TabInformExtraJuntaPK getId() {
		return this.id;
	}

	public void setId(TabInformExtraJuntaPK id) {
		this.id = id;
	}

	public String getTieCnpjRegistro() {
		return this.tieCnpjRegistro;
	}

	public void setTieCnpjRegistro(String tieCnpjRegistro) {
		this.tieCnpjRegistro = tieCnpjRegistro;
	}

	public String getTieDddFax() {
		return this.tieDddFax;
	}

	public void setTieDddFax(String tieDddFax) {
		this.tieDddFax = tieDddFax;
	}

	public String getTieDddFone1() {
		return this.tieDddFone1;
	}

	public void setTieDddFone1(String tieDddFone1) {
		this.tieDddFone1 = tieDddFone1;
	}

	public String getTieDddFone2() {
		return this.tieDddFone2;
	}

	public void setTieDddFone2(String tieDddFone2) {
		this.tieDddFone2 = tieDddFone2;
	}

	public String getTieDistrito() {
		return this.tieDistrito;
	}

	public void setTieDistrito(String tieDistrito) {
		this.tieDistrito = tieDistrito;
	}

	public String getTieEmail() {
		return this.tieEmail;
	}

	public void setTieEmail(String tieEmail) {
		this.tieEmail = tieEmail;
	}

	public String getTieFax() {
		return this.tieFax;
	}

	public void setTieFax(String tieFax) {
		this.tieFax = tieFax;
	}

	public String getTieFone1() {
		return this.tieFone1;
	}

	public void setTieFone1(String tieFone1) {
		this.tieFone1 = tieFone1;
	}

	public String getTieFone2() {
		return this.tieFone2;
	}

	public void setTieFone2(String tieFone2) {
		this.tieFone2 = tieFone2;
	}

	public String getTieFormaAtuacao() {
		return this.tieFormaAtuacao;
	}

	public void setTieFormaAtuacao(String tieFormaAtuacao) {
		this.tieFormaAtuacao = tieFormaAtuacao;
	}

	public String getTieFormaAtuacaoOutros() {
		return this.tieFormaAtuacaoOutros;
	}

	public void setTieFormaAtuacaoOutros(String tieFormaAtuacaoOutros) {
		this.tieFormaAtuacaoOutros = tieFormaAtuacaoOutros;
	}

	public String getTieOrgaoRegistro() {
		return this.tieOrgaoRegistro;
	}

	public void setTieOrgaoRegistro(String tieOrgaoRegistro) {
		this.tieOrgaoRegistro = tieOrgaoRegistro;
	}

	public String getTieTipoUnidade() {
		return this.tieTipoUnidade;
	}

	public void setTieTipoUnidade(String tieTipoUnidade) {
		this.tieTipoUnidade = tieTipoUnidade;
	}

}