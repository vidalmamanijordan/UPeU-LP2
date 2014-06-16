package edu.upeu.ventas.web.alumno;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.upeu.ventas.service.AlumnoService;
import edu.upeu.ventas.service.impl.AlumnoServiceImpl;
import edu.upeu.ventas.web.form.AlumnoForm;

public class AlumnoEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_MAIN = "/pages/alumno/main.jsp";
	private static final String VIEW_FORMULARIO = "/pages/alumno/formulario.jsp";
	
	private AlumnoService alumnoService = new AlumnoServiceImpl();

	public AlumnoEditarServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		AlumnoForm alumno = alumnoService.getAlumnoPorId(id);
		
		request.setAttribute("alumno", alumno);
		request.getRequestDispatcher(VIEW_FORMULARIO).forward(request, response);

	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String paterno = request.getParameter("paterno");
		String materno = request.getParameter("materno");

		AlumnoForm alumnoForm = new AlumnoForm();
		
		alumnoForm.setId(id);
		alumnoForm.setNombre(nombre);
		alumnoForm.setApePat(paterno);
		alumnoForm.setApeMat(materno);

		alumnoService.guardar(alumnoForm);

		List<AlumnoForm> lista = alumnoService.listar();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

}
