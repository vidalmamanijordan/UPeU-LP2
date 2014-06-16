package edu.upeu.ventas.dao;

import java.util.List;

import edu.upeu.ventas.dominio.Curso;

public interface CursoDAO {
	 
	 List<Curso> listar();
	 
	 void insertar(Curso p);
	 
	 Curso getCusoPorId(String id);
	 
	 void actualizar(Curso curso);
	 
	 void eliminar(String id);
}
