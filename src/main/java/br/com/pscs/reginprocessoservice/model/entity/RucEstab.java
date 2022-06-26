package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.com.pscs.reginprocessoservice.model.entity.pk_composta.RucEstabPK;


/**
 * The persistent class for the ruc_estab database table.
 * 
 */
@Entity
@Table(name="ruc_estab")
@NamedQuery(name="RucEstab.findAll", query="SELECT r FROM RucEstab r")
public class RucEstab implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RucEstabPK id;

	@Column(name="RES_AREA")
	private BigDecimal resArea;

	@Column(name="RES_CAJA_PO")
	private String resCajaPo;

	@Column(name="RES_DIRECCION")
	private String resDireccion;

	@Column(name="RES_DS_EVENTO")
	private String resDsEvento;

	@Type(type="timestamp")
	@Column(name="RES_DT_EVENTO_FIM")
	private LocalDateTime resDtEventoFim;

	@Type(type="timestamp")
	@Column(name="RES_DT_EVENTO_INICIO")
	private LocalDateTime resDtEventoInicio;

	@Type(type="timestamp")
	@Column(name="RES_FEC_FIN")
	private LocalDateTime resFecFin;

	@Type(type="timestamp")
	@Column(name="RES_FEC_INIC")
	private LocalDateTime resFecInic;

	@Column(name="RES_IDENT_COMP")
	private String resIdentComp;

	@Column(name="RES_MOTIVO_INSCRICAO")
	private String resMotivoInscricao;

	@Column(name="RES_NOM_ESTAB")
	private String resNomEstab;

	@Column(name="RES_NUM_REG_PROP")
	private String resNumRegProp;

	@Column(name="RES_NUME")
	private String resNume;

	@Column(name="RES_QUAD_LOTE")
	private String resQuadLote;

	@Column(name="RES_REFER")
	private String resRefer;

	@Column(name="RES_SIGL")
	private String resSigl;

	@Column(name="RES_TES_COD_ESTADO")
	private String resTesCodEstado;

	@Column(name="RES_TGE_TCOND_USO")
	private BigDecimal resTgeTcondUso;

	@Column(name="RES_TGE_TTIP_REG")
	private BigDecimal resTgeTtipReg;

	@Column(name="RES_TGE_TUNI_MEDID")
	private BigDecimal resTgeTuniMedid;

	@Column(name="RES_TGE_VCOND_USO")
	private BigDecimal resTgeVcondUso;

	@Column(name="RES_TGE_VTIP_REG")
	private BigDecimal resTgeVtipReg;

	@Column(name="RES_TGE_VUNI_MEDID")
	private BigDecimal resTgeVuniMedid;

	@Column(name="RES_TIP_ESTAB")
	private BigDecimal resTipEstab;

	@Column(name="RES_TMU_COD_MUN")
	private BigDecimal resTmuCodMun;

	@Column(name="RES_TTL_TIP_LOGRADORO")
	private String resTtlTipLogradoro;

	@Column(name="RES_TUS_COD_USR")
	private String resTusCodUsr;

	@Column(name="RES_URBANIZACION")
	private String resUrbanizacion;

	@Column(name="RES_ZONA_CAJA_PO")
	private String resZonaCajaPo;

	@Column(name="RES_ZONA_POSTAL")
	private String resZonaPostal;

	//bi-directional many-to-one association to RucGeneral
	@ManyToOne
	@JoinColumn(name="RES_RGE_PRA_PROTOCOLO", insertable=false, updatable=false)
	private RucGeneral rucGeneral;

	public RucEstab() {
	}

	public RucEstabPK getId() {
		return this.id;
	}

	public void setId(RucEstabPK id) {
		this.id = id;
	}

	public BigDecimal getResArea() {
		return this.resArea;
	}

	public void setResArea(BigDecimal resArea) {
		this.resArea = resArea;
	}

	public String getResCajaPo() {
		return this.resCajaPo;
	}

	public void setResCajaPo(String resCajaPo) {
		this.resCajaPo = resCajaPo;
	}

	public String getResDireccion() {
		return this.resDireccion;
	}

	public void setResDireccion(String resDireccion) {
		this.resDireccion = resDireccion;
	}

	public String getResDsEvento() {
		return this.resDsEvento;
	}

	public void setResDsEvento(String resDsEvento) {
		this.resDsEvento = resDsEvento;
	}

	public LocalDateTime getResDtEventoFim() {
		return this.resDtEventoFim;
	}

	public void setResDtEventoFim(LocalDateTime resDtEventoFim) {
		this.resDtEventoFim = resDtEventoFim;
	}

	public LocalDateTime getResDtEventoInicio() {
		return this.resDtEventoInicio;
	}

	public void setResDtEventoInicio(LocalDateTime resDtEventoInicio) {
		this.resDtEventoInicio = resDtEventoInicio;
	}

	public LocalDateTime getResFecFin() {
		return this.resFecFin;
	}

	public void setResFecFin(LocalDateTime resFecFin) {
		this.resFecFin = resFecFin;
	}

	public LocalDateTime getResFecInic() {
		return this.resFecInic;
	}

	public void setResFecInic(LocalDateTime resFecInic) {
		this.resFecInic = resFecInic;
	}

	public String getResIdentComp() {
		return this.resIdentComp;
	}

	public void setResIdentComp(String resIdentComp) {
		this.resIdentComp = resIdentComp;
	}

	public String getResMotivoInscricao() {
		return this.resMotivoInscricao;
	}

	public void setResMotivoInscricao(String resMotivoInscricao) {
		this.resMotivoInscricao = resMotivoInscricao;
	}

	public String getResNomEstab() {
		return this.resNomEstab;
	}

	public void setResNomEstab(String resNomEstab) {
		this.resNomEstab = resNomEstab;
	}

	public String getResNumRegProp() {
		return this.resNumRegProp;
	}

	public void setResNumRegProp(String resNumRegProp) {
		this.resNumRegProp = resNumRegProp;
	}

	public String getResNume() {
		return this.resNume;
	}

	public void setResNume(String resNume) {
		this.resNume = resNume;
	}

	public String getResQuadLote() {
		return this.resQuadLote;
	}

	public void setResQuadLote(String resQuadLote) {
		this.resQuadLote = resQuadLote;
	}

	public String getResRefer() {
		return this.resRefer;
	}

	public void setResRefer(String resRefer) {
		this.resRefer = resRefer;
	}

	public String getResSigl() {
		return this.resSigl;
	}

	public void setResSigl(String resSigl) {
		this.resSigl = resSigl;
	}

	public String getResTesCodEstado() {
		return this.resTesCodEstado;
	}

	public void setResTesCodEstado(String resTesCodEstado) {
		this.resTesCodEstado = resTesCodEstado;
	}

	public BigDecimal getResTgeTcondUso() {
		return this.resTgeTcondUso;
	}

	public void setResTgeTcondUso(BigDecimal resTgeTcondUso) {
		this.resTgeTcondUso = resTgeTcondUso;
	}

	public BigDecimal getResTgeTtipReg() {
		return this.resTgeTtipReg;
	}

	public void setResTgeTtipReg(BigDecimal resTgeTtipReg) {
		this.resTgeTtipReg = resTgeTtipReg;
	}

	public BigDecimal getResTgeTuniMedid() {
		return this.resTgeTuniMedid;
	}

	public void setResTgeTuniMedid(BigDecimal resTgeTuniMedid) {
		this.resTgeTuniMedid = resTgeTuniMedid;
	}

	public BigDecimal getResTgeVcondUso() {
		return this.resTgeVcondUso;
	}

	public void setResTgeVcondUso(BigDecimal resTgeVcondUso) {
		this.resTgeVcondUso = resTgeVcondUso;
	}

	public BigDecimal getResTgeVtipReg() {
		return this.resTgeVtipReg;
	}

	public void setResTgeVtipReg(BigDecimal resTgeVtipReg) {
		this.resTgeVtipReg = resTgeVtipReg;
	}

	public BigDecimal getResTgeVuniMedid() {
		return this.resTgeVuniMedid;
	}

	public void setResTgeVuniMedid(BigDecimal resTgeVuniMedid) {
		this.resTgeVuniMedid = resTgeVuniMedid;
	}

	public BigDecimal getResTipEstab() {
		return this.resTipEstab;
	}

	public void setResTipEstab(BigDecimal resTipEstab) {
		this.resTipEstab = resTipEstab;
	}

	public BigDecimal getResTmuCodMun() {
		return this.resTmuCodMun;
	}

	public void setResTmuCodMun(BigDecimal resTmuCodMun) {
		this.resTmuCodMun = resTmuCodMun;
	}

	public String getResTtlTipLogradoro() {
		return this.resTtlTipLogradoro;
	}

	public void setResTtlTipLogradoro(String resTtlTipLogradoro) {
		this.resTtlTipLogradoro = resTtlTipLogradoro;
	}

	public String getResTusCodUsr() {
		return this.resTusCodUsr;
	}

	public void setResTusCodUsr(String resTusCodUsr) {
		this.resTusCodUsr = resTusCodUsr;
	}

	public String getResUrbanizacion() {
		return this.resUrbanizacion;
	}

	public void setResUrbanizacion(String resUrbanizacion) {
		this.resUrbanizacion = resUrbanizacion;
	}

	public String getResZonaCajaPo() {
		return this.resZonaCajaPo;
	}

	public void setResZonaCajaPo(String resZonaCajaPo) {
		this.resZonaCajaPo = resZonaCajaPo;
	}

	public String getResZonaPostal() {
		return this.resZonaPostal;
	}

	public void setResZonaPostal(String resZonaPostal) {
		this.resZonaPostal = resZonaPostal;
	}

	public RucGeneral getRucGeneral() {
		return this.rucGeneral;
	}

	public void setRucGeneral(RucGeneral rucGeneral) {
		this.rucGeneral = rucGeneral;
	}

}