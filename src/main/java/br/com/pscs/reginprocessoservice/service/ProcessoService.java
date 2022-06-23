package br.com.pscs.reginprocessoservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pscs.reginprocessoservice.model.dto.DetalheDto;
import br.com.pscs.reginprocessoservice.model.entity.PscProtEventoRfbEntity;
import br.com.pscs.reginprocessoservice.model.entity.PscRegistraArquivoEntity;
import br.com.pscs.reginprocessoservice.model.entity.PscRespostaInstituicaoEntity;
import br.com.pscs.reginprocessoservice.model.entity.RucCompEntity;
import br.com.pscs.reginprocessoservice.model.entity.RucEstabEntity;
import br.com.pscs.reginprocessoservice.model.entity.RucGeneralEntity;
import br.com.pscs.reginprocessoservice.model.entity.TabGenericaEntity;
import br.com.pscs.reginprocessoservice.model.entity.TabInformExtraJuntaEntity;
import br.com.pscs.reginprocessoservice.model.enums.TipoProtocolo;
import br.com.pscs.reginprocessoservice.proxys.DadosComunsProxy;
import br.com.pscs.reginprocessoservice.repository.PscProtocoloInstituicaoRepository;
import br.com.pscs.reginprocessoservice.repository.PscRespostaInstituicaoRepository;
import br.com.pscs.reginprocessoservice.repository.RucCompRepository;

@Service
public class ProcessoService {
	@Autowired
	private TabGenericaService tabGenericaService;
	@Autowired
	private DadosComunsProxy dadosComunsProxy;
	PscProtocoloInstituicaoRepository protocoloInstituicao;
	PscRespostaInstituicaoRepository respostaInstituicao;
	RucEstabEntity rucEstab;
	public DetalheDto carregaDetalhe(String numeroProcesso, String cnpjInstituicao) {
		
		DetalheDto detalheDto = new DetalheDto();
		PscProtEventoRfbEntity pscProtEventoRfbEntity = null;
		RucCompEntity rucCompEntity = null;
		PscRespostaInstituicaoEntity respostaInstituicao =null ;
		PscRegistraArquivoEntity pscRegistraArquivo = null;
		TabInformExtraJuntaEntity tabInformExtraJunta = null;
		RucGeneralEntity rucGeneral =null;
		TabGenericaEntity tabGenerica = null;
		
		detalheDto.setAcao(dadosComunsProxy.getDescricaoTabGenerica(pscRegistraArquivo.getPraTgeTipTab(),pscRegistraArquivo.getPraTgeCodTipTab()));
		detalheDto.setEventos(pscProtEventoRfbEntity.getPevNomeEvento());
		detalheDto.setNome(rucEstab.getResNomEstab());
		detalheDto.setProtocolo(rucCompEntity.getRcoRgePraProtocolo());
		detalheDto.setNire(rucCompEntity.getRcoNumRegMerc());
		detalheDto.setInscricaoEstadual("Somente em santa catarina. Tabela de acesso Ruc_General campo - RGE_RUC");
		detalheDto.setNaturezaJuridica(dadosComunsProxy.findDescricaoNaturezaJuridica(rucCompEntity.getRcoTncCodNatur()));
		detalheDto.setTipoPedido(tabInformExtraJunta.getTipoUnidadeDesc());
		
		detalheDto.setTipoUnidade(carregaUnidadeRelacaoEmpresa(pscRegistraArquivo.getPraProtocolo()));
		detalheDto.setTelefones(extraiTelefones(tabInformExtraJunta));
		detalheDto.setDataProtocolo(pscRegistraArquivo.getPraFecInc());
		
		detalheDto.setCnpj(rucGeneral.getRgeCgcCpf());
		detalheDto.setTipoRegistro(tabGenerica.getTgeNombDesc());
		
		detalheDto.setFormaDeAtuacao(tabInformExtraJunta.getFormasAtuacao());
		detalheDto.setEmail(tabInformExtraJunta.getTieEmail());
		
		// dados inseridos pelo usuario
		detalheDto.setNumeroAlvara(respostaInstituicao.getPriAlvaraLicenciamento());
		detalheDto.setDataConcessaoAlvara(respostaInstituicao.getPriDataEmissaoAlvara());
		detalheDto.setInscricaoMunicipal(respostaInstituicao.getPriInscricaoMunicipal());
		detalheDto.setCadastroMobiliario(respostaInstituicao.getPriIss());
		// Dados do estabelecimento
		detalheDto.setNomeFantasia(rucEstab.getResNomEstab());
		detalheDto.setCapitalSocial(rucCompEntity.getRcoValCapSoc().toString());
		detalheDto.setDataInicioAtividade(rucCompEntity.getRcoFecConstNasc());
		detalheDto.setEnquadramentoFiscal(tabGenerica.getTgeNombDesc());
		detalheDto.setTipoEstabelecimento( );

		return detalheDto;
	}
	private List<String> extraiTelefones(TabInformExtraJuntaEntity tabInformExtraJunta) {
		List<String> numerosTelefones = new ArrayList<String>();
		numerosTelefones.add(String.format("( %s ) %s ", tabInformExtraJunta.getTieDddFone1(),tabInformExtraJunta.getTieFone1()));
		numerosTelefones.add(String.format("( %s ) %s ", tabInformExtraJunta.getTieDddFone2(),tabInformExtraJunta.getTieFone2()));
		return numerosTelefones;
	}
	private String carregaUnidadeRelacaoEmpresa(String praProtocolo) {
		
		return null;
	}
	// Verificar onde é o melhor local para colocar
	private String converterTipoProtocolo(Integer praTipoProtocolo) {
		 List<String> collect = Arrays.asList(TipoProtocolo.values())
			.stream()
			.filter(tipo -> tipo.getValue().compareTo(praTipoProtocolo)==0)
			.map(item-> item.getDescricao()).collect(Collectors.toList());
		 return (collect.size()>0)?collect.get(0):"N/A";
				 

	}
	
}
