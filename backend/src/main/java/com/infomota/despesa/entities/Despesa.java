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
 * @Description Entidade que representa o objeto DESPESA
 * @author Paulo Mota
 * @data 26/11/2022
 */

@Entity
@Table(name = "tb_despesa")
public class Despesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int ano;
	private int mes;
	private LocalDate dataVencto;
	private String descricao;
	private Double valor;
	private String status;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Despesa() {

	}

	public Despesa(Integer id, int ano, int mes, LocalDate dataVencto, String descricao, Double valor, String status,
			Usuario usuario) {
		super();
		this.id = id;
		this.ano = ano;
		this.mes = mes;
		this.dataVencto = dataVencto;
		this.descricao = descricao;
		this.valor = valor;
		this.status = status;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public LocalDate getDataVencto() {
		return dataVencto;
	}

	public void setDataVencto(LocalDate dataVencto) {
		this.dataVencto = dataVencto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
