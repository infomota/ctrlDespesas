package com.infomota.despesa.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Description Entidade que representa o objeto PARCELAMENTO
 * @author Paulo Mota
 * @data 26/11/2022
 */

@Entity
@Table(name = "tb_parcelamento")
public class Parcelamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private LocalDate vencimento;
	private int nrParcelasTotal;
	private int nrParcelaAtual;
	private Double valorParcela;
	private Double valorTotal;
	private String status;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Parcelamento(Integer id, String descricao, LocalDate vencimento, int nrParcelasTotal, int nrParcelaAtual,
			Double valorParcela, Double valorTotal, String status, Usuario usuario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.vencimento = vencimento;
		this.nrParcelasTotal = nrParcelasTotal;
		this.nrParcelaAtual = nrParcelaAtual;
		this.valorParcela = valorParcela;
		this.valorTotal = valorTotal;
		this.status = status;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public int getNrParcelasTotal() {
		return nrParcelasTotal;
	}

	public void setNrParcelasTotal(int nrParcelasTotal) {
		this.nrParcelasTotal = nrParcelasTotal;
	}

	public int getNrParcelaAtual() {
		return nrParcelaAtual;
	}

	public void setNrParcelaAtual(int nrParcelaAtual) {
		this.nrParcelaAtual = nrParcelaAtual;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
