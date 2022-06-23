package br.com.pscs.reginprocessoservice.model.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Passar para um serviço externo para consulta de dados generiocos
 * api-Dados-regin
 * 
 * @author pdama
 *
 */
@Data
@Entity
@Table(name = "tab_natureza_juridica")
public class TabNaturezaJuridicaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer tnjCoNaturezaJuridica;
	private String tnjDsNaturezaJuridica;
}
