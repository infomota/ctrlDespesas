package com.infomota.despesa.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Description Entidade que representa o objeto RECEITA
 * @author Paulo Mota
 * @data 23/11/2022
 */

@Entity
@Table(name = "tb_receita")
public class Receita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int ano;
	private int mes;
	private String documento;
	private String fontePagadora;
	private String descricao;
	private Double valor;
	private LocalDate dataRecebimento;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@Embedded
	private Usuario usuario;

	public Receita() {

	}

	public Receita(Integer id, int ano, int mes, String documento, String fontePagadora, String descricao, Double valor,
			LocalDate dataRecebimento, Usuario usuario) {
		super();
		this.id = id;
		this.ano = ano;
		this.mes = mes;
		this.documento = documento;
		this.fontePagadora = fontePagadora;
		this.descricao = descricao;
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getFontePagadora() {
		return fontePagadora;
	}

	public void setFontePagadora(String fontePagadora) {
		this.fontePagadora = fontePagadora;
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

	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
