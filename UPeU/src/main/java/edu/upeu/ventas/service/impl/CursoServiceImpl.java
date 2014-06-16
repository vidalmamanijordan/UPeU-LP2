package edu.upeu.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import edu.upeu.ventas.dao.CursoDAO;
import edu.upeu.ventas.dao.impl.CursoDAOJdbcImpl;
import edu.upeu.ventas.dominio.Curso;
import edu.upeu.ventas.service.CursoService;
import edu.upeu.ventas.web.form.CursoForm;

public class CursoServiceImpl implements CursoService {

	CursoDAO cursoDAO = new CursoDAOJdbcImpl();
	
	public void guardar(CursoForm a) {
		
		Curso curso = new Curso();
		
		curso.setNombre(a.getNombre());;
		curso.setNroHoras(a.getNroHoras());
		curso.setNroCreditos(a.getNroCreditos());

		if (StringUtils.isEmpty(a.getId())) {
			cursoDAO.insertar(curso);
		} else {
			curso.setId(a.getId());
			cursoDAO.actualizar(curso);
		}

	}

	public List<CursoForm> listar() {

		List<CursoForm> l = new ArrayList<CursoForm>();

		List<Curso> lista = cursoDAO.listar();
		System.out.println("Lista devuelta :" + lista.size());

		for (Curso p : lista) {
			
			CursoForm pf = new CursoForm();
			
			pf.setId(p.getId());
			pf.setNombre(p.getNombre());
			pf.setNroHoras(p.getNroHoras());
			pf.setNroCreditos(p.getNroCreditos());

			l.add(pf);
		}

		return l;
	}
	
	public CursoForm getCursoPorId(String id) {
		
		CursoForm a = new CursoForm();
		
		Curso curso = cursoDAO.getCusoPorId(id);

		if (curso != null) {
			a.setId(curso.getId());
			a.setNombre(curso.getNombre());
			a.setNroHoras(curso.getNroHoras());
			a.setNroCreditos(curso.getNroCreditos());
		}

		return a;
	}
}
