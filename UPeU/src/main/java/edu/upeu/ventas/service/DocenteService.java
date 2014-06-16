package edu.upeu.ventas.service;

import java.util.List;

import edu.upeu.ventas.web.form.DocenteForm;

public interface DocenteService {

	void guardar(DocenteForm df);

	List<DocenteForm> listar();

	DocenteForm getDocentePorId(String id);

}
