package com.infomota.despesa.services;

/**
 * Classe que representa as funcionaidades de negócio da Entidade USUARIO
 * Acessa o repositório: UsuarioRepository
 * 
 * Author: Paulo Mota
 * Data: 23/11/2022
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infomota.despesa.entities.Usuario;
import com.infomota.despesa.repositorie.UsuarioRepository;

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
	
	// Alterar a senha de um usuário
	public void alteraSenha(Integer id, String senha) {
		Usuario usuario = rep.findById(id).get();
		usuario.setSenha(senha);
		rep.save(usuario);
	}

}
