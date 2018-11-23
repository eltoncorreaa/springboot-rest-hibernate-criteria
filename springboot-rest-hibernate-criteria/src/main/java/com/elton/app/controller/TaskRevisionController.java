package com.elton.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elton.app.converter.TaskConverter;
import com.elton.app.dto.DTOWithRevision;
import com.elton.app.dto.TaskDTO;
import com.elton.app.service.TaskRevisionService;

@RestController
@CrossOrigin
public class TaskRevisionController {

	@Autowired
	private TaskRevisionService service;

	@RequestMapping("/v1/revisions/{taskCode}")
	public ResponseEntity<?> getCityRevisions(@PathVariable final Long taskCode) {
		final List<DTOWithRevision<TaskDTO>> result = TaskConverter.toListDTORevision(service.listTaskRevisions(taskCode));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
