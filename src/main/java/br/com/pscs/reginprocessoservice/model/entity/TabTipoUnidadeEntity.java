package br.com.pscs.reginprocessoservice.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.pscs.reginprocessoservice.model.entity.embededid.TabTipoUnidadeEmbeddedId;
import lombok.Data;

@Data
@Entity
@Table(name = "tab_tipo_unidade")
public class TabTipoUnidadeEntity {
	@EmbeddedId
	private TabTipoUnidadeEmbeddedId id;
	private String ttu_descricao;
}
