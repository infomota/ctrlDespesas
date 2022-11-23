package com.infomota.despesa.controller;

/**
 * Classe que contém os endPoints que acessam a entidade USUARIO
 * Acessa a tabela: UsuarioService
 * 
 * Author: Paulo Mota
 * Data: 23/11/2022
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infomota.despesa.entities.Usuario;
import com.infomota.despesa.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public List<Usuario> findUserAll() {
		return service.findUserAll();
	}

	@GetMapping("/id")
	public Usuario findUserById(@RequestParam(value = "id") Integer id) {
		return service.findUserById(id);
	}

	@GetMapping("/cpf")
	public Usuario findUserCpf(@RequestParam(value = "cpf") String cpf) {
		return service.findByCpf(cpf);
	}

}
