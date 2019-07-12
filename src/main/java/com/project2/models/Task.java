package com.project2.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT2TASKS")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskid_gen")
	@SequenceGenerator(name = "taskid_gen", sequenceName = "PROJECT2_TASK_ID", allocationSize = 1)
	@Column(name = "TASK_ID")
	private int taskId;
	
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "TASK_DESCRIPTION")
	private String taskDescription;
	
	@Column(name = "DURATION")
	private int duration;
	
	@Column(name = "LOCATION")
	private String location;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "AGENDA_ID")
	private Agenda agenda;

	public Task() {
		super();
	}

	public Task(int taskId, Date date, String taskDescription, int duration, String location, Agenda agenda) {
		super();
		this.taskId = taskId;
		this.date = date;
		this.taskDescription = taskDescription;
		this.duration = duration;
		this.location = location;
		this.agenda = agenda;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agenda == null) ? 0 : agenda.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + duration;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((taskDescription == null) ? 0 : taskDescription.hashCode());
		result = prime * result + taskId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (agenda == null) {
			if (other.agenda != null)
				return false;
		} else if (!agenda.equals(other.agenda))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (duration != other.duration)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (taskDescription == null) {
			if (other.taskDescription != null)
				return false;
		} else if (!taskDescription.equals(other.taskDescription))
			return false;
		if (taskId != other.taskId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", date=" + date + ", taskDescription=" + taskDescription + ", duration="
				+ duration + ", location=" + location + ", agenda=" + agenda + "]";
	}
	
	
}
