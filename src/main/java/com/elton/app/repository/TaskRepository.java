package com.elton.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elton.app.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, TaskRepositoryCustom{

}
