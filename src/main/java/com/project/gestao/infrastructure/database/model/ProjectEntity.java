package com.project.gestao.infrastructure.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Entity
@Table(name = "project")
public class ProjectEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;

	@Column
	private String description;
	
	@Column(name = "data_inicio")	
	private LocalDate dataInicio;
	
	@Column(name = "data_previsao_fim")
	private LocalDate dataPrevisaoFim;
	
	@Column(name = "data_fim")
	private LocalDate dataFim;
	
	@Column
	private BigDecimal orcamento;
	
	@JoinColumn(name = "idgerente", referencedColumnName = "id")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private PessoaEntity idGerente;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private StatusProject statusProject = StatusProject.EM_ANALISE;
	
	@ManyToMany
	@JoinTable(name = "membros",
			inverseJoinColumns = {@JoinColumn(name = "pessoa_id")},
			joinColumns = {@JoinColumn(name = "project_id")})
	private List<PessoaEntity> pessoas = new ArrayList<>();
	
}
