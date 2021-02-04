package com.elton.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elton.app.converter.TaskConverter;
import com.elton.app.dto.TaskDTO;
import com.elton.app.service.TaskService;
import com.elton.app.util.Error;
import com.elton.app.util.TaskExceptionHandler;

@CrossOrigin
@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/v1")
	public ResponseEntity<?> findAll(@RequestParam final Map<String, String> params){
		try {
			if(params.isEmpty()) {
				return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(taskService.findByFilter(TaskConverter.toTaskDTO(params)), HttpStatus.OK);
			}
		} catch (final RuntimeException e) {
			return new ResponseEntity<>(new Error(1, TaskExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/v1/{id}")
	public ResponseEntity<?> findById(@PathVariable final Long id){
		try {
			final TaskDTO dto = taskService.findById(id);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<>(new Error(1, TaskExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/v1")
	public ResponseEntity<?> persist(@RequestBody final TaskDTO dto){
		try {
			final TaskDTO inserted= taskService.persist(dto);
			return new ResponseEntity<>(inserted, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<>(new Error(1, TaskExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/v1")
	public ResponseEntity<?> update(@RequestBody final TaskDTO dto){
		try {
			final TaskDTO updated= taskService.update(dto);
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<>(new Error(1, TaskExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/v1/{id}")
	public void delete(@PathVariable final Long id){
		taskService.delete(id);
	}
}