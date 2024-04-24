package com.ds.clients.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomError {

	private Instant timestamp;
	private Integer status;
	private String erro;
	private String path;
	
}