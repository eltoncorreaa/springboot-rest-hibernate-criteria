package com.elton.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elton.app.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>, TaskRepositoryCustom{

}
