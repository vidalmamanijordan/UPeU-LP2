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

public class DocenteEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_MAIN = "/pages/docente/main.jsp";
	
	private DocenteService docenteService = new DocenteServiceImpl();
	

    public DocenteEliminarServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("lLEGOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		
		docenteService = new DocenteServiceImpl();
		docenteService.eliminar(String.valueOf(request.getParameter("id")));
		docenteService = new DocenteServiceImpl();
		List<DocenteForm> lista = docenteService.listar();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DocenteForm> lista = docenteService.listar();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

}
