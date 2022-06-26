package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscProtocoloInstituicaoPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the psc_protocolo_instituicao_copy database table.
 * 
 */
@Data
@Entity
@Table(name="psc_protocolo_instituicao")
@AllArgsConstructor
@NoArgsConstructor
public class PscProtocoloInstituicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PscProtocoloInstituicaoPK id;

	@Lob
	@Column(name="PPI_DESC_PESQUISA")
	private String ppiDescPesquisa;

//	@Type(type="timestamp")
	@Column(name="PPI_FEC_ENVIO")
	private LocalDateTime ppiFecEnvio;

//	@Type(type="timestamp")
	@Column(name="PPI_FEC_RESPUESTA")
	private LocalDateTime ppiFecRespuesta;

	@Column(name="PPI_STATUS_PESQUISA")
	private Integer ppiStatusPesquisa;

	@Column(name="PPI_TIR_CPF_RESP")
	private String ppiTirCpfResp;
	@ManyToOne(fetch = FetchType.LAZY ) 
	@JoinColumns( {
			@JoinColumn( name = "PPI_TIG_TGE_COD_TIP_TAB", referencedColumnName = "TGE_COD_TIP_TAB",insertable=false, updatable=false),
			@JoinColumn(name = "PPI_TIG_TGE_TIP_TAB", referencedColumnName = "TGE_TIP_TAB",insertable=false, updatable=false) 
			})
	private TabGenerica tabGenerica;
	
	

}