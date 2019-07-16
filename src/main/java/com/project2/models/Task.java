package com.project2.models;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name = "TASKDATE")
	private LocalDateTime taskDate;
	
	@Column(name = "TASK_DESCRIPTION")
	private String taskDescription;
	
	@Column(name = "DURATION")
	private int duration;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "TASKSTATUS")
	private String taskStatus;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "AGENDA_ID")
	private Agenda agenda;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(int taskId, LocalDateTime taskDate, String taskDescription, int duration, String location,
			String taskStatus, Agenda agenda) {
		super();
		this.taskId = taskId;
		this.taskDate = taskDate;
		this.taskDescription = taskDescription;
		this.duration = duration;
		this.location = location;
		this.taskStatus = taskStatus;
		this.agenda = agenda;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public LocalDateTime getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDateTime taskDate) {
		this.taskDate = taskDate;
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

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
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
		result = prime * result + duration;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((taskDate == null) ? 0 : taskDate.hashCode());
		result = prime * result + ((taskDescription == null) ? 0 : taskDescription.hashCode());
		result = prime * result + taskId;
		result = prime * result + ((taskStatus == null) ? 0 : taskStatus.hashCode());
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
		if (duration != other.duration)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (taskDate == null) {
			if (other.taskDate != null)
				return false;
		} else if (!taskDate.equals(other.taskDate))
			return false;
		if (taskDescription == null) {
			if (other.taskDescription != null)
				return false;
		} else if (!taskDescription.equals(other.taskDescription))
			return false;
		if (taskId != other.taskId)
			return false;
		if (taskStatus == null) {
			if (other.taskStatus != null)
				return false;
		} else if (!taskStatus.equals(other.taskStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskDate=" + taskDate + ", taskDescription=" + taskDescription
				+ ", duration=" + duration + ", location=" + location + ", taskStatus=" + taskStatus + ", agenda="
				+ agenda + "]";
	}


	
}
