package com.project.gestao.infrastructure.database.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "membros")
public class Membros {
	@Id
	private Long idProjeto;
	
	@JoinColumn(name = "idPessoa", referencedColumnName = "id")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Pessoa idPessoa;
}
