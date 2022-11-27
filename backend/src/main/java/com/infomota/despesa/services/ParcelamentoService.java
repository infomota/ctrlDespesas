package com.infomota.despesa.services;

/**
 * Classe que representa as funcionalidades de negócio da Entidade PARCELAMENTO
 * Acessa o repositório: ParcelamentoReporitory
 * 
 * Author: Paulo Mota
 * Data: 26/11/2022
 * 
 */
import java.time.LocalDate;

/**
 * Classe que representa as funcionaidades de negócio da Entidade PARCELAMENTO
 * Acessa a tabela: UsuarioRepository
 * 
 * Author: Paulo Mota
 * Data: 26/11/2022
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infomota.despesa.entities.Parcelamento;
import com.infomota.despesa.enums.StatusPagamento;
import com.infomota.despesa.repositorie.ParcelamentoReporitory;

@Service
public class ParcelamentoService {

	@Autowired
	private ParcelamentoReporitory rep;

	// Retorna todos os parcelamentos de um usuario
	public List<Parcelamento> findAll() {
		return rep.findAll();
	}

	// Retorna uma lista de parcelamentos
	public List<Parcelamento> findByDescricao(String descricao) {
		return rep.findByDescricao(descricao);
	}

	// Retorna os parcelamentos a partir de uma data de vencimento
	public List<Parcelamento> findByVencimento(LocalDate vencimento) {
		return rep.findByVencimento(vencimento);
	}

	// Retorna parcelas por descrição e status
	public List<Parcelamento> findByDescricaoAndStatus(String descricao, String status) {
		return rep.findByDescricaoAndStatus(descricao, status);
	}

	// Retorna parcelas por data de vencimento e status
	public List<Parcelamento> findByVencimentoandStatus(String vencimento, String status) {
		return rep.findByVencimentoAndStatus(LocalDate.parse(vencimento), status);
	}

	// Retorna débitos em aberto de um período
	public List<Parcelamento> findByAbertoPorPeriodo(String min, String max) {
		return rep.findByAbertoPorPeriodo(LocalDate.parse(min), LocalDate.parse(max));
	}

	// Salva um novo novo parcelamento
	public void novoParcelamento(List<Parcelamento> parcela) {
		for (Parcelamento parcelas : parcela) {
			rep.save(parcelas);
		}
	}

	// Atualiza o valor e o vencimento de uma parcela
	public void alteraParcela(Integer id, String vencimento, Double valor) {
		Parcelamento parcela = rep.findById(id).get();
		parcela.setVencimento(LocalDate.parse(vencimento));
		parcela.setValorParcela(valor);
		rep.save(parcela);
	}

	// Atualiza o Status do Parcelamento para PAGO
	public void alteraStatus(Integer id) {
		Parcelamento parcela = rep.findById(id).get();
		parcela.setStatus(StatusPagamento.PAGO.getDescricao());
		rep.save(parcela);
	}

}
