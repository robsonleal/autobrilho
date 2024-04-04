package com.robsonleal.autobrilho.dto;

import com.robsonleal.autobrilho.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarroDTO {
	private Long id;
	private String marca;
	private String modelo;
	private String placa;
	private String ano;
	private String cor;
	private Status status;

	public CarroDTO(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
}
