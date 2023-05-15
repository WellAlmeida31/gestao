package com.project.gestao.application.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.gestao.application.controller.response.ProjectFilter;
import com.project.gestao.application.controller.response.ProjectRequest;
import com.project.gestao.application.controller.response.ProjectResponse;
import com.project.gestao.application.converters.ProjectRequestConverter;
import com.project.gestao.application.converters.ProjectResponseConverter;
import com.project.gestao.application.enumerations.StatusProject;
import com.project.gestao.infrastructure.database.model.ProjectEntity;
import com.project.gestao.infrastructure.database.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProjectService {

	private final ProjectRepository repository;
	private final ProjectRequestConverter requestConverter;
	private final ProjectResponseConverter responseConverter;

	@Transactional(readOnly = true)
	public List<ProjectResponse> listProjectFilter(ProjectFilter filter) {
        return responseConverter.toListDto(repository.findAll());
	}
	
	
	@Transactional(readOnly = true)
	public List<ProjectResponse> listProject() {
        return responseConverter.toListDto(repository.findAll());
	}
	
	@Transactional(readOnly = true)
	public List<ProjectResponse> listProjectByStatus(String status) {
        return responseConverter.toListDto(repository.findAllByStatusProject(StatusProject.valueOf(status)));
	}
	
	@Transactional
	public void addProject(ProjectRequest projectRequest) {
        repository.save(requestConverter.toEntity(projectRequest));
	}
	
	@Transactional
	public void deleteProject(Long id) throws Exception {
		ProjectEntity entity = repository.getReferenceById(id);
		if (!entity.getStatusProject().isNotExclude()) {
			repository.deleteById(id);
		}else {
			throw new IllegalArgumentException("Project cannot be deleted STATUS ["+entity.getStatusProject().name()+"]");
		}
             
	}



}
