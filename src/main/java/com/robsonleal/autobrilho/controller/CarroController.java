package com.robsonleal.autobrilho.controller;

import com.robsonleal.autobrilho.dto.CarroDTO;
import com.robsonleal.autobrilho.model.Status;
import com.robsonleal.autobrilho.service.CarroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carros")
@RequiredArgsConstructor
@Slf4j
public class CarroController {

	private final CarroService service;

	@PostMapping
	public ResponseEntity<CarroDTO> create(@RequestBody CarroDTO jsonRequisicao) {
		log.info("Carro entrando na aplicação || Controller || Marca: {}", jsonRequisicao.getMarca());
		log.info("Carro entrando na aplicação || Controller || Placa: {}", jsonRequisicao.getPlaca());
		log.info("Carro entrando na aplicação || Controller || Modelo: {}", jsonRequisicao.getModelo());
		log.info("Carro entrando na aplicação || Controller || Ano: {}", jsonRequisicao.getAno());
		log.info("Carro entrando na aplicação || Controller || Cor: {}", jsonRequisicao.getCor());
		log.info("Carro entrando na aplicação || Controller || Status: {}", jsonRequisicao.getStatus());

		CarroDTO carroDtoRetorno = service.create(jsonRequisicao);

		return ResponseEntity.status(HttpStatus.CREATED).body(carroDtoRetorno);
	}

	@PutMapping
	public ResponseEntity<CarroDTO> update(@RequestBody CarroDTO jsonRequisicao) {
		log.info("Carro entrando na aplicação || Controller || Marca: {}", jsonRequisicao.getMarca());
		log.info("Carro entrando na aplicação || Controller || Placa: {}", jsonRequisicao.getPlaca());
		log.info("Carro entrando na aplicação || Controller || Modelo: {}", jsonRequisicao.getModelo());
		log.info("Carro entrando na aplicação || Controller || Ano: {}", jsonRequisicao.getAno());
		log.info("Carro entrando na aplicação || Controller || Cor: {}", jsonRequisicao.getCor());
		log.info("Carro entrando na aplicação || Controller || Status: {}", jsonRequisicao.getStatus());

		CarroDTO carroAtualizado = service.update(jsonRequisicao);

		return ResponseEntity.ok(carroAtualizado);
	}

	@GetMapping
	public ResponseEntity<List<CarroDTO>> buscarTodosCarros(@RequestParam(required = false) Status status) {
		List<CarroDTO> carrosRetornados;

		if (status != null) {
			carrosRetornados = service.buscaCarrosPorStatus(status);
		} else {
			carrosRetornados = service.buscarTodosCarros();
		}

		return ResponseEntity.ok(carrosRetornados);
	}

}
