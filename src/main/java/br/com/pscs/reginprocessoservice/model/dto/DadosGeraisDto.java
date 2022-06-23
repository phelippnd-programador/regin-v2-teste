package br.com.pscs.reginprocessoservice.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class DadosGeraisDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String protocolo;
	private String cnpjInstituicao;
	private String instituicaoOrigemProcesso;
	private String eventos;
	private String nome;
	private LocalDate dataProtocolo;
	private String cpfOuCNPJdoSolicitante;
	private String naturezaJuridica	;
	private String tipoPedido;
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	public String getCnpjInstituicao() {
		return cnpjInstituicao;
	}
	public void setCnpjInstituicao(String cnpjInstituicao) {
		this.cnpjInstituicao = cnpjInstituicao;
	}
	public String getInstituicaoOrigemProcesso() {
		return instituicaoOrigemProcesso;
	}
	public void setInstituicaoOrigemProcesso(String instituicaoOrigemProcesso) {
		this.instituicaoOrigemProcesso = instituicaoOrigemProcesso;
	}
	public String getEventos() {
		return eventos;
	}
	public void setEventos(String eventos) {
		this.eventos = eventos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataProtocolo() {
		return dataProtocolo;
	}
	public void setDataProtocolo(LocalDate dataProtocolo) {
		this.dataProtocolo = dataProtocolo;
	}
	public String getCpfOuCNPJdoSolicitante() {
		return cpfOuCNPJdoSolicitante;
	}
	public void setCpfOuCNPJdoSolicitante(String cpfOuCNPJdoSolicitante) {
		this.cpfOuCNPJdoSolicitante = cpfOuCNPJdoSolicitante;
	}
	public String getNaturezaJuridica() {
		return naturezaJuridica;
	}
	public void setNaturezaJuridica(String naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}
	public String getTipoPedido() {
		return tipoPedido;
	}
	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	
	

}
