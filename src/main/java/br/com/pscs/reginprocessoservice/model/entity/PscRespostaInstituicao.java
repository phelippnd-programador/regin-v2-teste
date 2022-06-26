package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscRespostaInstituicaoPK;
import lombok.Data;


/**
 * The persistent class for the psc_resposta_instituicao database table.
 * 
 */
@Data
@Entity
@Table(name="psc_resposta_instituicao")
@NamedQuery(name="PscRespostaInstituicao.findAll", query="SELECT p FROM PscRespostaInstituicao p")
public class PscRespostaInstituicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PscRespostaInstituicaoPK id;

	@Column(name="PRI_ALT")
	private String priAlt;

	@Column(name="PRI_ALVARA")
	private String priAlvara;

	@Column(name="PRI_ALVARA_LICENCIAMENTO")
	private String priAlvaraLicenciamento;

	@Column(name="PRI_ALVARA_VIG")
	private String priAlvaraVig;

	@Column(name="PRI_CPF_USUARIO_CANCELA_ALVARA")
	private String priCpfUsuarioCancelaAlvara;

	@Column(name="PRI_DATA_CANCELA_ALVARA")
	private String priDataCancelaAlvara;

	@Type(type="timestamp")
	@Column(name="PRI_DATA_EMISSAO_ALVARA")
	private LocalDateTime priDataEmissaoAlvara;

	@Type(type="timestamp")
	@Column(name="PRI_DATA_EMISSAO_IPTU")
	private LocalDateTime priDataEmissaoIptu;

	@Type(type="timestamp")
	@Column(name="PRI_DATA_EMISSAO_ISS")
	private LocalDateTime priDataEmissaoIss;

	@Type(type="timestamp")
	@Column(name="PRI_DATA_VALIDADE")
	private LocalDateTime priDataValidade;

	@Column(name="PRI_DESCRICAO_STATUS_INT")
	private String priDescricaoStatusInt;

	@Column(name="PRI_EMITIU_ALVARA_PROV")
	private Integer priEmitiuAlvaraProv;

	@Type(type="timestamp")
	@Column(name="PRI_EMITIU_ALVARA_PROV_DATA")
	private LocalDateTime priEmitiuAlvaraProvData;

	@Type(type="timestamp")
	@Column(name="PRI_FEC_ATUAL")
	private LocalDateTime priFecAtual;

	@Type(type="timestamp")
	@Column(name="PRI_FEC_EXTRACAO")
	private LocalDateTime priFecExtracao;

	@Type(type="timestamp")
	@Column(name="PRI_FEC_RETORNO")
	private LocalDateTime priFecRetorno;

	@Column(name="PRI_FLAG_ALTERADO")
	private Integer priFlagAlterado;

	@Column(name="PRI_FLAG_ALVARA_CANCELADO")
	private String priFlagAlvaraCancelado;

	@Column(name="PRI_FLAG_ANALISE_AUTO")
	private Integer priFlagAnaliseAuto;

	@Column(name="PRI_FLAG_ANALISE_N_INTERESSE")
	private Integer priFlagAnaliseNInteresse;

	@Column(name="PRI_FLAG_AVALIACAO")
	private Integer priFlagAvaliacao;

	@Column(name="PRI_FLAG_COPIA_VIAB")
	private Integer priFlagCopiaViab;

	@Column(name="PRI_FLAG_DOC_AREA_GERADO")
	private Integer priFlagDocAreaGerado;

	@Column(name="PRI_FLAG_DOC_GERADO")
	private Integer priFlagDocGerado;

	@Column(name="PRI_FLAG_VIGILANCIA")
	private BigDecimal priFlagVigilancia;

	@Column(name="PRI_ID_ORGAO_REGISTRO")
	private Integer priIdOrgaoRegistro;

	@Column(name="PRI_INSCRICAO_MUNICIPAL")
	private String priInscricaoMunicipal;

	@Column(name="PRI_INTERESSE_INST")
	private Integer priInteresseInst;

	@Column(name="PRI_IPTU")
	private String priIptu;

	@Column(name="PRI_ISS")
	private String priIss;

	@Column(name="PRI_LAT")
	private String priLat;

	@Column(name="PRI_LON")
	private String priLon;

	@Column(name="PRI_NOME_APROVADO")
	private String priNomeAprovado;

	@Lob
	@Column(name="PRI_OBS_ADICIONAL")
	private String priObsAdicional;

	@Column(name="PRI_OBSERVACAO_DOC")
	private String priObservacaoDoc;

	@Column(name="PRI_PRE")
	private String priPre;

	@Column(name="PRI_RESP_ANALISANDO")
	private String priRespAnalisando;

	@Type(type="timestamp")
	@Column(name="PRI_RESP_DATA_INI_ANALISE")
	private LocalDateTime priRespDataIniAnalise;

	@Column(name="PRI_SEQUENCIAL_IMOVEL")
	private String priSequencialImovel;

	@Column(name="PRI_STATUS")
	private Integer priStatus;

	@Column(name="PRI_STATUS_ENVIA_INST")
	private Integer priStatusEnviaInst;

	@Column(name="PRI_STATUS_ENVIA_INST_DESC")
	private String priStatusEnviaInstDesc;

	@Column(name="PRI_STATUS_INTEGRACAO")
	private Integer priStatusIntegracao;

	@Column(name="PRI_STATUS_NVISA")
	private BigDecimal priStatusNvisa;

	@Column(name="PRI_STATUS_VISA")
	private BigDecimal priStatusVisa;

	@Column(name="PRI_TIR_CPF_RESP")
	private String priTirCpfResp;

	@Column(name="PRI_TOKEN_INSTITUICAO")
	private String priTokenInstituicao;

	@Lob
	@Column(name="PRI_TX_CATEGORIA_USO")
	private String priTxCategoriaUso;

	@Lob
	@Column(name="PRI_TX_ZONEAMENTO")
	private String priTxZoneamento;

	@Column(name="PRI_TXT_JUSTIFICATIVA_CANCELAMENTO")
	private String priTxtJustificativaCancelamento;

	@Column(name="PRI_USO_EDIFICACAO")
	private String priUsoEdificacao;

	@Column(name="PRI_VALID_LICENCAS")
	private Integer priValidLicencas;

	@Column(name="PRI_VIABILIDADE_ASSOCIADA")
	private Integer priViabilidadeAssociada;

	@Column(name="PRI_ZONA_IMOVEL")
	private String priZonaImovel;

	//bi-directional many-to-one association to PscRegistraArquivo
	@ManyToOne
	@JoinColumn(name="PRI_PRA_PROTOCOLO", insertable=false, updatable=false)
	private PscRegistraArquivo pscRegistraArquivo;

	

}