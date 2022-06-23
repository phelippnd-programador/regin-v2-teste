package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name = "registra_arquivo" )
@Data
public class PscRegistraArquivoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String praProtocolo;
	private String praCnpj;
	private Integer praStatus;
	@Type(type = "timestamp")
	private LocalDateTime praFecInc;
	private String praDescErroProc;

	/** The pra fec recebido. */
	@Type(type = "timestamp")
	private LocalDateTime praFecRecebido;
	/** The pra tipo protocolo. */
	private Integer praTipoProtocolo;

	/** The pra tge tip tab. */
	private Integer praTgeTipTab;

	/** The pra tge cod tip tab. */
	private Integer praTgeCodTipTab;

	/** The pra alvara. */
	private String praAlvara;

	/** The pra status carga txt. */
	private Integer praStatusCargaTxt;

	/** The pra fec envio sefaz. */
	@Type(type = "timestamp")
	private LocalDateTime praFecEnvioSefaz;

	/** The pra resposta sefaz. */
	private String praRespostaSefaz;

	/** The pra status envio sefaz. */
	private Integer praStatusEnvioSefaz;
	@Type(type = "timestamp")
	private LocalDateTime praFecCarregado;

	/** Identificador que o processo é de origem automatico **/
	private Integer praProcessoAutomatico;
	
}
