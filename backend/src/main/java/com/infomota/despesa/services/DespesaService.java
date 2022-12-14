package com.infomota.despesa.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infomota.despesa.entities.Despesa;
import com.infomota.despesa.enums.StatusPagamento;
import com.infomota.despesa.repositorie.DespesaRepository;

/**
 * @Description Classe que representa as funcionalidades de negócio da Entidade
 *              DESPESA. Acessa o repositório: DespesaRepository
 * @author Paulo Mota
 * @data 23/11/2022
 */

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository rep;

	// Insere uma nova despesa
	public void novaDespesa(Despesa despesa) {
		rep.save(despesa);
	}

	// Altera os dados de uma despesa
	public void alteraDespesa(Integer id, String vencimento, String descricao) {
		Despesa despesa = rep.findById(id).get();
		despesa.setDataVencto(LocalDate.parse(vencimento));
		despesa.setDescricao(descricao);
		rep.save(despesa);
	}

	// Altera o status de uma despesa para pago
	public void pagarDespesa(Integer id) {
		Despesa despesa = rep.findById(id).get();
		despesa.setStatus(StatusPagamento.PAGO.getDescricao());
		rep.save(despesa);
	}

	// Busca todas as despesas de um mês
	public List<Despesa> findByAnoAndMesAndUsuarioId(Integer ano, Integer mes, Integer UsuarioId) {
		return rep.findByAnoAndMesAndUsuarioId(ano, mes, UsuarioId);
	}

}
