package com.infomota.despesa.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infomota.despesa.entities.Despesa;
import com.infomota.despesa.entities.Parcelamento;
import com.infomota.despesa.enums.StatusPagamento;
import com.infomota.despesa.repositorie.DespesaRepository;
import com.infomota.despesa.repositorie.ParcelamentoReporitory;

/**
 * @Description Classe que representa as funcionalidades de negócio da Entidade
 *              PARCELAMENTO. Acessa o repositório: ParcelamentoReporitory
 * @author Paulo Mota
 * @data 23/11/2022
 */

@Service
public class ParcelamentoService {

	@Autowired
	private ParcelamentoReporitory rep;

	@Autowired
	private DespesaRepository repDespesas;

	// Retorna parcelas por descrição e status
	public List<Parcelamento> findByUsuarioIdAndDescricaoAndStatus(Integer usuario, String descricao, String status) {
		return rep.findByUsuarioIdAndDescricaoAndStatus(usuario, descricao, status);
	}

	// Retorna débitos em aberto de um período (STATUS = PENDENTE)
	public List<Parcelamento> findByAbertoPorPeriodo(Integer usuario, String min, String max) {
		String status = StatusPagamento.PENDENTE.getDescricao();
		return rep.findByAbertoPorPeriodo(LocalDate.parse(min), LocalDate.parse(max), status, usuario);
	}

	// Salva um novo novo parcelamento
	public void novoParcelamento(List<Parcelamento> parcela) {
		for (Parcelamento parcelas : parcela) {

			// Cria um novo parcelamento
			rep.save(parcelas);

			// Provisiona o parcelamento como despesa de cada mês
			Despesa despesa = new Despesa();
			despesa.setAno(parcelas.getVencimento().getYear());
			despesa.setMes(parcelas.getVencimento().getMonthValue());
			despesa.setDataVencto(parcelas.getVencimento());
			despesa.setDescricao(parcelas.getDescricao());
			despesa.setStatus(parcelas.getStatus());
			despesa.setUsuario(parcelas.getUsuario());
			despesa.setValor(parcelas.getValorParcela());
			repDespesas.save(despesa);

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
