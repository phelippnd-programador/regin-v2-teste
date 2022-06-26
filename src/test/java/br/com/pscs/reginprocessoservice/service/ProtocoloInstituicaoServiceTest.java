package br.com.pscs.reginprocessoservice.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.pscs.reginprocessoservice.contract.ContractAnaliseProtocolo;
import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscProtocoloInstituicaoPK;
import br.com.pscs.reginprocessoservice.model.enums.StatusAreaAnalise;
import br.com.pscs.reginprocessoservice.model.enums.TipoProtocolo;
import br.com.pscs.reginprocessoservice.repository.PscProtocoloInstituicaoRepository;

class ProtocoloInstituicaoServiceTest {
	@InjectMocks
	private ProtocoloInstituicaoService service;
	@Mock
	private PscProtocoloInstituicaoRepository repository;
	@Mock
	private TabInstituicaoGenericaService tabInstituicaoGenericaService;
	@Mock
	private PscRegistraArquivoService pscRegistraArquivoService;
	@Mock
	private PscRespostaInstituicaoService pscRespostaInstituicaoService;
	private ContractAnaliseProtocolo contractAnaliseProtocoloPendente = new ContractAnaliseProtocolo();
	private ContractAnaliseProtocolo contractAnaliseProtocoloReprovado = new ContractAnaliseProtocolo();
	private ContractAnaliseProtocolo contractAnaliseProtocoloAprovado = new ContractAnaliseProtocolo();

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		Mockito.when(pscRegistraArquivoService.pesquisaTipoProtocolo(Mockito.any()))
				.thenReturn(TipoProtocolo.TIPO_PROTOCOLO_ALVARA);
		carregaContractAnaliseProtocolo();
	}
	void carregaContractAnaliseProtocolo(){
		contractAnaliseProtocoloAprovado.setStatus(StatusAreaAnalise.APROVADO);
		contractAnaliseProtocoloPendente.setStatus(StatusAreaAnalise.PENDENTE);
		contractAnaliseProtocoloReprovado.setStatus(StatusAreaAnalise.REPROVADO);
		contractAnaliseProtocoloPendente.setDescricao("");
		contractAnaliseProtocoloPendente.setCpfResposnsavel("13460653736");
		
		contractAnaliseProtocoloReprovado.setDescricao("");
	}

	@Test
	@DisplayName("Deve retornar um erro quando validar uma nova area, e essa mesma area estiver registrada, no processo para analise")
	void deveRetornarExceptionQuandoContiverProtocolo() {
		PscProtocoloInstituicaoPK id = new PscProtocoloInstituicaoPK();
		Mockito.when(pscRegistraArquivoService.pesquisaTipoProtocolo(Mockito.any()))
				.thenReturn(TipoProtocolo.TIPO_PROTOCOLO_ALVARA);
		Mockito.when(repository.existsById(Mockito.any(PscProtocoloInstituicaoPK.class))).thenReturn(true);
		try {
			service.validaNovaArea(id);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Area não pode ser adicionada, pois ela já existe", e.getMessage());
		}
	}

	@Test
	@DisplayName("Não deve retornar um erro quando validar uma nova area e essa mesma area não estiver registrado para a analise")
	void naoDeveRetornarExceptionQuandoNaoContiverProtocolo() {
		PscProtocoloInstituicaoPK id = new PscProtocoloInstituicaoPK();
		Mockito.when(repository.existsById(Mockito.any(PscProtocoloInstituicaoPK.class))).thenReturn(false);
		Mockito.when(
				tabInstituicaoGenericaService.existAtivo(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.anyInt()))
				.thenReturn(false);
		try {
			service.validaNovaArea(id);
		} catch (RuntimeException e) {
			assertNotEquals("Area não pode ser adicionada, pois ela já existe", e.getMessage());
		}

	}

	@Test
	@DisplayName("Deve retornar um erro quando validar uma nova area e ele não conter nos registro das prefeituras")
	void deveReetornarExceptionQuandoExistirAAreaNoBanco() {
		PscProtocoloInstituicaoPK id = new PscProtocoloInstituicaoPK();
		Mockito.when(repository.existsById(Mockito.any(PscProtocoloInstituicaoPK.class))).thenReturn(false);
		Mockito.when(
				tabInstituicaoGenericaService.existAtivo(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.anyInt()))
				.thenReturn(false);
		try {
			service.validaNovaArea(id);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Area não registrada na Tab_Instituicao_Generica", e.getMessage());
		}
	}

	@Test
	@DisplayName("Não deve retornar um erro quando não existir uma area ativa registrada no processo")
	void naoDeveReetornarExceptionQuandoNaoExistirAAreaNoBanco() {
		PscProtocoloInstituicaoPK id = new PscProtocoloInstituicaoPK();
		when(repository.existsById(any(PscProtocoloInstituicaoPK.class))).thenReturn(false);
		when(tabInstituicaoGenericaService.existAtivo(any(), any(), any(), Mockito.anyInt())).thenReturn(true);
		try {
			service.validaNovaArea(id);
		} catch (RuntimeException e) {
			assertNotEquals("Area não registrada na Tab_Instituicao_Generica", e.getMessage());
		}
	}

	@Test
	@DisplayName("Deve retornar um erro quando for analisar e o processo encontra-se finalizado")
	void validacaoAnaliseAreaProcessoFinalizado() {
		when(pscRespostaInstituicaoService.isFinalizado(any(), any())).thenReturn(true);
		try {
			service.validacaoAnaliseArea("", "", contractAnaliseProtocoloPendente);
			fail();
		}catch (RuntimeException e) {
			assertEquals("O processo encontra-se finalizado, por isso não sera possível analizar", e.getMessage());
		}
	}
	@Test
	@DisplayName("Deve retornar um erro quando for analisar e for colocado como pendente e não colocar uma justificativa")
	void validarvalidacaoAnaliseAreaPendente() {
		when(pscRespostaInstituicaoService.isFinalizado(any(), any())).thenReturn(false);
		try {
			service.validacaoAnaliseArea("", "", contractAnaliseProtocoloPendente);
			fail();
		}catch (RuntimeException e) {
			assertEquals("Processos pendentes ou repovados devem conter uma descrição!", e.getMessage());
		}
	}
	@Test
	@DisplayName("Deve retornar um erro quando for analisar e for colocado como pendente e não colocar uma justificativa")
	void validarvalidacaoAnaliseAreaReprovado() {
		when(pscRespostaInstituicaoService.isFinalizado(any(), any())).thenReturn(false);
		try {
			service.validacaoAnaliseArea("", "", contractAnaliseProtocoloReprovado);
			fail();
		}catch (RuntimeException e) {
			assertEquals("Processos pendentes ou repovados devem conter uma descrição!", e.getMessage());
		}
	}
	@Test
	@DisplayName("Deve retornar um erro quando for analisar e for colocado como pendente e não colocar uma justificativa")
	void validarvalidacaoAnalise() {
		when(pscRespostaInstituicaoService.isFinalizado(any(), any())).thenReturn(false);
		
			contractAnaliseProtocoloReprovado.setDescricao("Teste Reprovadp");
			contractAnaliseProtocoloPendente.setDescricao("Teste Pendente");
			service.validacaoAnaliseArea("", "", contractAnaliseProtocoloReprovado);
			assertAll("",
					()->assertDoesNotThrow(()->service.validacaoAnaliseArea("", "", contractAnaliseProtocoloReprovado)),
					()->assertDoesNotThrow(()->service.validacaoAnaliseArea("", "", contractAnaliseProtocoloPendente)),
					()->assertDoesNotThrow(()->service.validacaoAnaliseArea("", "", contractAnaliseProtocoloAprovado))
					);
		
	}

}
