package edu.upeu.ventas.dao;

import java.util.List;

import edu.upeu.ventas.dominio.Alumno;

public interface AlumnoDAO {

	void insertar(Alumno p);

	List<Alumno> listar();

	Alumno getAlumnoPorId(String id);

	void actualizar(Alumno alumno);

}
