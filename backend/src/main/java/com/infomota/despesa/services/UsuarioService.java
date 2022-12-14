package com.infomota.despesa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infomota.despesa.entities.Usuario;
import com.infomota.despesa.repositorie.UsuarioRepository;

/**
 * @Description Classe que representa as funcionalidades de negócio da Entidade
 *              USUARIO Acessa o repositório: UsuarioReporitory
 * @author Paulo Mota
 * @data 23/11/2022
 */

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository rep;

	// Retorna uma lista de usuários cadastrados
	public List<Usuario> findUserAll() {
		return rep.findAll();
	}

	// Retorna um usuário pelo ID
	public Usuario findUserById(Integer id) {
		return rep.findById(id).get();
	}

	// Retorna um usuário pelo CPF
	public Usuario findByCpf(String cpf) {
		return rep.findByCpf(cpf);
	}

	// Insere um novo usuário
	public void novoUsuario(Usuario user) {
		rep.save(user);
	}

}
