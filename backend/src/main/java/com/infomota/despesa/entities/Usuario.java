package com.infomota.despesa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Description Entidade que representa o objeto Usuario
 * @author Paulo Mota
 * @data 23/11/2022
 */

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private String foneMovel;
	private String senha;

	// Mapeamento de entidades externas (Foreign Keys)
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Receita> receitas = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Despesa> despesas = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Parcelamento> parcelamento = new ArrayList<>();

	public Usuario() {

	}

	public Usuario(Integer id, String nome, String cpf, String email, String foneMovel, String senha,
			List<Receita> receitas, List<Despesa> despesas, List<Parcelamento> parcelamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.foneMovel = foneMovel;
		this.senha = senha;
		this.receitas = receitas;
		this.despesas = despesas;
		this.parcelamento = parcelamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoneMovel() {
		return foneMovel;
	}

	public void setFoneMovel(String foneMovel) {
		this.foneMovel = foneMovel;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public List<Parcelamento> getParcelamento() {
		return parcelamento;
	}

}
