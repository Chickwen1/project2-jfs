package com.project2.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project2.models.Task;
import com.project2.models.User;
import com.project2.service.TaskService;

@RestController
@RequestMapping("tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

//	@PostMapping()
//	public @ResponseBody ResponseEntity<Object> create(@RequestBody Task task) {
//		System.out.println("TaskController->Create" + task.getTaskId()  +"," + task.getTaskDescription());
//		Task newTask = taskService.createTask(task);
//		return new ResponseEntity<>(newTask, HttpStatus.OK);
//	}
	

	@PostMapping()
	public @ResponseBody ResponseEntity<Task> create(@RequestBody Task task) {
		System.out.println("TaskController->Create" + task.getTaskId()  +"," + task.getTaskDescription() + " " + task.getTaskDate());
		
		Task createdTask = taskService.save(task);
		return new ResponseEntity<Task>(createdTask, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> update(@PathVariable("id") Integer id,@RequestBody Task task) {
		System.out.println("TaskController->update" + id + " " + task.getTaskDate());
		System.out.println(task.getTaskDate());
		
		LocalDateTime date = task.getTaskDate();
		date.plusHours(4);
		task.setTaskDate(date);
		Task t = taskService.update(task);
		return new ResponseEntity<Task>(t, HttpStatus.OK);
	}
	
	
	@GetMapping()
	public List<Task> list() {
		List<Task> list = taskService.list();
		return list;
	}

	@GetMapping("/{id}")
	public Task findOne(@PathVariable("id") Integer id) {
		return taskService.findOne(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable("id") int id) {
		int task = taskService.delete(id);
		if(task!=0) {
		return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
