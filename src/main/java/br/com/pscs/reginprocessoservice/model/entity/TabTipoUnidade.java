package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tab_tipo_unidade database table.
 * 
 */
@Entity
@Table(name="tab_tipo_unidade")
@NamedQuery(name="TabTipoUnidade.findAll", query="SELECT t FROM TabTipoUnidade t")
public class TabTipoUnidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ttu_id")
	private int ttuId;

	@Column(name="ttu_codigo")
	private String ttuCodigo;

	@Column(name="ttu_descricao")
	private String ttuDescricao;

	public TabTipoUnidade() {
	}

	public int getTtuId() {
		return this.ttuId;
	}

	public void setTtuId(int ttuId) {
		this.ttuId = ttuId;
	}

	public String getTtuCodigo() {
		return this.ttuCodigo;
	}

	public void setTtuCodigo(String ttuCodigo) {
		this.ttuCodigo = ttuCodigo;
	}

	public String getTtuDescricao() {
		return this.ttuDescricao;
	}

	public void setTtuDescricao(String ttuDescricao) {
		this.ttuDescricao = ttuDescricao;
	}

}