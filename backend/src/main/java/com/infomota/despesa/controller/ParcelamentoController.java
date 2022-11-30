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

import com.infomota.despesa.entities.Parcelamento;
import com.infomota.despesa.services.ParcelamentoService;

/**
 * @Description Classe que contém os endPoints que acessam a entidade
 *              PARCELAMENTO. Acessa o serviço: ParcelamentoService
 * @author Paulo Mota
 * @data 27/11/2022
 */

@RestController
@RequestMapping(value = "/parcelamentos")
public class ParcelamentoController {

	@Autowired
	public ParcelamentoService service;

	@GetMapping("/status/{usuario}")
	public List<Parcelamento> findByDescricaoAndStatus(
			@PathVariable Integer usuario,
			@RequestParam(value = "descricao") String descricao, 
			@RequestParam(value = "status") String status) {
		return service.findByUsuarioIdAndDescricaoAndStatus(usuario, descricao, status);
	}

	@GetMapping("/abertoPorPeriodo/{usuario}")
	public List<Parcelamento> findByAbertoPorPeriodo(
			@PathVariable Integer usuario,
			@RequestParam(value = "dataInicio") String min,
			@RequestParam(value = "dataFim") String max) {
		return service.findByAbertoPorPeriodo(usuario, min, max);
	}

	@PostMapping("/novo")
	public void novoParcelamento(@RequestBody List<Parcelamento> parcelas) {
		service.novoParcelamento(parcelas);
	}

	@PostMapping("/alteraParcela")
	public void alteraParcela(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "vencimento") String vencimento, @RequestParam(value = "valor") Double valor) {
		service.alteraParcela(id, vencimento, valor);
	}
	
	@PostMapping("/alteraStatus")
	public void alteraStatus(@RequestParam(value = "id") Integer id) {
		service.alteraStatus(id);
	}

}
