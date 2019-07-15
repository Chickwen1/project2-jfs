package com.project2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.dao.AgendaDAO;
import com.project2.models.Agenda;
import com.project2.models.User;

@Service
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	private AgendaDAO agendaDAO;

	@Transactional
	public Agenda createAgenda(Agenda agenda) {
		return agendaDAO.save(agenda);
	}

	@Transactional
	public Agenda findOne(Integer id) {
		return agendaDAO.findOne(id);
	}

	@Transactional
	public int delete(int id) {
		return agendaDAO.delete(id);
	}
	@Override
	public void update(Agenda agenda) {
		agendaDAO.save(agenda);
	}

	@Transactional
	public List<Agenda> list() {
		return agendaDAO.list();
	}
	
}