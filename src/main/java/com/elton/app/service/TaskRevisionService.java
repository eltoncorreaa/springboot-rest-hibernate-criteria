package com.elton.app.service;

import java.util.List;

import com.elton.app.model.EntityWithRevision;
import com.elton.app.model.Task;

public interface TaskRevisionService {

	List<EntityWithRevision<Task>> listTaskRevisions(Long taskCode);
}
