package com.elton.app.objectfactory;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.elton.app.dto.TaskDTO;
import com.elton.app.model.Task;

/**
 * Classe utilizada nas classes de teste com a finalidade de criacao das
 * entidades reutilizáveis Ver: http://martinfowler.com/bliki/ObjectMother.html
 */
@Component
public class TaskMother {

	private static final String NOME_TASK_TESTE_PADRAO = "Task Padrao";
	private static final Integer ANO_2014 = 2014;


	public static TaskDTO getTaskDTOPadrao() {
		final TaskDTO taskDTO = new TaskDTO();
		final DateTime dataInicio = new DateTime(ANO_2014, 1, 1, 0, 0, 0);
		taskDTO.setName(NOME_TASK_TESTE_PADRAO);
		taskDTO.setStartDate(dataInicio.toDate());
		return taskDTO;
	}

	public static Task getTaskPadrao() {
		final Task task = new Task();
		final DateTime dataInicio = new DateTime(ANO_2014, 1, 1, 0, 0, 0);
		task.setId(1L);
		task.setName(NOME_TASK_TESTE_PADRAO);
		task.setStartDate(dataInicio.plusYears(1).toDate());
		return task;
	}
}
