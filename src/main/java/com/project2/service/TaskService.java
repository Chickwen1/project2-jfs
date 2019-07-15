package com.project2.service;

import java.util.List;

import com.project2.models.Task;
import com.project2.models.User;

public interface TaskService {

	Task createTask(Task task);

	Task update(Task task);

	Task findOne(Integer id);

	int delete(int id);

	List<Task> list();

	Task save(Task task);

	//Task save(Task task);

	
}
