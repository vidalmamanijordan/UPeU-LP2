package edu.upeu.ventas.web.docente;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.upeu.ventas.service.DocenteService;
import edu.upeu.ventas.service.impl.DocenteServiceImpl;
import edu.upeu.ventas.web.form.DocenteForm;

public class DocenteNuevoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_MAIN = "/pages/docente/main.jsp";
	private static final String VIEW_FORMULARIO = "/pages/docente/formulario.jsp";

	DocenteService docenteService = new DocenteServiceImpl();

	public DocenteNuevoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_FORMULARIO)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String paterno = request.getParameter("paterno");
		String materno = request.getParameter("materno");

		DocenteForm docenteForm = new DocenteForm();
		docenteForm.setNombre(nombre);
		docenteForm.setApePat(paterno);
		docenteForm.setApeMat(materno);

		docenteService.guardar(docenteForm);

		List<DocenteForm> lista = docenteService.listar();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

}
