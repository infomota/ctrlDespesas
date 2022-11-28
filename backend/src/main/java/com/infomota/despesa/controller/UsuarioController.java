package com.infomota.despesa.controller;

/**
 * Classe que contém os endPoints que acessam a entidade USUARIO
 * Acessa o serviço: UsuarioService
 * 
 * Author: Paulo Mota
 * Data: 23/11/2022
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infomota.despesa.entities.Usuario;
import com.infomota.despesa.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public List<Usuario> findUserAll() {
		return service.findUserAll();
	}

	@GetMapping("/{id}")
	public Usuario findUserById(@PathVariable Integer id) {
		return service.findUserById(id);
	}

	@GetMapping("/cpf/{cpf}")
	public Usuario findUserCpf(@PathVariable String cpf) {
		return service.findByCpf(cpf);
	}

	@PostMapping("/novo")
	public void novoUsuario(@RequestBody Usuario user) {
		service.novoUsuario(user);
	}

	@PostMapping("/alteraSenha")
	public void alteraSenha(
			@RequestParam(value = "id") Integer id, 
			@RequestParam(value = "novaSenha") String senha) {
		service.alteraSenha(id, senha);
	}

}
