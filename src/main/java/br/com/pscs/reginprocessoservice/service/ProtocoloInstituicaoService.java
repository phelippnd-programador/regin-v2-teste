package br.com.pscs.reginprocessoservice.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.pscs.reginprocessoservice.contract.ContractAnaliseProtocolo;
import br.com.pscs.reginprocessoservice.model.dto.AreaDto;
import br.com.pscs.reginprocessoservice.model.entity.PscProtocoloInstituicao;
import br.com.pscs.reginprocessoservice.model.entity.PscRespostaInstituicao;
import br.com.pscs.reginprocessoservice.model.entity.pk_composta.PscProtocoloInstituicaoPK;
import br.com.pscs.reginprocessoservice.model.enums.StatusAreaAnalise;
import br.com.pscs.reginprocessoservice.model.enums.TipoProtocolo;
import br.com.pscs.reginprocessoservice.repository.PscProtocoloInstituicaoRepository;

/**
 * Serviço responsavel pelas tarefas referente as Areas do processo
 * 
 * @author phelipp
 *
 */
@Service
public class ProtocoloInstituicaoService {
//	private EventoProxy eventoProxy;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private TabInstituicaoGenericaService tabInstituicaoGenericaService;
	@Autowired
	private PscRegistraArquivoService pscRegistraArquivoService;
	@Autowired
	private PscRespostaInstituicaoService pscRespostaInstituicaoService;
	@Autowired
	private PscProtocoloInstituicaoRepository repository;

	public Page<AreaDto> carregaAreasAnaliseAtiva(String praProtocolo, String priTinCnpj, Integer page, Integer size) {
		return pesquisarProtocoloInstitucao(praProtocolo, priTinCnpj, page, size)
				.map(protocoloMap -> toMapper(protocoloMap));
	}

	public Page<PscProtocoloInstituicao> pesquisarProtocoloInstitucao(String praProtocolo, String priTinCnpj, Integer page,
			Integer size) {
		return repository.findByNumeroProcessoAndCnpjInstituicao(praProtocolo, priTinCnpj, PageRequest.of(page, size));
	}

	public List<AreaDto> carregaAreasAnaliseAtiva(String praProtocolo, String priTinCnpj) {
		return findProtocoloInstitucao(praProtocolo, priTinCnpj).stream().map(protocoloMap -> toMapper(protocoloMap))
				.toList();
	}

