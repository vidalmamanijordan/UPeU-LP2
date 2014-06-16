package edu.upeu.ventas.dao;

import java.util.List;

import edu.upeu.ventas.dominio.Docente;

public interface DocenteDAO {

	List<Docente> listar();

	Docente getDocentePorId(String id);

	void insertar(Docente d);

	void actualizar(Docente d);

}
