package com.infomota.despesa.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infomota.despesa.entities.Receita;
import com.infomota.despesa.repositorie.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository rep;

	// Insere nova fonte de receita
	public void novaReceita(Receita receita) {
		rep.save(receita);
	}

	// Altera a data de recebimento
	public void alteraDataRecebimentoReceita(Integer id, String dataRecebimento) {
		Receita receita = rep.findById(id).get();
		receita.setDataRecebimento(LocalDate.parse(dataRecebimento));
		rep.save(receita);
	}

	// Altera o valor de recebimento
	public void alteraValorReceita(Integer id, Double valor) {
		Receita receita = rep.findById(id).get();
		receita.setValor(valor);
		rep.save(receita);
	}

	// Deleta o lançamento de uma receita
	public void deletaReceita(Integer id) {
		Receita receita = rep.findById(id).get();
		rep.delete(receita);
	}

	public List<Receita> receitasMes(int ano, int mes) {
		return rep.findByAnoAndMes(ano, mes);
	}

}
