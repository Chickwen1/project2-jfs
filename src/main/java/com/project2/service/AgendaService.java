package com.project2.service;
import java.util.List;

import com.project2.models.Agenda;


public interface AgendaService {

	void createAgenda(Agenda agenda);

	void update(Agenda agenda);

	Agenda findOne(Integer id);

	void delete(Integer id);

	List<Agenda> list();


}