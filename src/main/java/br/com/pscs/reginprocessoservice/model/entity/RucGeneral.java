package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


/**
 * The persistent class for the ruc_general database table.
 * 
 */
@Entity
@Table(name="ruc_general")
@NamedQuery(name="RucGeneral.findAll", query="SELECT r FROM RucGeneral r")
public class RucGeneral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RGE_PRA_PROTOCOLO")
	private String rgePraProtocolo;

	@Column(name="RGE_CGC_CPF")
	private String rgeCgcCpf;

	@Column(name="RGE_CODG_MUN")
	private BigDecimal rgeCodgMun;

	@Type(type="timestamp")
	@Column(name="RGE_FEC_ACTL")
	private LocalDateTime rgeFecActl;

	@Type(type="timestamp")
	@Column(name="RGE_FEC_INI_ACT_EC")
	private LocalDateTime rgeFecIniActEc;

	@Type(type="timestamp")
	@Column(name="RGE_FEC_SIT_CAD")
	private LocalDateTime rgeFecSitCad;

	@Type(type="timestamp")
	@Column(name="RGE_FEC_VAL_RUC")
	private LocalDateTime rgeFecValRuc;

	@Column(name="RGE_IND_REGM_ESP")
	private BigDecimal rgeIndRegmEsp;

	@Column(name="RGE_IND_SUBST_TRIB")
	private BigDecimal rgeIndSubstTrib;

	@Column(name="RGE_MES_CIER_EJER")
	private BigDecimal rgeMesCierEjer;

	@Column(name="RGE_NOMB")
	private String rgeNomb;

	@Column(name="RGE_OPT_SIMP")
	private String rgeOptSimp;

	@Column(name="RGE_RUC")
	private String rgeRuc;

	@Column(name="RGE_RUC_COND")
	private BigDecimal rgeRucCond;

	@Column(name="RGE_TAB_COD_UNID")
	private BigDecimal rgeTabCodUnid;

	@Column(name="RGE_TAE_COD_ACTVD")
	private BigDecimal rgeTaeCodActvd;

	@Column(name="RGE_TCO_COND_PAGO")
	private BigDecimal rgeTcoCondPago;

	@Column(name="RGE_TDA_COD_DAF")
	private BigDecimal rgeTdaCodDaf;

	@Column(name="RGE_TGE_TORIG_ACTU")
	private BigDecimal rgeTgeTorigActu;

	@Column(name="RGE_TGE_TTAMANHO")
	private BigDecimal rgeTgeTtamanho;

	@Column(name="RGE_TGE_TTIP_CTRIB")
	private BigDecimal rgeTgeTtipCtrib;

	@Column(name="RGE_TGE_TTIP_INSC")
	private BigDecimal rgeTgeTtipInsc;

	@Column(name="RGE_TGE_TTIP_PERS")
	private BigDecimal rgeTgeTtipPers;

	@Column(name="RGE_TGE_TTIP_REG")
	private BigDecimal rgeTgeTtipReg;

	@Column(name="RGE_TGE_VORIG_ACTU")
	private BigDecimal rgeTgeVorigActu;

	@Column(name="RGE_TGE_VTAMANHO")
	private BigDecimal rgeTgeVtamanho;

	@Column(name="RGE_TGE_VTIP_CTRIB")
	private BigDecimal rgeTgeVtipCtrib;

	@Column(name="RGE_TGE_VTIP_INSC")
	private BigDecimal rgeTgeVtipInsc;

	@Column(name="RGE_TGE_VTIP_PERS")
	private BigDecimal rgeTgeVtipPers;

	@Column(name="RGE_TGE_VTIP_REG")
	private BigDecimal rgeTgeVtipReg;

	@Column(name="RGE_TSC_SIT_CAD")
	private BigDecimal rgeTscSitCad;

	@Column(name="RGE_TUF_COD_UF")
	private String rgeTufCodUf;

	@Column(name="RGE_TUS_COD_USR")
	private String rgeTusCodUsr;

	//bi-directional one-to-one association to RucComp
	@OneToOne(mappedBy="rucGeneral")
	private RucComp rucComp;

	//bi-directional many-to-one association to RucEstab
	@OneToMany(mappedBy="rucGeneral")
	private List<RucEstab> rucEstabs;

	//bi-directional one-to-one association to PscRegistraArquivo
	@OneToOne
	@JoinColumn(name="RGE_PRA_PROTOCOLO")
	private PscRegistraArquivo pscRegistraArquivo;

	public RucGeneral() {
	}

	public String getRgePraProtocolo() {
		return this.rgePraProtocolo;
	}

	public void setRgePraProtocolo(String rgePraProtocolo) {
		this.rgePraProtocolo = rgePraProtocolo;
	}

	public String getRgeCgcCpf() {
		return this.rgeCgcCpf;
	}

	public void setRgeCgcCpf(String rgeCgcCpf) {
		this.rgeCgcCpf = rgeCgcCpf;
	}

	public BigDecimal getRgeCodgMun() {
		return this.rgeCodgMun;
	}

	public void setRgeCodgMun(BigDecimal rgeCodgMun) {
		this.rgeCodgMun = rgeCodgMun;
	}

	public LocalDateTime getRgeFecActl() {
		return this.rgeFecActl;
	}

	public void setRgeFecActl(LocalDateTime rgeFecActl) {
		this.rgeFecActl = rgeFecActl;
	}

	public LocalDateTime getRgeFecIniActEc() {
		return this.rgeFecIniActEc;
	}

	public void setRgeFecIniActEc(LocalDateTime rgeFecIniActEc) {
		this.rgeFecIniActEc = rgeFecIniActEc;
	}

	public LocalDateTime getRgeFecSitCad() {
		return this.rgeFecSitCad;
	}

	public void setRgeFecSitCad(LocalDateTime rgeFecSitCad) {
		this.rgeFecSitCad = rgeFecSitCad;
	}

	public LocalDateTime getRgeFecValRuc() {
		return this.rgeFecValRuc;
	}

	public void setRgeFecValRuc(LocalDateTime rgeFecValRuc) {
		this.rgeFecValRuc = rgeFecValRuc;
	}

	public BigDecimal getRgeIndRegmEsp() {
		return this.rgeIndRegmEsp;
	}

	public void setRgeIndRegmEsp(BigDecimal rgeIndRegmEsp) {
		this.rgeIndRegmEsp = rgeIndRegmEsp;
	}

	public BigDecimal getRgeIndSubstTrib() {
		return this.rgeIndSubstTrib;
	}

	public void setRgeIndSubstTrib(BigDecimal rgeIndSubstTrib) {
		this.rgeIndSubstTrib = rgeIndSubstTrib;
	}

	public BigDecimal getRgeMesCierEjer() {
		return this.rgeMesCierEjer;
	}

	public void setRgeMesCierEjer(BigDecimal rgeMesCierEjer) {
		this.rgeMesCierEjer = rgeMesCierEjer;
	}

	public String getRgeNomb() {
		return this.rgeNomb;
	}

	public void setRgeNomb(String rgeNomb) {
		this.rgeNomb = rgeNomb;
	}

	public String getRgeOptSimp() {
		return this.rgeOptSimp;
	}

	public void setRgeOptSimp(String rgeOptSimp) {
		this.rgeOptSimp = rgeOptSimp;
	}

	public String getRgeRuc() {
		return this.rgeRuc;
	}

	public void setRgeRuc(String rgeRuc) {
		this.rgeRuc = rgeRuc;
	}

	public BigDecimal getRgeRucCond() {
		return this.rgeRucCond;
	}

	public void setRgeRucCond(BigDecimal rgeRucCond) {
		this.rgeRucCond = rgeRucCond;
	}

	public BigDecimal getRgeTabCodUnid() {
		return this.rgeTabCodUnid;
	}

	public void setRgeTabCodUnid(BigDecimal rgeTabCodUnid) {
		this.rgeTabCodUnid = rgeTabCodUnid;
	}

	public BigDecimal getRgeTaeCodActvd() {
		return this.rgeTaeCodActvd;
	}

	public void setRgeTaeCodActvd(BigDecimal rgeTaeCodActvd) {
		this.rgeTaeCodActvd = rgeTaeCodActvd;
	}

	public BigDecimal getRgeTcoCondPago() {
		return this.rgeTcoCondPago;
	}

	public void setRgeTcoCondPago(BigDecimal rgeTcoCondPago) {
		this.rgeTcoCondPago = rgeTcoCondPago;
	}

	public BigDecimal getRgeTdaCodDaf() {
		return this.rgeTdaCodDaf;
	}

	public void setRgeTdaCodDaf(BigDecimal rgeTdaCodDaf) {
		this.rgeTdaCodDaf = rgeTdaCodDaf;
	}

	public BigDecimal getRgeTgeTorigActu() {
		return this.rgeTgeTorigActu;
	}

	public void setRgeTgeTorigActu(BigDecimal rgeTgeTorigActu) {
		this.rgeTgeTorigActu = rgeTgeTorigActu;
	}

	public BigDecimal getRgeTgeTtamanho() {
		return this.rgeTgeTtamanho;
	}

	public void setRgeTgeTtamanho(BigDecimal rgeTgeTtamanho) {
		this.rgeTgeTtamanho = rgeTgeTtamanho;
	}

	public BigDecimal getRgeTgeTtipCtrib() {
		return this.rgeTgeTtipCtrib;
	}

	public void setRgeTgeTtipCtrib(BigDecimal rgeTgeTtipCtrib) {
		this.rgeTgeTtipCtrib = rgeTgeTtipCtrib;
	}

	public BigDecimal getRgeTgeTtipInsc() {
		return this.rgeTgeTtipInsc;
	}

	public void setRgeTgeTtipInsc(BigDecimal rgeTgeTtipInsc) {
		this.rgeTgeTtipInsc = rgeTgeTtipInsc;
	}

	public BigDecimal getRgeTgeTtipPers() {
		return this.rgeTgeTtipPers;
	}

	public void setRgeTgeTtipPers(BigDecimal rgeTgeTtipPers) {
		this.rgeTgeTtipPers = rgeTgeTtipPers;
	}

	public BigDecimal getRgeTgeTtipReg() {
		return this.rgeTgeTtipReg;
	}

	public void setRgeTgeTtipReg(BigDecimal rgeTgeTtipReg) {
		this.rgeTgeTtipReg = rgeTgeTtipReg;
	}

	public BigDecimal getRgeTgeVorigActu() {
		return this.rgeTgeVorigActu;
	}

	public void setRgeTgeVorigActu(BigDecimal rgeTgeVorigActu) {
		this.rgeTgeVorigActu = rgeTgeVorigActu;
	}

	public BigDecimal getRgeTgeVtamanho() {
		return this.rgeTgeVtamanho;
	}

	public void setRgeTgeVtamanho(BigDecimal rgeTgeVtamanho) {
		this.rgeTgeVtamanho = rgeTgeVtamanho;
	}

	public BigDecimal getRgeTgeVtipCtrib() {
		return this.rgeTgeVtipCtrib;
	}

	public void setRgeTgeVtipCtrib(BigDecimal rgeTgeVtipCtrib) {
		this.rgeTgeVtipCtrib = rgeTgeVtipCtrib;
	}

	public BigDecimal getRgeTgeVtipInsc() {
		return this.rgeTgeVtipInsc;
	}

	public void setRgeTgeVtipInsc(BigDecimal rgeTgeVtipInsc) {
		this.rgeTgeVtipInsc = rgeTgeVtipInsc;
	}

	public BigDecimal getRgeTgeVtipPers() {
		return this.rgeTgeVtipPers;
	}

	public void setRgeTgeVtipPers(BigDecimal rgeTgeVtipPers) {
		this.rgeTgeVtipPers = rgeTgeVtipPers;
	}

	public BigDecimal getRgeTgeVtipReg() {
		return this.rgeTgeVtipReg;
	}

	public void setRgeTgeVtipReg(BigDecimal rgeTgeVtipReg) {
		this.rgeTgeVtipReg = rgeTgeVtipReg;
	}

	public BigDecimal getRgeTscSitCad() {
		return this.rgeTscSitCad;
	}

	public void setRgeTscSitCad(BigDecimal rgeTscSitCad) {
		this.rgeTscSitCad = rgeTscSitCad;
	}

	public String getRgeTufCodUf() {
		return this.rgeTufCodUf;
	}

	public void setRgeTufCodUf(String rgeTufCodUf) {
		this.rgeTufCodUf = rgeTufCodUf;
	}

	public String getRgeTusCodUsr() {
		return this.rgeTusCodUsr;
	}

	public void setRgeTusCodUsr(String rgeTusCodUsr) {
		this.rgeTusCodUsr = rgeTusCodUsr;
	}

	public RucComp getRucComp() {
		return this.rucComp;
	}

	public void setRucComp(RucComp rucComp) {
		this.rucComp = rucComp;
	}

	public List<RucEstab> getRucEstabs() {
		return this.rucEstabs;
	}

	public void setRucEstabs(List<RucEstab> rucEstabs) {
		this.rucEstabs = rucEstabs;
	}

	public RucEstab addRucEstab(RucEstab rucEstab) {
		getRucEstabs().add(rucEstab);
		rucEstab.setRucGeneral(this);

		return rucEstab;
	}

	public RucEstab removeRucEstab(RucEstab rucEstab) {
		getRucEstabs().remove(rucEstab);
		rucEstab.setRucGeneral(null);

		return rucEstab;
	}

	public PscRegistraArquivo getPscRegistraArquivo() {
		return this.pscRegistraArquivo;
	}

	public void setPscRegistraArquivo(PscRegistraArquivo pscRegistraArquivo) {
		this.pscRegistraArquivo = pscRegistraArquivo;
	}

}