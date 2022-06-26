package br.com.pscs.reginprocessoservice.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class DetalheDto implements Serializable {
	private String instituicaoOrigem;
	private String cpfCidadao;
	private String acao;
	private String eventos;
	private String nome;
	private String protocolo;
	private String nire;
	private String inscricaoEstadual;
	private String naturezaJuridica;
	private String tipoPedido;
	private String tipoUnidade;
	private List<String> telefones;
	private LocalDateTime dataProtocolo;
	private String cnpj;
	private String tipoRegistro;
	private String formaDeAtuacao;
	private String email;
	// ----------------------------------------//
	private String numeroAlvara;
	private LocalDateTime dataConcessaoAlvara;
	private String nomeFantasia;
	private String capitalSocial;
	private LocalDateTime dataInicioAtividade;
	private String enquadramentoFiscal;
	private String objetoSocial;
	// Cad. Imobiliário / Inscr. Municipal
	private String inscricaoMunicipal;
	private String cadastroMobiliario;
	private String tipoEstabelecimento;
	private boolean substitutoTributario;
	// -----------Estabeliciemento----------//
	private String iptu;
	private EnderecoDto enderecoDto;
	
	// ----------------------------------------//
	private AtividadeExercidaDto atividadesExercidas;

	// ----------------------------------------//
	private Map<String,Object> informacoesAdicionais;	
	
	// ----------------------------------------//
	private String zoneamento;
	private String categoriaUso;
	private String observacao;
	private List<AreaDto> areasAnalise;
	private List<AreaDto> areasAnaliseDesabilitada;
	

}
