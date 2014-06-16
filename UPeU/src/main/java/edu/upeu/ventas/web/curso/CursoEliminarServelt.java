package edu.upeu.ventas.web.curso;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.upeu.ventas.service.CursoService;
import edu.upeu.ventas.service.impl.CursoServiceImpl;
import edu.upeu.ventas.web.form.CursoForm;

public class CursoEliminarServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_MAIN = "/pages/curso/main.jsp";
	
	private CursoService cursoService = new CursoServiceImpl();
	
    public CursoEliminarServelt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("lLEGOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		cursoService = new CursoServiceImpl();
		cursoService.eliminar(String.valueOf(request.getParameter("id")));
		cursoService = new CursoServiceImpl();
		
		List<CursoForm> lista = cursoService.listar();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CursoForm> lista = cursoService.listar();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

}
