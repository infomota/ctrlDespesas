package com.infomota.despesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infomota.despesa.entities.Receita;
import com.infomota.despesa.services.ReceitaService;

/**
 * @Description Classe que contém os endPoints que acessam a entidade RECEITA.
 *              Acessa o serviço: ReceitaService
 * @author Paulo Mota
 * @data 27/11/2022
 */

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

	@Autowired
	private ReceitaService service;

	@PostMapping("/novo")
	public void novaReceita(@RequestBody Receita receita) {
		service.novaReceita(receita);
	}

	@PostMapping("/alteraValor")
	public void alteraValorReceita(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "valor") Double valor) {
		service.alteraValorReceita(id, valor);
	}

	@PostMapping("/alteraData")
	public void alteraDataReceita(@RequestParam(value = "id") Integer id, @RequestParam(value = "data") String data) {
		service.alteraDataRecebimentoReceita(id, data);
	}

	@PostMapping("/deleta/{id}")
	public void deletaReceita(@PathVariable Integer id) {
		service.deletaReceita(id);
	}

	@GetMapping("/mes/{usuario}/{ano}/{mes}")
	public List<Receita> receitasMes(@PathVariable Integer usuario, @PathVariable int ano, @PathVariable int mes) {
		return service.receitasMes(ano, mes, usuario);
	}

}