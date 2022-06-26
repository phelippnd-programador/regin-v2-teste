package br.com.pscs.reginprocessoservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pscs.reginprocessoservice.model.dto.DetalheDto;
import br.com.pscs.reginprocessoservice.model.entity.PscProtEventoRfb;
import br.com.pscs.reginprocessoservice.model.entity.PscRegistraArquivo;
import br.com.pscs.reginprocessoservice.model.entity.PscRespostaInstituicao;
import br.com.pscs.reginprocessoservice.model.entity.RucComp;
import br.com.pscs.reginprocessoservice.model.entity.RucEstab;
import br.com.pscs.reginprocessoservice.model.entity.RucGeneral;
import br.com.pscs.reginprocessoservice.model.entity.TabGenerica;
import br.com.pscs.reginprocessoservice.model.entity.TabInformExtraJunta;
import br.com.pscs.reginprocessoservice.model.enums.TipoProtocolo;
import br.com.pscs.reginprocessoservice.proxys.DadosComunsProxy;
import br.com.pscs.reginprocessoservice.repository.PscProtocoloInstituicaoRepository;
import br.com.pscs.reginprocessoservice.repository.PscRespostaInstituicaoRepository;

@Service
public class ProcessoService {
	@Autowired
	private ProtocoloInstituicaoService pscProtocoloInstituicaoService;
	@Autowired
	private TabGenericaService tabGenericaService;
	@Autowired
	private DadosEmpresaService dadosEmpresaService;
//	@Autowired
//	private DadosComunsProxy dadosComunsProxy;
	PscProtocoloInstituicaoRepository protocoloInstituicao;
	PscRespostaInstituicaoRepository respostaInstituicao;
	RucEstab rucEstab;

	public DetalheDto carregaDetalhe(String numeroProcesso, String cnpjInstituicao) {
		
		DetalheDto detalheDto = new DetalheDto();
		PscProtEventoRfb pscProtEventoRfb = null;
		RucComp rucComp = null;
		PscRespostaInstituicao respostaInstituicao =null ;
		PscRegistraArquivo pscRegistraArquivo = null;
		TabInformExtraJunta tabInformExtraJunta = null;
		RucGeneral rucGeneral =null;
		TabGenerica tabGenerica = null;
		
		
//		detalheDto.setAcao(dadosComunsProxy.getDescricaoTabGenerica(pscRegistraArquivo.getPraTgeTipTab(),pscRegistraArquivo.getPraTgeCodTipTab()));
		detalheDto.setEventos(pscProtEventoRfb.getPevNomeEvento());
		detalheDto.setNome(rucEstab.getResNomEstab());
		detalheDto.setProtocolo(pscRegistraArquivo.getPraProtocolo());
		detalheDto.setNire(rucComp.getRcoNumRegMerc());
		detalheDto.setInscricaoEstadual("Somente em santa catarina. Tabela de acesso Ruc_General campo - RGE_RUC");
//		detalheDto.setNaturezaJuridica(dadosComunsProxy.findDescricaoNaturezaJuridica(rucComp.getRcoTncCodNatur()));
//		detalheDto.setTipoPedido(tabInformExtraJunta.getTipoUnidadeDesc());
		
		detalheDto.setTipoUnidade(carregaUnidadeRelacaoEmpresa(pscRegistraArquivo.getPraProtocolo()));
		detalheDto.setTelefones(dadosEmpresaService.telefoneEmpresa(pscRegistraArquivo.getPraProtocolo()));
		detalheDto.setDataProtocolo(pscRegistraArquivo.getPraFecInc());
		
		detalheDto.setCnpj(rucGeneral.getRgeCgcCpf());
		detalheDto.setTipoRegistro(tabGenerica.getTgeNombDesc());
		
//		detalheDto.setFormaDeAtuacao(tabInformExtraJunta.getFormasAtuacao());
		detalheDto.setEmail(tabInformExtraJunta.getTieEmail());
		
		// dados inseridos pelo usuario
		detalheDto.setNumeroAlvara(respostaInstituicao.getPriAlvaraLicenciamento());
		detalheDto.setDataConcessaoAlvara(respostaInstituicao.getPriDataEmissaoAlvara());
		detalheDto.setInscricaoMunicipal(respostaInstituicao.getPriInscricaoMunicipal());
		detalheDto.setCadastroMobiliario(respostaInstituicao.getPriIss());
		// Dados do estabelecimento
		detalheDto.setNomeFantasia(rucEstab.getResNomEstab());
		detalheDto.setCapitalSocial(rucComp.getRcoValCapSoc().toString());
		detalheDto.setDataInicioAtividade(rucComp.getRcoFecConstNasc());
		detalheDto.setEnquadramentoFiscal(tabGenerica.getTgeNombDesc());
		
		detalheDto.setTipoEstabelecimento("");
		detalheDto.setSubstitutoTributario(false);
		detalheDto.setObjetoSocial("");
		
		// ----------------------------------------- //
		detalheDto.setIptu(respostaInstituicao.getPriIptu());
		detalheDto.setEnderecoDto(dadosEmpresaService.carregaEndereco(pscRegistraArquivo.getPraProtocolo()));
		
		detalheDto.setZoneamento(respostaInstituicao.getPriTxZoneamento());
		detalheDto.setCategoriaUso(respostaInstituicao.getPriTxCategoriaUso());
		detalheDto.setObservacao(respostaInstituicao.getPriObservacaoDoc());
//		detalheDto.setAreasAnalise(protocoloInstituicaoService.carregaAreasAnalise(pscRegistraArquivo.getPraProtocolo(),respostaInstituicao.getId().getPriTinCnpj()));
//		detalheDto.setAreasAnaliseDesabilitada(protocoloInstituicaoService.carregaAreasAnaliseDesabilitada(pscRegistraArquivo.getPraProtocolo(),respostaInstituicao.getId().getPriTinCnpj()));
		return detalheDto;
	}


	


	private String carregaUnidadeRelacaoEmpresa(String praProtocolo) {

		return null;
	}

	// Verificar onde é o melhor local para colocar
	public String converterTipoProtocolo(Integer praTipoProtocolo) {
		List<String> collect = Arrays.asList(TipoProtocolo.values()).stream()
				.filter(tipo -> tipo.getValue().compareTo(praTipoProtocolo) == 0).map(item -> item.getDescricao())
				.collect(Collectors.toList());
		return (collect.size() > 0) ? collect.get(0) : "N/A";

	}

}
