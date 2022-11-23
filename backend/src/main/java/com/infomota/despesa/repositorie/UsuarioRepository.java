package com.infomota.despesa.repositorie;

/**
 * Classe que faz o gerenciamento dos dados de um Usuario
 * Acessa a tabela: tb_user
 * 
 * Author: Paulo Mota
 * Data: 23/11/2022
 * 
 */

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.infomota.despesa.entities.Usuario;

public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Integer> {
	
	Usuario findByCpf(String cpf);

}
