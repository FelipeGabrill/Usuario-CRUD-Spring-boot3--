package com.ds.clients.dto;

import java.time.LocalDate;

import com.ds.clients.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClientDTO {

	private Long id;
	
	@NotBlank(message = "Campo requerido")
	private String name;
	
	private String cpf;
	
	private Double income;
	
	@PastOrPresent(message = "não pode ser data futura ou presente")
	private LocalDate birthDate;
	
	@PositiveOrZero
	private Integer children;
	
	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		children = entity.getChildren();		
	}
}
