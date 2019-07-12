package com.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.models.Task;
import com.project2.service.TaskService;

@RestController
@RequestMapping("tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping()
	public @ResponseBody ResponseEntity<Object> register(@RequestBody Task task) {
		System.out.println("TaskController->save");
		taskService.createTask(task);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody Task task) {
		System.out.println("UserController->update" + id);
		taskService.update(task);
	}

	@GetMapping("/{id}")
	public Task findOne(@PathVariable("id") Integer id) {
		Task task = taskService.findOne(id);
		return task;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		taskService.delete(id);

	}
}
