package com.infomota.despesa.repositorie;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.infomota.despesa.entities.Parcelamento;

/**
 * @Description Classe que faz o gerenciamento dos dados de um Parcelament
 * @author Paulo Mota
 * @data 26/11/2022
 */

public interface ParcelamentoReporitory extends JpaRepositoryImplementation<Parcelamento, Integer> {

	// Querys customizadas
	String findByAbertoPorPeriodo = "SELECT obj FROM Parcelamento obj " 
								   + "WHERE obj.vencimento BETWEEN :min AND :max "
								   + "AND obj.status = :status "
								   + "AND obj.usuario.id = :usuario "
								   + "ORDER BY obj.vencimento DESC";

	@Query(findByAbertoPorPeriodo)
	List<Parcelamento> findByAbertoPorPeriodo(LocalDate min, LocalDate max, String status, Integer usuario);

	List<Parcelamento> findByUsuarioIdAndDescricaoAndStatus(Integer usuario, String descricao, String status);

}
