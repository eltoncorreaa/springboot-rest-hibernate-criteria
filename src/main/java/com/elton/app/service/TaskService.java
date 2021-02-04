package com.elton.app.service;

import java.util.List;

import com.elton.app.dto.TaskDTO;

public interface TaskService {

	List<TaskDTO> findByFilter(TaskDTO taskDTO);

	List<TaskDTO> findAll();

	TaskDTO findById(Long id);

	TaskDTO update(TaskDTO task);

	void delete(Long id);

	/**
	 * Persiste uma instancia da entidade Empresa.
	 *
	 * @param task
	 *            Instancia de Acao a ser persistida
	 * @return entidade persistida
	 */
	TaskDTO persist(TaskDTO task);
}