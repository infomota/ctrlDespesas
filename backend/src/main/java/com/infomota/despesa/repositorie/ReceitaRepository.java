package com.infomota.despesa.repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.infomota.despesa.entities.Receita;

public interface ReceitaRepository extends JpaRepositoryImplementation<Receita, Integer>{

	List<Receita> findByAnoAndMes(int ano, int mes);

}
