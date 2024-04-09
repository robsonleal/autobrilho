package com.robsonleal.autobrilho.service;

import com.robsonleal.autobrilho.dto.CarroDTO;
import com.robsonleal.autobrilho.model.Carro;
import com.robsonleal.autobrilho.model.Status;
import com.robsonleal.autobrilho.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
		carro.setPlaca(jsonRequisicao.getPlaca());
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
		carroDtoRetorno.setPlaca(carroSalvoNoBanco.getPlaca());
		carroDtoRetorno.setCor(carroSalvoNoBanco.getCor());
		carroDtoRetorno.setAno(carroSalvoNoBanco.getAno());
		carroDtoRetorno.setStatus(carroSalvoNoBanco.getStatus());

		return carroDtoRetorno;
	}

	public CarroDTO update(CarroDTO carroDaRequisicao) {

		Optional<Carro> carroOptional = carroRepository.findByPlaca(carroDaRequisicao.getPlaca());

		Carro carroSalvoNoBanco;
		CarroDTO carroDtoRetorno = new CarroDTO();

		if (carroOptional.isPresent()) {
			Carro carro = carroOptional.get();

			carro.setMarca(carroDaRequisicao.getMarca());
			carro.setModelo(carroDaRequisicao.getModelo());
			carro.setPlaca(carroDaRequisicao.getPlaca());
			carro.setCor(carroDaRequisicao.getCor());
			carro.setAno(carroDaRequisicao.getAno());
			carro.setStatus(carroDaRequisicao.getStatus());

			carroSalvoNoBanco = carroRepository.save(carro);

			carroDtoRetorno.setId(carroSalvoNoBanco.getId());
			carroDtoRetorno.setMarca(carroSalvoNoBanco.getMarca());
			carroDtoRetorno.setModelo(carroSalvoNoBanco.getModelo());
			carroDtoRetorno.setPlaca(carroSalvoNoBanco.getPlaca());
			carroDtoRetorno.setCor(carroSalvoNoBanco.getCor());
			carroDtoRetorno.setAno(carroSalvoNoBanco.getAno());
			carroDtoRetorno.setStatus(carroSalvoNoBanco.getStatus());

			return carroDtoRetorno;

		} else {
			log.error("Carro não encontrado");
		}

		return carroDtoRetorno;
	}

	public List<CarroDTO> buscarTodosCarros() {

		List<Carro> carros = carroRepository.findAll();

		List<CarroDTO> carrosDTO = new ArrayList<>();

		for (Carro carro : carros) {

			CarroDTO carroDto = new CarroDTO();
			carroDto.setId(carro.getId());
			carroDto.setMarca(carro.getMarca());
			carroDto.setModelo(carro.getModelo());
			carroDto.setPlaca(carro.getPlaca());
			carroDto.setCor(carro.getCor());
			carroDto.setAno(carro.getAno());
			carroDto.setStatus(carro.getStatus());


			carrosDTO.add(carroDto);
		}

		return carrosDTO;
	}

	public List<CarroDTO> buscaCarrosPorStatus(Status status) {

		List<Carro> carros = carroRepository.findByStatus(status);
		List<CarroDTO> carrosDTO = new ArrayList<>();

		for (Carro carro : carros) {

			CarroDTO carroDto = new CarroDTO();
			carroDto.setId(carro.getId());
			carroDto.setMarca(carro.getMarca());
			carroDto.setModelo(carro.getModelo());
			carroDto.setPlaca(carro.getPlaca());
			carroDto.setCor(carro.getCor());
			carroDto.setAno(carro.getAno());
			carroDto.setStatus(carro.getStatus());


			carrosDTO.add(carroDto);
		}

		return carrosDTO;
	}

}
