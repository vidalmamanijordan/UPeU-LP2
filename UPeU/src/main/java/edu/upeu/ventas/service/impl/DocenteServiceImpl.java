package edu.upeu.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import edu.upeu.ventas.dao.DocenteDAO;
import edu.upeu.ventas.dao.impl.DocenteDAOJdbcImpl;
import edu.upeu.ventas.dominio.Docente;
import edu.upeu.ventas.service.DocenteService;
import edu.upeu.ventas.web.form.DocenteForm;

public class DocenteServiceImpl implements DocenteService{

	DocenteDAO docenteDAO = new DocenteDAOJdbcImpl();

	public List<DocenteForm> listar() {

		List<DocenteForm> l = new ArrayList<DocenteForm>();

		List<Docente> lista = docenteDAO.listar();

		for (Docente p : lista) {
			DocenteForm pf = new DocenteForm();
			pf.setId(p.getId());
			pf.setNombre(p.getNombre());
			pf.setApePat(p.getApePat());
			pf.setApeMat(p.getApeMat());

			l.add(pf);
		}

		return l;
	}

	public void guardar(DocenteForm df) {
		Docente d = new Docente();
		d.setApePat(df.getApePat());
		d.setApeMat(df.getApeMat());
		d.setNombre(df.getNombre());

		if (StringUtils.isEmpty(df.getId())) {
			docenteDAO.insertar(d);
		} else {
			d.setId(df.getId());
			docenteDAO.actualizar(d);
		}

	}

	public DocenteForm getDocentePorId(String id) {
		DocenteForm df = new DocenteForm();
		Docente d = docenteDAO.getDocentePorId(id);

		if (d != null) {
			df.setId(d.getId());
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());
		}

		return df;
	}
}
