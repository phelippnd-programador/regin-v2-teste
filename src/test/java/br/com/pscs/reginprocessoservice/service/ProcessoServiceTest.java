package br.com.pscs.reginprocessoservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class ProcessoServiceTest {
	@InjectMocks
	private ProcessoService service;
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void converterTipoProtocolo() {
		assertAll("",
				()->assertEquals("Alteração sem validação da prefeitura", service.converterTipoProtocolo(2)),
				()->assertEquals("Pedido Alvará", service.converterTipoProtocolo(3)),
				()->assertEquals("Estudo de viabilidade", service.converterTipoProtocolo(5)),
				()->assertEquals("Pedido de MEI", service.converterTipoProtocolo(7)),
				()->assertEquals("Estudo de viabilidade de MEI", service.converterTipoProtocolo(8)),
				()->assertEquals("Pedido de Unidade Dependente", service.converterTipoProtocolo(21)),
				()->assertEquals("Processos da RFB", service.converterTipoProtocolo(27)),
				()->assertEquals("Alteração de MEI", service.converterTipoProtocolo(28)),
				()->assertEquals("N/A", service.converterTipoProtocolo(0))
				);
		
	}
	

}
