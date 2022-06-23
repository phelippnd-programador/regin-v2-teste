package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ruc_general")
public class RucGeneralEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	/** The rge pra protocolo. */
	private String rgePraProtocolo;
	/** The rge ruc. */
	private String rgeRuc;

	/** The rge tge ttip reg. */
	private Integer rgeTgeTtipReg;

	/** The rge tge vtip reg. */
	private Integer rgeTgeVtipReg;

	/** The rge tge ttip ctrib. */
	private Integer rgeTgeTtipCtrib;

	/** The rge tge vtip ctrib. */
	private Integer rgeTgeVtipCtrib;

	/** The rge tge ttip pers. */
	private Integer rgeTgeTtipPers;

	/** The rge tge vtip pers. */
	private Integer rgeTgeVtipPers;

	/** The rge cgc cpf. */
	private String rgeCgcCpf;

	/** The rge tsc sit cad. */
	private Integer rgeTscSitCad;

	/** The rge tab cod unid. */
	private Integer rgeTabCodUnid;

	/** The rge ruc cond. */
	private Integer rgeRucCond;

	/** The rge tco cond pago. */
	private Integer rgeTcoCondPago;

	/** The rge opt simp. */
	private String rgeOptSimp;

	/** The rge ind regm esp. */
	private Integer rgeIndRegmEsp;

	/** The rge ind subst trib. */
	private Integer rgeIndSubstTrib;

	/** The rge mes cier ejer. */
	private Integer rgeMesCierEjer;

	/** The rge fec ini act ec. */
	private String rgeFecIniActEc;

	/** The rge fec sit cad. */
	private String rgeFecSitCad;

	/** The rge fec actl. */
	private String rgeFecActl;

	/** The rge fec val ruc. */
	private String rgeFecValRuc;

	/** The rge tge torig actu. */
	private Integer rgeTgeTorigActu;

	/** The rge tge vorig actu. */
	private Integer rgeTgeVorigActu;

	/** The rge tus cod usr. */
	private String rgeTusCodUsr;

	/** The rge tge ttip insc. */
	private Integer rgeTgeTtipInsc;

	/** The rge tge vtip insc. */
	private Integer rgeTgeVtipInsc;

	/** The rge nomb. */
	private String rgeNomb;

	/** The rge codg mun. */
	private Integer rgeCodgMun;

	/** The rge tae cod actvd. */
	private Integer rgeTaeCodActvd;

	/** The rge tuf cod uf. */
	private String rgeTufCodUf;

	/** The rge tda cod daf. */
	private Integer rgeTdaCodDaf;

	/** The rge tge vtamanho. */
	private Integer rgeTgeVtamanho;

	/** The rge tge ttamanho. */
	private Integer rgeTgeTtamanho;
}
