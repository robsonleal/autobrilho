package com.robsonleal.autobrilho.service;

import com.robsonleal.autobrilho.dto.CarroDTO;
import com.robsonleal.autobrilho.model.Carro;
import com.robsonleal.autobrilho.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarroService {

	private final CarroRepository carroRepository;

	public CarroDTO create(CarroDTO jsonRequisicao) {

		Carro carro = new Carro();
		carro.setMarca(jsonRequisicao.getMarca());
		carro.setModelo(jsonRequisicao.getModelo());
		carro.setCor(jsonRequisicao.getCor());
		carro.setAno(jsonRequisicao.getAno());
		carro.setStatus(jsonRequisicao.getStatus());

		log.info("Carro antes de ser salvo || Service || CarroID: {}", carro.getId());

		Carro carroSalvoNoBanco = carroRepository.save(carro);

		log.info("Carro depois de ser salvo || Service || CarroID: {}", carroSalvoNoBanco.getId());

		CarroDTO carroDtoRetorno = new CarroDTO();
		carroDtoRetorno.setId(carroSalvoNoBanco.getId());
		carroDtoRetorno.setMarca(carroSalvoNoBanco.getMarca());
		carroDtoRetorno.setModelo(carroSalvoNoBanco.getModelo());
		carroDtoRetorno.setCor(carroSalvoNoBanco.getCor());
		carroDtoRetorno.setAno(carroSalvoNoBanco.getAno());
		carroDtoRetorno.setStatus(carroSalvoNoBanco.getStatus());

		return carroDtoRetorno;
	}

	public CarroDTO update(CarroDTO carroDaRequisicao) {

		Optional<Carro> carroOptional = carroRepository.findById(carroDaRequisicao.getId());

		Carro carroSalvoNoBanco;
		CarroDTO carroDtoRetorno = new CarroDTO();

		if (carroOptional.isPresent()) {
			Carro carro = carroOptional.get();

			carro.setMarca(carroDaRequisicao.getMarca());
			carro.setModelo(carroDaRequisicao.getModelo());
			carro.setCor(carroDaRequisicao.getCor());
			carro.setAno(carroDaRequisicao.getAno());
			carro.setStatus(carroDaRequisicao.getStatus());

			carroSalvoNoBanco = carroRepository.save(carro);

			carroDtoRetorno.setId(carroSalvoNoBanco.getId());
			carroDtoRetorno.setMarca(carroSalvoNoBanco.getMarca());
			carroDtoRetorno.setModelo(carroSalvoNoBanco.getModelo());
			carroDtoRetorno.setCor(carroSalvoNoBanco.getCor());
			carroDtoRetorno.setAno(carroSalvoNoBanco.getAno());
			carroDtoRetorno.setStatus(carroSalvoNoBanco.getStatus());

			return carroDtoRetorno;

		} else {
			log.error("Carro não encontrado");
		}

		return carroDtoRetorno;
	}
}
