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
	public void createAgenda(Agenda agenda) {
		agendaDAO.save(agenda);
	}

	@Transactional
	public Agenda findOne(Integer id) {
		return agendaDAO.findOne(id);
	}

	@Transactional
	public void delete(Integer id) {
		agendaDAO.delete(id);
	}
	@Override
	public void update(Agenda agenda) {
		agendaDAO.save(agenda);
	}
	
}