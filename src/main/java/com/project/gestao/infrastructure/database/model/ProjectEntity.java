package com.project.gestao.infrastructure.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.gestao.application.enumerations.StatusProject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Entity
@Table(name = "project")
public class ProjectEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "description")
	private String description;
	
	@Column(name = "data_inicio")	
	private LocalDateTime dataInicio;
	
	@Column(name = "data_previsao_termino")
	private LocalDateTime dataPrevisaoTermino;
	
	@Column(name = "data_real_termino")
	private LocalDateTime dataRealTermino;
	
	@Column(name = "orcamento_total")
	private BigDecimal orcamentoTotal;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private StatusProject statusProject = StatusProject.EM_ANALISE;
	
	

}
