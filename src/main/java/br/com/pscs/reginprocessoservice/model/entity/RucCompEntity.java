package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "ruc_comp")
public class RucCompEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/** The rco rge pra protocolo. */
	@Id
	private String rcoRgePraProtocolo;
	/** The rco fec const nasc. */
	@Type(type = "timestamp")
	private LocalDateTime rcoFecConstNasc;

	/** The rco num reg merc. */
	private String rcoNumRegMerc;

	/** The rco fec reg merc. */
	@Type(type = "timestamp")
	private LocalDateTime rcoFecRegMerc;

	/** The rco tge ttip doc. */
	private Integer rcoTgeTtipDoc;

	/** The rco tge vtip doc. */
	private Integer rcoTgeVtipDoc;

	/** The rco num doc ident. */
	private String rcoNumDocIdent;

	/** The rco fec emi doc id. */
	@Type(type = "timestamp")
	private LocalDateTime rcoFecEmiDocId;

	/** The rco tnc cod natur. */
	private Integer rcoTncCodNatur;

	/** The rco domic pais. */
	private Integer rcoDomicPais;

	/** The rco fec incorp. */
	@Type(type = "timestamp")
	private LocalDateTime rcoFecIncorp;

	/** The rco val cap soc. */
	private BigDecimal rcoValCapSoc;

	/** The rco fec rg cap soc. */
	@Type(type = "timestamp")
	private LocalDateTime rcoFecRgCapSoc;

	/** The rco sexo. */
	private Integer rcoSexo;

	/** The rco nume. */
	private String rcoNume;

	/** The rco caja po. */
	private String rcoCajaPo;

	/** The rco zona caja po. */
	private String rcoZonaCajaPo;

	/** The rco tge tpais. */
	private Integer rcoTgeTpais;

	/** The rco tge vpais. */
	private Integer rcoTgeVpais;

	/** The rco ruc ext uf. */
	private String rcoRucExtUf;

	/** The rco tus cod usr. */
	private String rcoTusCodUsr;

	/** The rco emis doc ident. */
	private String rcoEmisDocIdent;

	/** The rco quad lote. */
	private String rcoQuadLote;

	/** The rco ident comp. */
	private String rcoIdentComp;

	/** The rco refer. */
	private String rcoRefer;

	/** The rco lic mun. */
	private String rcoLicMun;

	/** The rco ttl tip logradoro. */
	private String rcoTtlTipLogradoro;

	/** The rco direccion. */
	private String rcoDireccion;

	/** The rco urbanizacion. */
	private String rcoUrbanizacion;

	/** The rco tes cod estado. */
	private String rcoTesCodEstado;

	/** The rco zona postal. */
	private String rcoZonaPostal;

	/** The rco tge tcier bal. */
	private Integer rcoTgeTcierBal;

	/** The rco tge vcier bal. */
	private Integer rcoTgeVcierBal;

	/** The rco tge treg trib. */
	private Integer rcoTgeTregTrib;

	/** The rco tge vreg trib. */
	private Integer rcoTgeVregTrib;

	/** The rco tmu cod mun. */
	private Integer rcoTmuCodMun;
}
