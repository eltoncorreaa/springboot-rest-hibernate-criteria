package com.elton.app.repository;

import java.util.List;

import com.elton.app.model.Task;

public interface TaskRepositoryCustom {

	List<Task> findByFilter(Task task);
}
