package com.elton.app.converter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.elton.app.dto.DTOWithRevision;
import com.elton.app.dto.RevisionsDTO;
import com.elton.app.dto.TaskDTO;
import com.elton.app.model.EntityWithRevision;
import com.elton.app.model.RevisionsEntity;
import com.elton.app.model.Task;

public class TaskConverter {

	public static Task toModel(final TaskDTO dto) {
		final ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Task.class);
	}

	public static TaskDTO toDTO(final Task deal) {
		final ModelMapper mapper = new ModelMapper();
		return deal != null ? mapper.map(deal, TaskDTO.class) : null;
	}

	public static List<TaskDTO> toListDTO(final List<Task> list) {
		return list.stream().map(TaskConverter::toDTO).collect(Collectors.toList());
	}

	public static TaskDTO toTaskDTO(final Map<String, String> params) {
		final TaskDTO retorno = new TaskDTO();
		for (final Map.Entry<String, String> entry : params.entrySet()) {
			if (entry.getKey().equalsIgnoreCase("name")) {
				retorno.setName(entry.getValue());
			}
		}
		return retorno;
	}

	public static RevisionsDTO toDTO(final RevisionsEntity model) {
		final RevisionsDTO result = new RevisionsDTO();
		result.setCode(model.getCode());
		result.setDate(model.getDate());
		return result;
	}

	public static DTOWithRevision<TaskDTO> toDTO(final EntityWithRevision<Task> model) {
		final DTOWithRevision<TaskDTO> dtoWithRevision = new DTOWithRevision<>();
		dtoWithRevision.setDto(toDTO(model.getEntity()));
		dtoWithRevision.setRevision(toDTO(model.getRevision()));
		return dtoWithRevision;
	}

	public static List<DTOWithRevision<TaskDTO>> toListDTORevision(final List<EntityWithRevision<Task>> listModel) {
		return listModel.stream().map(TaskConverter::toDTO).collect(Collectors.toList());
	}
}