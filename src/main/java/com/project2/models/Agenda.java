package com.project2.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "PROJECT2AGENDA")
public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendaid_gen")
	@SequenceGenerator(name = "agendaid_gen", sequenceName = "PROJECT2_AGENDA_ID", allocationSize = 1)
	@Column(name = "AGENDA_ID")
	private int agendaId;
	
	@Column(name = "DATE")
	private Date date;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskid_gen")
	@SequenceGenerator(name = "taskid_gen", sequenceName = "PROJECT2_TASK_ID", allocationSize = 1)
	@Column(name = "TASK_ID")
	private int taskId;
	
	@Column(name = "TASK")
	private String task;
	
	@Column(name = "DURATION")
	private int duration;
	
	@Column(name = "LOCATION")
	private String location;
	
	@OneToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "USERID")
	private User user;

	public Agenda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agenda(int agendaId, Date date, int taskId, String task, int duration, String location, User user) {
		super();
		this.agendaId = agendaId;
		this.date = date;
		this.taskId = taskId;
		this.task = task;
		this.duration = duration;
		this.location = location;
		this.user = user;
	}

	public int getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(int agendaId) {
		this.agendaId = agendaId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agendaId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + duration;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((task == null) ? 0 : task.hashCode());
		result = prime * result + taskId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Agenda other = (Agenda) obj;
		if (agendaId != other.agendaId)
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
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		if (taskId != other.taskId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agenda [agendaId=" + agendaId + ", date=" + date + ", taskId=" + taskId + ", task=" + task
				+ ", duration=" + duration + ", location=" + location + ", user=" + user + "]";
	}

}
