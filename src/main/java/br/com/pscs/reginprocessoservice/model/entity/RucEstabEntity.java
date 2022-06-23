package br.com.pscs.reginprocessoservice.model.entity;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
@Table(name = "ruc_estab_entity")
public class RucEstabEntity {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Integer resTipEstab;

	private Integer resTgeTtipReg;

	private Integer resTgeVtipReg;

	private Integer resTgeTcondUso;

	private Integer resTgeVcondUso;

	private String resSigl;

	private Long resArea;

	private Integer resTgeTuniMedid;

	private Integer resTgeVuniMedid;

	private String resFecInic;

	private String resFecFin;

	private String resNume;

	private String resCajaPo;

	private String resZonaCajaPo;

	private String resTusCodUsr;

	private String resNomEstab;

	private String resNumRegProp;

	private String resQuadLote;

	private String resIdentComp;

	private String resRefer;

	private String resTtlTipLogradoro;

	private String resDireccion;

	private String resUrbanizacion;

	private String resTesCodEstado;

	private String resZonaPostal;

	private Integer resTmuCodMun;

	private String resMotivoInscricao;

	private String resDsEvento;

	@Type(type = "timestap")
	private LocalDateTime resDtEventoInicio;

	@Type(type = "timestap")
	private LocalDateTime resDtEventoFim;

}
