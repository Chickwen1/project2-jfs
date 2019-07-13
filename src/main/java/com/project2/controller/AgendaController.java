package com.project2.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.models.Agenda;
import com.project2.models.Task;
import com.project2.models.User;
import com.project2.service.AgendaService;


@RestController
@RequestMapping("agenda")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;

	@PostMapping()
	public @ResponseBody ResponseEntity<Object> register(@RequestBody Agenda agenda) {
		System.out.println("AgendaController->create");
		agendaService.createAgenda(agenda);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody Agenda agenda) {
		System.out.println("UserController->update" + id);
		agendaService.update(agenda);
	}

	@GetMapping()
	public List<Agenda> list() {
		List<Agenda> list = agendaService.list();
		return list;
	}
	
	@GetMapping("/{agendaId}")
	public Agenda findOne(@PathVariable("agendaId") Integer id) {
		Agenda agenda = agendaService.findOne(id);
		return agenda;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		agendaService.delete(id);

	}

}
