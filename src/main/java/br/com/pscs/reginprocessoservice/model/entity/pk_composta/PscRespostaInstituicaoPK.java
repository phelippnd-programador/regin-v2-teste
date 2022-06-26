package br.com.pscs.reginprocessoservice.model.entity.pk_composta;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The primary key class for the psc_resposta_instituicao database table.
 * 
 */
@Data
@Embeddable
public class PscRespostaInstituicaoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PRI_PRA_PROTOCOLO", insertable =false, updatable=false)
	private String priPraProtocolo;

	@Column(name="PRI_TIN_CNPJ", insertable=false, updatable=false)
	private String priTinCnpj;

	
}