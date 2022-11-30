package com.infomota.despesa.repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.infomota.despesa.entities.Despesa;

/**
 * @Description Classe que faz o gerenciamento dos dados de uma Despesa
 * @author Paulo Mota
 * @data 27/11/2022
 */

public interface DespesaRepository extends JpaRepositoryImplementation<Despesa, Integer> {

	List<Despesa> findByAnoAndMesAndUsuarioId(Integer ano, Integer mes, Integer UsuarioId);

}
