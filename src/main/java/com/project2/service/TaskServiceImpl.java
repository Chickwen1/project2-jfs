package com.project2.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.dao.AgendaDAO;
import com.project2.dao.TaskDAO;
import com.project2.models.Agenda;
import com.project2.models.Task;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDAO taskDAO;
	
	@Autowired
	private AgendaDAO agendaDAO;

//	@Transactional
//	public Task createTask(Task task) {
//		return taskDAO.save(task);
//	}

	@Transactional
	public Task findOne(Integer id) {
		return taskDAO.findOne(id);
	}

	@Transactional
	public int delete(int id) {
		
		return taskDAO.delete(id);
	}
	@Override
	public Task update(Task task) {
		return taskDAO.save(task);
	}

	@Transactional
	public List<Task> list() {
		return taskDAO.list();
	}

	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Task save(Task task) {
		System.out.println("Agenda ID:" + task.getAgenda().getAgendaId());
		Agenda agenda = agendaDAO.findOne(task.getAgenda().getAgendaId());
		
		
		task.setAgenda(agenda);
		return taskDAO.save(task);
	}

//	@Transactional
//	public Task createTask(Task task) {
//		if(task.getTaskId()==-1 || task.getTaskId()==0)
//			return taskDAO.save(task);
//		
//		return null;
//	}

//	@Override
//	public Task save(Task task) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
