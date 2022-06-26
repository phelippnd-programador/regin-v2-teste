package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.pscs.reginprocessoservice.model.entity.pk_composta.TabInstituicaoGenericaPK;
import lombok.Data;

/**
 * The persistent class for the tab_instituicao_generica database table.
 * 
 */
@Data
@Entity
@Table(name = "tab_instituicao_generica")
public class TabInstituicaoGenerica implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TabInstituicaoGenericaPK id;

	@Column(name = "TIG_DEPENDE_INSTITUICAO")
	private Integer tigDependeInstituicao;

	@Column(name = "TIG_EMITE_DOCUMENTO")
	private Integer tigEmiteDocumento;

	@Column(name = "TIG_EMITE_DOCUMENTO_FORMA")
	private Integer tigEmiteDocumentoForma;

	@Column(name = "TIG_INFORMA_NUMERO_PROCESSO")
	private Integer tigInformaNumeroProcesso;

	@Column(name = "TIG_ORDEM_AVALIACAO")
	private Integer tigOrdemAvaliacao;

	@Column(name = "TIG_PERMITE_ALTERACAO")
	private Integer tigPermiteAlteracao;

	@Column(name = "TIG_TGE_COD_INST")
	private Integer tigTgeCodInst;

	@Column(name = "TIG_TIP_PESQUISA")
	private Integer tigTipPesquisa;

	@Column(name = "TIG_TTL_ID")
	private Integer tigTtlId;

	// bi-directional many-to-one association to TabGenerica
//	@MapsId("tabGenerica")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns( {
			@JoinColumn( name = "TIG_TGE_COD_TIP_TAB", referencedColumnName = "TGE_COD_TIP_TAB", insertable =  false,updatable = false),
			@JoinColumn(name = "TIG_TGE_TIP_TAB", referencedColumnName = "TGE_TIP_TAB", insertable=false, updatable=false) 
			})
	private TabGenerica tabGenerica;

}