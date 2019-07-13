package com.project2.service;

import java.util.List;

import com.project2.models.Task;
import com.project2.models.User;

public interface TaskService {

	void createTask(Task task);

	Task update(Task task);

	Task findOne(Integer id);

	Task delete(Integer id);

	List<Task> list();
	
}
