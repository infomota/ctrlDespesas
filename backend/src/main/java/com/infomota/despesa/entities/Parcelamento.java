package com.infomota.despesa.entities;

/**
 * Entidade que representa o objeto Parcelamento
 * 
 * Author: Paulo Mota
 * Data: 26/11/2022
 * 
 */

import java.time.LocalDate;

/**
 * Entidade que representa o objeto Parcelamento
 * 
 * Author: Paulo Mota
 * Data: 26/11/2022
 * 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_installment")
public class Parcelamento {

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

	public Parcelamento() {

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

}
