package com.project2.service;
import java.util.List;

import com.project2.models.Agenda;


public interface AgendaService {

	Agenda createAgenda(Agenda agenda);

	void update(Agenda agenda);

	Agenda findOne(Integer id);

	int delete(int id);

	List<Agenda> list();


}