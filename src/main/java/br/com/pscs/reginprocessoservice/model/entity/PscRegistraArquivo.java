package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


/**
 * The persistent class for the psc_registra_arquivo database table.
 * 
 */
@Entity
@Table(name="psc_registra_arquivo")
@NamedQuery(name="PscRegistraArquivo.findAll", query="SELECT p FROM PscRegistraArquivo p")
public class PscRegistraArquivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRA_PROTOCOLO")
	private String praProtocolo;

	@Column(name="PRA_ALVARA")
	private String praAlvara;

	@Column(name="PRA_CNPJ")
	private String praCnpj;

	@Lob
	@Column(name="PRA_DESC_ERRO_PROC")
	private String praDescErroProc;

	@Type(type="timestamp")
	@Column(name="PRA_FEC_CARREGADO")
	private LocalDateTime praFecCarregado;

	@Type(type="timestamp")
	@Column(name="PRA_FEC_ENVIO_SEFAZ")
	private LocalDateTime praFecEnvioSefaz;

	@Type(type="timestamp")
	@Column(name="PRA_FEC_INC")
	private LocalDateTime praFecInc;

	@Type(type="timestamp")
	@Column(name="PRA_FEC_RECEBIDO")
	private LocalDateTime praFecRecebido;

	@Column(name="PRA_NIRE")
	private String praNire;

	@Column(name="pra_processo_automatico")
	private byte praProcessoAutomatico;

	@Column(name="PRA_RESPOSTA_SEFAZ")
	private String praRespostaSefaz;

	@Column(name="PRA_RUC")
	private String praRuc;

	@Column(name="PRA_STATUS")
	private BigDecimal praStatus;

	@Column(name="PRA_STATUS_CARGA_TXT")
	private BigDecimal praStatusCargaTxt;

	@Column(name="PRA_STATUS_ENVIO_SEFAZ")
	private int praStatusEnvioSefaz;

	@Column(name="PRA_TGE_COD_TIP_TAB")
	private BigDecimal praTgeCodTipTab;

	@Column(name="PRA_TGE_TIP_TAB")
	private BigDecimal praTgeTipTab;

	@Column(name="PRA_TIPO_PROTOCOLO")
	private int praTipoProtocolo;

	//bi-directional many-to-one association to PscRespostaInstituicao
	@OneToMany(mappedBy="pscRegistraArquivo")
	private List<PscRespostaInstituicao> pscRespostaInstituicaos;

	//bi-directional one-to-one association to RucGeneral
	@OneToOne(mappedBy="pscRegistraArquivo")
	private RucGeneral rucGeneral;

	public PscRegistraArquivo() {
	}

	public String getPraProtocolo() {
		return this.praProtocolo;
	}

	public void setPraProtocolo(String praProtocolo) {
		this.praProtocolo = praProtocolo;
	}

	public String getPraAlvara() {
		return this.praAlvara;
	}

	public void setPraAlvara(String praAlvara) {
		this.praAlvara = praAlvara;
	}

	public String getPraCnpj() {
		return this.praCnpj;
	}

	public void setPraCnpj(String praCnpj) {
		this.praCnpj = praCnpj;
	}

	public String getPraDescErroProc() {
		return this.praDescErroProc;
	}

	public void setPraDescErroProc(String praDescErroProc) {
		this.praDescErroProc = praDescErroProc;
	}

	public LocalDateTime getPraFecCarregado() {
		return this.praFecCarregado;
	}

	public void setPraFecCarregado(LocalDateTime praFecCarregado) {
		this.praFecCarregado = praFecCarregado;
	}

	public LocalDateTime getPraFecEnvioSefaz() {
		return this.praFecEnvioSefaz;
	}

	public void setPraFecEnvioSefaz(LocalDateTime praFecEnvioSefaz) {
		this.praFecEnvioSefaz = praFecEnvioSefaz;
	}

	public LocalDateTime getPraFecInc() {
		return this.praFecInc;
	}

	public void setPraFecInc(LocalDateTime praFecInc) {
		this.praFecInc = praFecInc;
	}

	public LocalDateTime getPraFecRecebido() {
		return this.praFecRecebido;
	}

	public void setPraFecRecebido(LocalDateTime praFecRecebido) {
		this.praFecRecebido = praFecRecebido;
	}

	public String getPraNire() {
		return this.praNire;
	}

	public void setPraNire(String praNire) {
		this.praNire = praNire;
	}

	public byte getPraProcessoAutomatico() {
		return this.praProcessoAutomatico;
	}

	public void setPraProcessoAutomatico(byte praProcessoAutomatico) {
		this.praProcessoAutomatico = praProcessoAutomatico;
	}

	public String getPraRespostaSefaz() {
		return this.praRespostaSefaz;
	}

	public void setPraRespostaSefaz(String praRespostaSefaz) {
		this.praRespostaSefaz = praRespostaSefaz;
	}

	public String getPraRuc() {
		return this.praRuc;
	}

	public void setPraRuc(String praRuc) {
		this.praRuc = praRuc;
	}

	public BigDecimal getPraStatus() {
		return this.praStatus;
	}

	public void setPraStatus(BigDecimal praStatus) {
		this.praStatus = praStatus;
	}

	public BigDecimal getPraStatusCargaTxt() {
		return this.praStatusCargaTxt;
	}

	public void setPraStatusCargaTxt(BigDecimal praStatusCargaTxt) {
		this.praStatusCargaTxt = praStatusCargaTxt;
	}

	public int getPraStatusEnvioSefaz() {
		return this.praStatusEnvioSefaz;
	}

	public void setPraStatusEnvioSefaz(int praStatusEnvioSefaz) {
		this.praStatusEnvioSefaz = praStatusEnvioSefaz;
	}

	public BigDecimal getPraTgeCodTipTab() {
		return this.praTgeCodTipTab;
	}

	public void setPraTgeCodTipTab(BigDecimal praTgeCodTipTab) {
		this.praTgeCodTipTab = praTgeCodTipTab;
	}

	public BigDecimal getPraTgeTipTab() {
		return this.praTgeTipTab;
	}

	public void setPraTgeTipTab(BigDecimal praTgeTipTab) {
		this.praTgeTipTab = praTgeTipTab;
	}

	public int getPraTipoProtocolo() {
		return this.praTipoProtocolo;
	}

	public void setPraTipoProtocolo(int praTipoProtocolo) {
		this.praTipoProtocolo = praTipoProtocolo;
	}

	public List<PscRespostaInstituicao> getPscRespostaInstituicaos() {
		return this.pscRespostaInstituicaos;
	}

	public void setPscRespostaInstituicaos(List<PscRespostaInstituicao> pscRespostaInstituicaos) {
		this.pscRespostaInstituicaos = pscRespostaInstituicaos;
	}

	public PscRespostaInstituicao addPscRespostaInstituicao(PscRespostaInstituicao pscRespostaInstituicao) {
		getPscRespostaInstituicaos().add(pscRespostaInstituicao);
		pscRespostaInstituicao.setPscRegistraArquivo(this);

		return pscRespostaInstituicao;
	}

	public PscRespostaInstituicao removePscRespostaInstituicao(PscRespostaInstituicao pscRespostaInstituicao) {
		getPscRespostaInstituicaos().remove(pscRespostaInstituicao);
		pscRespostaInstituicao.setPscRegistraArquivo(null);

		return pscRespostaInstituicao;
	}

	public RucGeneral getRucGeneral() {
		return this.rucGeneral;
	}

	public void setRucGeneral(RucGeneral rucGeneral) {
		this.rucGeneral = rucGeneral;
	}

}