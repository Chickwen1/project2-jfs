package com.project2.models;


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
	
	@Column(name = "AGENDATYPE")
	private String type;
	
	@OneToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "USERID")
	private User user;

	public Agenda() {
		super();
	}

	public Agenda(int agendaId, String type, User user) {
		super();
		this.agendaId = agendaId;
		this.type = type;
		this.user = user;
	}

	public int getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(int agendaId) {
		this.agendaId = agendaId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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
		return "Agenda [agendaId=" + agendaId + ", type=" + type + ", user=" + user + "]";
	}

}
