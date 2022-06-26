package br.com.pscs.reginprocessoservice.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cadastroIptu;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String areaConstruida;
	private String latitude;
	private String longitude;
	private String referencia;
	private String municipio;
	private String estado;
	
}
