package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.com.pscs.reginprocessoservice.model.entity.embededid.RespostaInstituicaoEmbeddedId;
import lombok.Data;

@Data
@Entity
@Table(name = "psc_resposta_intituicao")
public class PscRespostaInstituicaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RespostaInstituicaoEmbeddedId id;
	
	private String priIss;
	
	private String priIptu;
	
	@Type(type = "timestamp")
	private LocalDateTime priFecAtual;
	
	@Type(type = "timestamp")
	private LocalDateTime priFecExtracao;
	
	@Type(type = "timestamp")
	private LocalDateTime priFecRetorno;
	
	private String priTirCpfResp;
	
	private String priTxZoneamento;
	
	private String priTxCategoriaUso;
	
	private Integer priFlagAvaliacao;
	
	private Integer priFlagAlterado;
	
	private Integer priStatus;
	
	private String priAlvaraLicenciamento;
	
	private String priRespAnalisando;
	
	@Type(type = "timestamp")
	private LocalDateTime priRespDataIniAnalise;

	private String priInscricaoMunicipal;

	private String priLat;

	private String priLon;

	private String priAlt;

	private String priPre;

	private Integer priFlagAnaliseAuto;

	private Integer priStatusEnviaInst;

	private String priStatusEnviaInstDesc;

	private String priObservacaoDoc;

	private Integer priInteresseInst;
	
	@Type(type = "timestamp")
	private LocalDateTime priDataValidade;

	private String priUsoEdificacao;

	private String priZonaImovel;

	private String priSequencialImovel;

	private String priNomeAprovado;

	private Integer priIdOrgaoRegistro;

	private Integer priEmitiuAlvaraProv;
	
	@Type(type = "timestamp")
	private LocalDateTime priEmitiuAlvaraProvData;
	
	private String priFlagDocGerado;
	
	@Type(type = "timestamp")
	private LocalDateTime priDataEmissaoAlvara;
	
	@Type(type = "timestamp")
	private LocalDateTime priDataEmissaoIptu;
	
	@Type(type = "timestamp")
	private LocalDateTime priDataEmissaoIss;

	private String priFlagAlvaraCancelado;

	private String priTxtJustificativaCancelamento;

	private String priCpfUsuarioCancelaAlvara;

	private String priDataCancelaAlvara;

	private Integer priFlagCopiaViab;
}
