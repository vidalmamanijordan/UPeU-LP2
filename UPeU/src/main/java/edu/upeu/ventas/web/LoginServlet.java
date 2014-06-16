package edu.upeu.ventas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.upeu.ventas.service.UsuarioService;
import edu.upeu.ventas.service.impl.UsuarioServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_HOME = "/pages/home.jsp";
	private static final String VIEW_ERROR_LOGIN = "/pages/error_login.jsp";
	UsuarioService usuarioService = new UsuarioServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {

			if (usuarioService.verificarAcceso(username, password)) {
				request.getRequestDispatcher(VIEW_HOME).forward(request,
						response);
			} else {
				request.getRequestDispatcher(VIEW_ERROR_LOGIN).forward(request,
						response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
