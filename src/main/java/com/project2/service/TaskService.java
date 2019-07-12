package com.project2.service;

import com.project2.models.Task;

public interface TaskService {

	void createTask(Task task);

	void update(Task task);

	Task findOne(Integer id);

	void delete(Integer id);
	
}
