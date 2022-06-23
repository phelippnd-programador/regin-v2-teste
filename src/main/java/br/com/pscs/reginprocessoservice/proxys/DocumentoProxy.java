package br.com.pscs.reginprocessoservice.proxys;

import org.springframework.cloud.openfeign.FeignClient;

import br.com.pscs.contracts.api_documento.ContractDocumentoDto;


@FeignClient(name = "documento")
public interface  DocumentoProxy {
	public void gerarDocumento(ContractDocumentoDto contractDocumentoDto);
	public void geraXml(String numeroProcesso);
}
