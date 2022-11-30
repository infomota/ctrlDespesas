package com.infomota.despesa.repositorie;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.infomota.despesa.entities.Usuario;

/**
 * @Description Classe que faz o gerenciamento dos dados de um Usuario
 * @author Paulo Mota
 * @data 23/11/2022
 */

public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Integer> {

	Usuario findByCpf(String cpf);

}
