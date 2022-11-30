package com.infomota.despesa.repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.infomota.despesa.entities.Receita;

/**
 * @Description Classe que faz o gerenciamento dos dados de uma Receita
 * @author Paulo Mota
 * @data 23/11/2022
 */
public interface ReceitaRepository extends JpaRepositoryImplementation<Receita, Integer> {

	List<Receita> findByAnoAndMesAndUsuarioId(int ano, int mes, Integer usuario);

}
