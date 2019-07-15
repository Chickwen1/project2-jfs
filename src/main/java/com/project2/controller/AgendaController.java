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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.dao.TaskDAO;
import com.project2.models.Agenda;
import com.project2.models.Task;
import com.project2.models.User;
import com.project2.service.AgendaService;


@RestController
@RequestMapping("agenda")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;
	
	@Autowired
	private TaskDAO taskDAO;

	@PostMapping()
	public @ResponseBody ResponseEntity<Agenda> createAgenda(@RequestBody Agenda agenda) {
		System.out.println("AgendaController->create "  + agenda.getType() );
		Agenda a = agendaService.createAgenda(agenda);
		return new ResponseEntity<Agenda>(a, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody Agenda agenda) {
		System.out.println("AgendaController->update" + id);
		agendaService.update(agenda);
	}

	@GetMapping()
	public List<Agenda> list() {
		List<Agenda> list = agendaService.list();
		return list;
	}
	
	
	@GetMapping("/{agendaId}/tasks")
	public List<Task> findTaskByAgenda(@PathVariable("agendaId") Integer agendaId) {
		List<Task> t = taskDAO.findTaskByAgenda(agendaId);
		return t;
	}  
	
	@GetMapping("/{agendaId}")
	public Agenda findOne(@PathVariable("agendaId") Integer id) {
		Agenda agenda = agendaService.findOne(id);
		return agenda;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAgenda(@PathVariable("id") int id) {
		int agenda = agendaService.delete(id);
		if(agenda !=0) {
		return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
