package com.infomota.despesa.repositorie;

/**
 * Classe que faz o gerenciamento dos dados de um Parcelamento
 * Acessa a tabela: tb_installment
 * 
 * Author: Paulo Mota
 * Data: 26/11/2022
 * 
 */

import java.time.LocalDate;

/**
 * Classe que faz o gerenciamento dos dados de Parcelaentos
 * Acessa a tabela: tb_parcelamento
 * 
 * Author: Paulo Mota
 * Data: 26/11/2022
 * 
 */

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.infomota.despesa.entities.Parcelamento;

public interface ParcelamentoReporitory extends JpaRepositoryImplementation<Parcelamento, Integer> {

	// Querys customizadas
	String findByAbertoPorPeriodo= "SELECT obj FROM Parcelamento obj "
									+ "WHERE obj.vencimento BETWEEN :min AND :max "
									+ "AND obj.status = 'Pendente'"
									+ "ORDER BY obj.vencimento DESC";
	
	@Query(findByAbertoPorPeriodo)
	List<Parcelamento> findByAbertoPorPeriodo(LocalDate min, LocalDate max);
	
	List<Parcelamento> findByDescricao(String descricao);

	List<Parcelamento> findByVencimento(LocalDate vencimento);

	List<Parcelamento> findByDescricaoAndStatus(String descricao, String status);

	List<Parcelamento> findByVencimentoAndStatus(LocalDate vencimento, String status);

}
