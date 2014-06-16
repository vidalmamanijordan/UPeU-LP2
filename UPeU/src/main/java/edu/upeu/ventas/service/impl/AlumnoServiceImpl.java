package edu.upeu.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import edu.upeu.ventas.dao.AlumnoDAO;
import edu.upeu.ventas.dao.impl.AlumnoDAOJdbcImpl;
import edu.upeu.ventas.dominio.Alumno;
import edu.upeu.ventas.service.AlumnoService;
import edu.upeu.ventas.web.form.AlumnoForm;

public class AlumnoServiceImpl implements AlumnoService {

	AlumnoDAO alumnoDAO = new AlumnoDAOJdbcImpl();

	public List<AlumnoForm> listar() {

		List<AlumnoForm> l = new ArrayList<AlumnoForm>();

		List<Alumno> lista = alumnoDAO.listar();
		System.out.println("Lista devuelta :" + lista.size());

		for (Alumno p : lista) {
			AlumnoForm pf = new AlumnoForm();
			pf.setId(p.getId());
			pf.setNombre(p.getNombre());
			pf.setApePat(p.getApePat());
			pf.setApeMat(p.getApeMat());

			l.add(pf);
		}

		return l;
	}

	public void guardar(AlumnoForm a) {
		Alumno alumno = new Alumno();
		alumno.setApePat(a.getApePat());
		alumno.setApeMat(a.getApeMat());
		alumno.setNombre(a.getNombre());

		if (StringUtils.isEmpty(a.getId())) {
			alumnoDAO.insertar(alumno);
		} else {
			alumno.setId(a.getId());
			alumnoDAO.actualizar(alumno);
		}

	}

	public AlumnoForm getAlumnoPorId(String id) {
		AlumnoForm a = new AlumnoForm();
		Alumno alumno = alumnoDAO.getAlumnoPorId(id);

		if (alumno != null) {
			a.setId(alumno.getId());
			a.setNombre(alumno.getNombre());
			a.setApePat(alumno.getApePat());
			a.setApeMat(alumno.getApeMat());
		}

		return a;
	}

}
