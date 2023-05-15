package com.project.gestao.application.controller.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequest {
	private String nome;
	private String description;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")	
	private LocalDateTime dataInicio;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataPrevisaoTermino;
	private BigDecimal orcamentoTotal;
}
