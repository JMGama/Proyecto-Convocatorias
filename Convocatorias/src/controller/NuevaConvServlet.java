package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.domain.Convocatoria;

import dao.ConvocatoriaDao;

public class NuevaConvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NuevaConvServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		
		Convocatoria convocatoria = new Convocatoria();
		
		convocatoria.setTitulo(request.getParameter("tituloConv"));
		convocatoria.setObjetivo(request.getParameter("objetivoConv"));
		convocatoria.setBases(request.getParameter("basesConv"));
		convocatoria.setRequisitos(request.getParameter("requisitosConv"));
		convocatoria.setTelefono(Long.parseLong(request.getParameter("telefonoConv")));
		convocatoria.setCorreo(request.getParameter("correoConv"));
		convocatoria.setPaginaWeb(request.getParameter("paginawebConv"));
		convocatoria.setDireccion(request.getParameter("direccionConv"));
		convocatoria.setResponsable(request.getParameter("responsableConv"));
		convocatoria.setFacebook(request.getParameter("facebookConv"));
		convocatoria.setTwitter(request.getParameter("twitterConv"));
		convocatoria.setYoutube(request.getParameter("youtubeConv"));
		convocatoria.setInstagram(request.getParameter("instagramConv"));
		convocatoria.setEstado("En revision");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
			convocatoria.setFechaInicial(dateFormat.parse(request.getParameter("fechaInicioConv").replace('-', '/')));
			convocatoria.setFechaFinal(dateFormat.parse(request.getParameter("fechaFinalConv").replace('-', '/')));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		ConvocatoriaDao convocatoriaDao = new ConvocatoriaDao();
		if (convocatoriaDao.addConvocatoria(convocatoria)) {
			request.setAttribute("mensaje", "1");
		}else{
			request.setAttribute("mensaje", "2");
		}
		
		forward = "/nuevaConvocatoria.jsp";

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
