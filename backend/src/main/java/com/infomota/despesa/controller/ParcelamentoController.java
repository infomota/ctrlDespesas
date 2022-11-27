package com.infomota.despesa.controller;

/**
 * Classe que contém os endPoints que acessam a entidade PARCELAMENTO
 * Acessa o serviço: ParcelamentoService
 * 
 * Author: Paulo Mota
 * Data: 26/11/2022
 * 
 */

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infomota.despesa.entities.Parcelamento;
import com.infomota.despesa.services.ParcelamentoService;

@RestController
@RequestMapping(value = "/parcelamentos")
public class ParcelamentoController {

	@Autowired
	public ParcelamentoService service;

	@GetMapping
	public List<Parcelamento> findAll() {
		return service.findAll();
	}

	@GetMapping("/descricao")
	public List<Parcelamento> findByDescricao(@RequestParam(value = "descricao") String descricao) {
		return service.findByDescricao(descricao);
	}

	@GetMapping("/vencimento")
	public List<Parcelamento> findByVencimento(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate vencimento) {
		return service.findByVencimento(vencimento);
	}

	@GetMapping("/status")
	public List<Parcelamento> findByDescricaoAndStatus(@RequestParam(value = "descricao") String descricao,
			@RequestParam(value = "status") String status) {
		return service.findByDescricaoAndStatus(descricao, status);
	}

	@GetMapping("/abertoPorPeriodo")
	public List<Parcelamento> findByAbertoPorPeriodo(@RequestParam(value = "dataInicio") String min,
			@RequestParam(value = "dataFim") String max) {
		return service.findByAbertoPorPeriodo(min, max);
	}

}
