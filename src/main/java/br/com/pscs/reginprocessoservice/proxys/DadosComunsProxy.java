package br.com.pscs.reginprocessoservice.proxys;

import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient
public interface DadosComunsProxy {
	/**
	 * Tabela de consulta (tab_natureza_juridica)
	 * 
	 * @param rcoTncCodNatur
	 * @return
	 */
	String findDescricaoNaturezaJuridica(Integer codigoNaturezaJuridica);

	/**
	 * Tabela de consulta tab_generica
	 * 
	 * @param praTgeTipTab
	 * @param praTgeCodTipTab
	 * @return
	 */
	String getDescricaoTabGenerica(Integer praTgeTipTab, Integer praTgeCodTipTab);

}
