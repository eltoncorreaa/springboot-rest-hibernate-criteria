package com.elton.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elton.app.converter.TaskConverter;
import com.elton.app.dto.TaskDTO;
import com.elton.app.exception.MultipleTaskException;
import com.elton.app.exception.TaskException;
import com.elton.app.model.Task;
import com.elton.app.repository.TaskRepository;
import com.elton.app.service.TaskService;

@Transactional(readOnly = true)
@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;

	private static final String NOME_OBRIGATORIO = "Name is Required.";
	private static final String START_DATE_REQUIRED = "Start Date is Required.";
	private static final String lOCK_OPTIMISTIC = "Entidade desatualizada, favor atualizar a página para concluir alteração.";

	@Override
	public List<TaskDTO> findByFilter(final TaskDTO taskDTO) {
		return TaskConverter.toListDTO(taskRepository.findByFilter(TaskConverter.toModel(taskDTO)));
	}

	@Override
	public List<TaskDTO> findAll() {
		return TaskConverter.toListDTO(taskRepository.findAll());
	}

	@Override
	public TaskDTO findById(final Long id) {
		return TaskConverter.toDTO(taskRepository.findById(id).get());
	}

	@Transactional(readOnly = false)
	@Override
	public TaskDTO update(final TaskDTO taskDTO) {
		final Task taskEntity= TaskConverter.toModel(taskDTO);
		taskEntity.setLastUpdateTime(new Date());
		checkException(validateUpdateTask(taskEntity));
		return TaskConverter.toDTO(taskRepository.save(taskEntity));
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(final Long id) {
		taskRepository.deleteById(id);
	}

	@Transactional(readOnly = false)
	@Override
	public TaskDTO persist(final TaskDTO taskDTO) {
		final Task taskEntity= TaskConverter.toModel(taskDTO);
		taskEntity.setCreationTime(new Date());
		checkException(validatePersistTask(taskEntity));
		return TaskConverter.toDTO(taskRepository.save(taskEntity));
	}

	private void checkException(final ArrayList<TaskException> exceptions) {
		if (!exceptions.isEmpty()) {
			throw new MultipleTaskException(exceptions);
		}
	}

	private ArrayList<TaskException> validatePersistTask(final Task task) {
		final ArrayList<TaskException> errors = new ArrayList<>();
		validateName(task, errors);
		validateStartDate(task, errors);
		return errors;
	}

	private ArrayList<TaskException> validateUpdateTask(final Task task) {
		final ArrayList<TaskException> errors = new ArrayList<>();
		validateName(task, errors);
		validateStartDate(task, errors);
		validateLockOptimistic(task, errors);
		return errors;
	}

	private void validateStartDate(final Task task, final ArrayList<TaskException> errors) {
		if (task.getStartDate() == null) {
			errors.add(new TaskException(START_DATE_REQUIRED));
		}
	}

	private void validateName(final Task task, final ArrayList<TaskException> errors) {
		if (task.getName().trim().isEmpty()) {
			errors.add(new TaskException(NOME_OBRIGATORIO));
		}
	}

	private void validateLockOptimistic(final Task task, final ArrayList<TaskException> errors) {
		if (!taskRepository.findById(task.getId()).get().getVersion().equals(task.getVersion()) ) {
			errors.add(new TaskException(lOCK_OPTIMISTIC));
		}
	}
}
