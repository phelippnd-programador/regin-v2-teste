package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.com.pscs.reginprocessoservice.model.entity.embededid.ProtocoloInstituicaoEmbeddedId;
import lombok.Data;
@Data
@Entity
@Table(name = "psc_protocolo_instituicao")
/**
 * Responsavel por informar as areas para analises ativas do protocolo
 * @author pdama
 *
 */
public class PscProtocoloInstituicaoEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	// TODO Auto-generated constructor stub
	@EmbeddedId
	private ProtocoloInstituicaoEmbeddedId id;
	private String ppiProProtocolo;
	private String ppiTigTinCnpj;

	@Type(type = "timestamp")
	private LocalDateTime ppiFecEnvio;

	@Type(type = "timestamp")
	private LocalDateTime ppiFecRespuesta;

	private Integer ppiTigTgeTipTab;

	private Integer ppiTigTgeCodTipTab;

	private Integer ppiStatusPesquisa;

	private String ppiDescPesquisa;

	private String ppiTirCpfResp;

	private String ppiNumeroProcesso;

	private Integer ppiFlagAnaliseAuto;

	private Long ppiTdoId;

	@Type(type = "timestamp")
	private LocalDateTime ppiDataValidade;

	private Integer ppiFlagDeclaraEstado;

	private Integer ppiFlagEnvioDelega;

	@Type(type = "timestamp")
	private LocalDateTime ppiDataEmissaoNumeroProc;
}
