package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConvocatoriaDao;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String forward = "";
		
		request.setAttribute("mensaje", "0");
		
		forward = "/nuevaConvocatoria.jsp";

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		ConvocatoriaDao convocatoriasDao = new ConvocatoriaDao();
		request.setAttribute("convocatorias", convocatoriasDao.getAllConvocatorias());
		
		request.setAttribute("mensaje", "0");
		
		forward = "/adminConvocatorias.jsp";

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
