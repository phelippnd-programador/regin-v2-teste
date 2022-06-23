package br.com.pscs.reginprocessoservice.model.dto;

import java.io.Serializable;

import br.com.pscs.reginprocessoservice.model.enums.StatusAreaAnalise;

public class AreaDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer codigoTab;
	private Integer codigoArea;
	private String areaTitulo;
	private String justificativa;
	private StatusAreaAnalise status;
	
}
