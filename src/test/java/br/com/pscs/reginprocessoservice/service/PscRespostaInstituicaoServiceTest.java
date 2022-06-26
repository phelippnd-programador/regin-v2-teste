package br.com.pscs.reginprocessoservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.mockito.MockitoAnnotations;

import br.com.pscs.reginprocessoservice.model.entity.PscRespostaInstituicao;
import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscRespostaInstituicaoPK;
import br.com.pscs.reginprocessoservice.model.enums.StatusProcesso;
import br.com.pscs.reginprocessoservice.repository.PscRespostaInstituicaoRepository;

class PscRespostaInstituicaoServiceTest {
	@InjectMocks
	private PscRespostaInstituicaoService service;
	private PscRespostaInstituicaoPK processoFechado = new PscRespostaInstituicaoPK();
	private PscRespostaInstituicaoPK processoAberto = new PscRespostaInstituicaoPK();
	Optional<PscRespostaInstituicao> respostaFechadoOptional;
	Optional<PscRespostaInstituicao> respostaAbertoOptional;
	@Mock
	private PscRespostaInstituicaoRepository repository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		carregaRepostas();
		
	}
	public void carregaRepostas() {
		processoFechado.setPriPraProtocolo("1234");
		processoAberto.setPriPraProtocolo("123456");
		PscRespostaInstituicao respostaFechado = new PscRespostaInstituicao();
		PscRespostaInstituicao respostaAberto = new PscRespostaInstituicao();
		respostaAberto.setPriStatus(StatusProcesso.NOVO.getValue());
		respostaFechado.setPriStatus(StatusProcesso.FINALIZADO.getValue());
		respostaAbertoOptional = Optional.of(respostaAberto);
		respostaFechadoOptional = Optional.of(respostaFechado);
		when(repository.findById(processoFechado)).thenReturn(respostaFechadoOptional);
		when(repository.findById(processoAberto)).thenReturn(respostaAbertoOptional);
	}

	@Test
	void finalizado() {
		assertAll("Processo finalizado", () -> assertTrue(service.isFinalizado(processoFechado)),
				() -> assertFalse(service.isFinalizado(processoAberto))

		);
	}

}
