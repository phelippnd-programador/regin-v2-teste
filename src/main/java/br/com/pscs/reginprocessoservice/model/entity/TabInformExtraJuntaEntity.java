package br.com.pscs.reginprocessoservice.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.pscs.reginprocessoservice.model.entity.embededid.TabGenericaEmbeddedId;
import lombok.Data;

@Entity
@Data
@Table(name = "tab-inform_extra_junta")
public class TabInformExtraJuntaEntity implements Serializable {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tie protocolo. */
	@EmbeddedId
	private TabGenericaEmbeddedId id;

	/** The tie ddd fone1. */
	private String tieDddFone1;

	/** The tie fone1. */
	private String tieFone1;

	/** The tie ddd fone2. */
	private String tieDddFone2;

	/** The tie fone2. */
	private String tieFone2;

	/** The tie ddd fax. */
	private String tieDddFax;

	/** The tie fax. */
	private String tieFax;

	/** The tie tipo unidade. */
	private String tieTipoUnidade;

	/** The tie orgao registro. */
	private String tieOrgaoRegistro;

	/** The tie cnpj registro. */
	private String tieCnpjRegistro;

	/** The tie forma atuacao.  Não consta no banco deve se pegoar deve se carregar da tabela ftieFormaAtuacaoOutros da um split e depois fazer um join com a tabela tab_forma_atuacao*/
	private String tieFormaAtuacao;

	/** The tie email. */
	private String tieEmail;

	/** The tie distrito. */
	private String tieDistrito;

	
	/** The tie forma atuacao outros. */
	private String tieFormaAtuacaoOutros;

	/** The formas atuacao. */
	private String formasAtuacao;

	/** The tipo unidade desc. Join realizado com a tab_tipo_unidade no campo TieTipoUnidade com ttu_codigo */
	@Transient
	private String tipoUnidadeDesc;
	
	/** The lista formas atuacao. */
	private List<String> listaFormasAtuacao;

}
