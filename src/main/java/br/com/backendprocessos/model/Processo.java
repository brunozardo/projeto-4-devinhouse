package br.com.backendprocessos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCdAssunto() {
		return cdAssunto;
	}

	public void setCdAssunto(Integer cdAssunto) {
		this.cdAssunto = cdAssunto;
	}

	public Integer getCdInteressado() {
		return cdInteressado;
	}

	public void setCdInteressado(Integer cdInteressado) {
		this.cdInteressado = cdInteressado;
	}

	public Integer getNuProcesso() {
		return nuProcesso;
	}

	public void setNuProcesso(Integer nuProcesso) {
		this.nuProcesso = nuProcesso;
	}

	public String getChaveProcesso() {
		return chaveProcesso;
	}

	public void setChaveProcesso(String chaveProcesso) {
		this.chaveProcesso = chaveProcesso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoAssunto() {
		return descricaoAssunto;
	}

	public void setDescricaoAssunto(String descricaoAssunto) {
		this.descricaoAssunto = descricaoAssunto;
	}

	public String getNmInteressado() {
		return nmInteressado;
	}

	public void setNmInteressado(String nmInteressado) {
		this.nmInteressado = nmInteressado;
	}

	public String getNuAnoProcesso() {
		return nuAnoProcesso;
	}

	public void setNuAnoProcesso(String nuAnoProcesso) {
		this.nuAnoProcesso = nuAnoProcesso;
	}

	public String getSgOrgaoProcesso() {
		return sgOrgaoProcesso;
	}

	public void setSgOrgaoProcesso(String sgOrgaoProcesso) {
		this.sgOrgaoProcesso = sgOrgaoProcesso;
	}
}