	public List<PscProtocoloInstituicao> findProtocoloInstitucao(String praProtocolo, String priTinCnpj) {
		return repository.findByNumeroProcessoAndCnpjInstituicao(praProtocolo, priTinCnpj)
				.orElseThrow(() -> new RuntimeException("Areas Não encontradas !"));
	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public void analiseArea(String cnpjInstituicao, String numeroProcesso,
			ContractAnaliseProtocolo contractAnaliseProtocolo) {
		validacaoAnaliseArea(cnpjInstituicao, numeroProcesso, contractAnaliseProtocolo);
		PscProtocoloInstituicaoPK id = modelMapper.map(contractAnaliseProtocolo, PscProtocoloInstituicaoPK.class);
		id.setPpiTigTinCnpj(cnpjInstituicao);
		id.setPpiProProtocolo(numeroProcesso);
		PscProtocoloInstituicao pscProtocoloInstituicao = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Area não encontrada!"));
		pscProtocoloInstituicao.setPpiDescPesquisa(contractAnaliseProtocolo.getDescricao());
		pscProtocoloInstituicao.setPpiStatusPesquisa(contractAnaliseProtocolo.getStatus().getValue());
		pscProtocoloInstituicao.setPpiTirCpfResp(contractAnaliseProtocolo.getCpfResposnsavel());
		pscProtocoloInstituicao.setPpiFecRespuesta(LocalDateTime.now());
		repository.save(pscProtocoloInstituicao);
		// Area envia dados para o gerador de xml - para que possa enviar
//		geraXml();
	}

	public void validacaoAnaliseArea(String cnpjInstituicao, String numeroProcesso, ContractAnaliseProtocolo value) {
		if (pscRespostaInstituicaoService.isFinalizado(cnpjInstituicao, numeroProcesso)) {
			throw new RuntimeException("O processo encontra-se finalizado, por isso não sera possível analizar");
		}
		if ((value.getStatus().equals(StatusAreaAnalise.PENDENTE)
				|| value.getStatus().equals(StatusAreaAnalise.REPROVADO)) 
			&& value.getDescricao().isBlank()) {
			throw new RuntimeException("Processos pendentes ou repovados devem conter uma descrição!");
		}

	}

	public Optional<List<AreaDto>> carregaAreasAnaliseInativa(String numeroProcesso, String cnpjInstituicao) {
		TipoProtocolo tipoProtocolo = pscRegistraArquivoService.pesquisaTipoProtocolo(numeroProcesso);
		List<Integer> codTipTabAtivas = carregaAreasAnaliseAtiva(numeroProcesso, cnpjInstituicao).stream()
				.map(areas -> areas.getId().getPpiTigTgeCodTipTab()).collect(Collectors.toList());
		// Codigo de area de documento
		codTipTabAtivas.add(999);
		List<AreaDto> tabelasExtras = tabInstituicaoGenericaService
				.areasDesativadas(codTipTabAtivas, tipoProtocolo, cnpjInstituicao).stream().map(tab -> {
					AreaDto areaDto = new AreaDto();
					PscProtocoloInstituicaoPK id = new PscProtocoloInstituicaoPK();
					id.setPpiProProtocolo(numeroProcesso);
					id.setPpiTigTinCnpj(cnpjInstituicao);
					id.setPpiTigTgeTipTab(tab.getId().getTigTgeTipTab());
					id.setPpiTigTgeCodTipTab(tab.getId().getTigTgeCodTipTab());
					areaDto.setId(id);
					areaDto.setTabGenericaTgeNombDesc(tab.getTabGenerica().getTgeNombDesc());
					return areaDto;
				}).toList();
		return (tabelasExtras.size() > 0) ? Optional.of(tabelasExtras) : Optional.empty();
	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public AreaDto adicionaArea(PscProtocoloInstituicaoPK id) {
		validaNovaArea(id);
		PscProtocoloInstituicao pscProtocoloInstituicao = new PscProtocoloInstituicao();
		pscProtocoloInstituicao.setId(id);
		pscProtocoloInstituicao.setPpiFecEnvio(LocalDateTime.now());
		pscProtocoloInstituicao.setPpiStatusPesquisa(1);
		AreaDto areaRetorno = modelMapper.map(repository.save(pscProtocoloInstituicao), AreaDto.class);
		// Envia mensagem servico mensageria na fila de eventos
		return areaRetorno;
	}

	public void validaNovaArea(PscProtocoloInstituicaoPK id) {
		TipoProtocolo tipoProtocolo = null;
		if (repository.existsById(id)) {
			throw new RuntimeException("Area não pode ser adicionada, pois ela já existe");
		}
		tipoProtocolo = pscRegistraArquivoService.pesquisaTipoProtocolo(id.getPpiProProtocolo());
		if (tipoProtocolo.compareTo(TipoProtocolo.NULL) == 0) {
			throw new RuntimeException("Tipo protocolo não encontrado");
		}
		if (!tabInstituicaoGenericaService.existAtivo(id.getPpiTigTgeCodTipTab(), id.getPpiTigTgeTipTab(),
				id.getPpiTigTinCnpj(), tipoProtocolo.getTipoArea())) {
			throw new RuntimeException("Area não registrada na Tab_Instituicao_Generica");
		}
//		lista das areas do processo
	}

	public AreaDto toMapper(PscProtocoloInstituicao value) {
		AreaDto map = modelMapper.map(value, AreaDto.class);
		StatusAreaAnalise status = converterToStatusAreaAnalise(value.getPpiStatusPesquisa())
				.orElse(StatusAreaAnalise.NAO_INFORMADO);
		map.setStatus(status);
		return map;
	}

	public Optional<StatusAreaAnalise> converterToStatusAreaAnalise(Integer praTipoProtocolo) {
		List<StatusAreaAnalise> tipoProtocolo = Arrays.asList(StatusAreaAnalise.values()).stream()
				.filter(tipo -> tipo.getValue().compareTo(praTipoProtocolo) == 0).toList();
		return tipoProtocolo.size() > 0 ? Optional.of(tipoProtocolo.get(0)) : Optional.empty();
	}
}
