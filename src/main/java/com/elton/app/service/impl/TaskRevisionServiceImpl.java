package com.elton.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elton.app.model.EntityWithRevision;
import com.elton.app.model.Task;
import com.elton.app.repository.TaskRevisionRepository;
import com.elton.app.service.TaskRevisionService;

@Transactional(readOnly = true)
@Service
public class TaskRevisionServiceImpl implements TaskRevisionService{

	@Autowired
	private TaskRevisionRepository repository;

	@Override
	public List<EntityWithRevision<Task>> listTaskRevisions(final Long taskCode) {
		return repository.listTaskRevisions(taskCode);
	}
}