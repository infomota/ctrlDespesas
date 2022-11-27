package com.infomota.despesa.repositorie;

/**
 * Classe que faz o gerenciamento dos dados de uma Despesa
 * Acessa a tabela: tb_installment
 * 
 * Author: Paulo Mota
 * Data: 27/11/2022
 * 
 */

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.infomota.despesa.entities.Despesa;

public interface DespesaRepository extends JpaRepositoryImplementation<Despesa, Integer> {

	List<Despesa> findByAnoAndMes(Integer ano, Integer mes);

}
