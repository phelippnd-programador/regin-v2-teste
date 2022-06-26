package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;


/**
 * The persistent class for the ruc_comp database table.
 * 
 */
@Data
@Entity
@Table(name="ruc_comp")
@NamedQuery(name="RucComp.findAll", query="SELECT r FROM RucComp r")
public class RucComp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RCO_RGE_PRA_PROTOCOLO")
	private String rcoRgePraProtocolo;

	@Column(name="RCO_CAJA_PO")
	private String rcoCajaPo;

	@Column(name="RCO_DIRECCION")
	private String rcoDireccion;

	@Column(name="RCO_DOMIC_PAIS")
	private BigDecimal rcoDomicPais;

	@Column(name="RCO_EMIS_DOC_IDENT")
	private String rcoEmisDocIdent;

	@Type(type="timestamp")
	@Column(name="RCO_FEC_CONST_NASC")
	private LocalDateTime rcoFecConstNasc;

	@Column(name="RCO_FEC_EMI_DOC_ID")
	private LocalDateTime rcoFecEmiDocId;

	@Column(name="RCO_FEC_INCORP")
	private LocalDateTime rcoFecIncorp;

	@Column(name="RCO_FEC_REG_MERC")
	private LocalDateTime rcoFecRegMerc;

	@Column(name="RCO_FEC_RG_CAP_SOC")
	private LocalDateTime rcoFecRgCapSoc;

	@Column(name="RCO_IDENT_COMP")
	private String rcoIdentComp;

	@Column(name="RCO_LIC_MUN")
	private String rcoLicMun;

	@Column(name="RCO_NUM_DOC_IDENT")
	private String rcoNumDocIdent;

	@Column(name="RCO_NUM_REG_MERC")
	private String rcoNumRegMerc;

	@Column(name="RCO_NUME")
	private String rcoNume;

	@Column(name="RCO_QUAD_LOTE")
	private String rcoQuadLote;

	@Column(name="RCO_REFER")
	private String rcoRefer;

	@Column(name="RCO_RUC_EXT_UF")
	private String rcoRucExtUf;

	@Column(name="RCO_SEXO")
	private BigDecimal rcoSexo;

	@Column(name="RCO_TES_COD_ESTADO")
	private String rcoTesCodEstado;

	@Column(name="RCO_TGE_TCIER_BAL")
	private BigDecimal rcoTgeTcierBal;

	@Column(name="RCO_TGE_TPAIS")
	private BigDecimal rcoTgeTpais;

	@Column(name="RCO_TGE_TREG_TRIB")
	private BigDecimal rcoTgeTregTrib;

	@Column(name="RCO_TGE_TTIP_DOC")
	private BigDecimal rcoTgeTtipDoc;

	@Column(name="RCO_TGE_VCIER_BAL")
	private BigDecimal rcoTgeVcierBal;

	@Column(name="RCO_TGE_VPAIS")
	private BigDecimal rcoTgeVpais;

	@Column(name="RCO_TGE_VREG_TRIB")
	private BigDecimal rcoTgeVregTrib;

	@Column(name="RCO_TGE_VTIP_DOC")
	private BigDecimal rcoTgeVtipDoc;

	@Column(name="RCO_TMU_COD_MUN")
	private BigDecimal rcoTmuCodMun;

	@Column(name="RCO_TNC_COD_NATUR")
	private String rcoTncCodNatur;

	@Column(name="RCO_TTL_TIP_LOGRADORO")
	private String rcoTtlTipLogradoro;

	@Column(name="RCO_TUS_COD_USR")
	private String rcoTusCodUsr;

	@Column(name="RCO_URBANIZACION")
	private String rcoUrbanizacion;

	@Column(name="RCO_VAL_CAP_SOC")
	private BigDecimal rcoValCapSoc;

	@Column(name="RCO_ZONA_CAJA_PO")
	private String rcoZonaCajaPo;

	@Column(name="RCO_ZONA_POSTAL")
	private String rcoZonaPostal;

	//bi-directional one-to-one association to RucGeneral
	@OneToOne
	@JoinColumn(name="RCO_RGE_PRA_PROTOCOLO",insertable=false, updatable=false)
	private RucGeneral rucGeneral;

}