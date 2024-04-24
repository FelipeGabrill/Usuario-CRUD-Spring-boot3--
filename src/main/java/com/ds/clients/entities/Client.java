package com.ds.clients.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@Getter
@Setter
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(unique = true)
	private String cpf;
	private Double income;
	private LocalDate birthDate;
	private Integer children;
	
	public Client() {
	}
	
}
