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

public class AlumnoEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_MAIN = "/pages/alumno/main.jsp";
	
	private AlumnoService alumnoService = new AlumnoServiceImpl();
	
    public AlumnoEliminarServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("lLEGOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		alumnoService = new AlumnoServiceImpl();
		alumnoService.eliminar(String.valueOf(request.getParameter("id")));
		alumnoService = new AlumnoServiceImpl();
		List<AlumnoForm> lista = alumnoService.listar();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AlumnoForm> lista = alumnoService.listar();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

}
