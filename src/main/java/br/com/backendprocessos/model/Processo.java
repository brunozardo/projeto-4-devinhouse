package br.com.backendprocessos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Processo implements Serializable {

	private static final long serialVersionUID = 1838934594260766206L; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column(nullable = false)
	private Integer cdAssunto;

	@Column(nullable = false)
	private Integer cdInteressado;

	@Column(nullable = false)
	private Integer nuProcesso;

	@Column(nullable = false)
	private String chaveProcesso;

	private String descricao;
	private String descricaoAssunto;
	private String nmInteressado;
	private String nuAnoProcesso;
	private String sgOrgaoProcesso;

	public Processo () {};
	
	public Processo(Integer id, Integer cdAssunto, Integer cdInteressado, String descricao, String descricaoAssunto,
			String nmInteressado, String nuAnoProcesso, Integer nuProcesso, String sgOrgaoProcesso,
			String chaveProcesso) {
		super();
		this.id = id;
		this.cdAssunto = cdAssunto;
		this.cdInteressado = cdInteressado;
		this.descricao = descricao;
		this.descricaoAssunto = descricaoAssunto;
		this.nmInteressado = nmInteressado;
		this.nuAnoProcesso = nuAnoProcesso;
		this.nuProcesso = nuProcesso;
		this.sgOrgaoProcesso = sgOrgaoProcesso;
		this.chaveProcesso = chaveProcesso;
	}
}
