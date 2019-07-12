package com.project2.service;

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

	@Transactional
	public void createTask(Task task) {
		taskDAO.save(task);
	}

	@Transactional
	public Task findOne(Integer id) {
		return taskDAO.findOne(id);
	}

	@Transactional
	public void delete(Integer id) {
		taskDAO.delete(id);
	}
	@Override
	public void update(Task task) {
		taskDAO.save(task);
	}

}