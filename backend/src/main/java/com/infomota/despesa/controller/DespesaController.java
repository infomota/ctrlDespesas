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

import com.infomota.despesa.entities.Despesa;
import com.infomota.despesa.services.DespesaService;

/**
 * Classe que contém os endPoints que acessam a entidade DESPESA
 * Acessa o serviço: DespesaService
 * 
 * Author: Paulo Mota
 * Data: 27/11/2022
 * 
 */

@RestController
@RequestMapping(value = "/despesas")
public class DespesaController {

	@Autowired
	private DespesaService service;

	@PostMapping("/novo")
	public void novaDespesa(@RequestBody Despesa despesa) {
		service.novaDespesa(despesa);
	}

	@PostMapping("/alterar")
	public void alteraDespesa(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "vencimento") String vencimento,
			@RequestParam(value = "descricao") String descricao) {
		service.alteraDespesa(id, vencimento, descricao);
	}

	@PostMapping("/pagar/{id}")
	public void pagar(@PathVariable Integer id) {
		service.pagarDespesa(id);
	}

	@GetMapping("/mes/{ano}/{mes}")
	public List<Despesa> findByAnoAndMes(@PathVariable Integer ano, @PathVariable Integer mes) {
		return service.findByAnoAndMes(ano, mes);
	}

}
