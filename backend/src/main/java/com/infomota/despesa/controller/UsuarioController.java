package com.infomota.despesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infomota.despesa.entities.Usuario;
import com.infomota.despesa.services.UsuarioService;

/**
 * @Description Classe que contém os endPoints que acessam a entidade USUARIO.
 *              Acessa o serviço: UsuarioService
 * @author Paulo Mota
 * @data 27/11/2022
 */

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
}
