package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.domain.Comentario;
import com.nt.domain.Convocatoria;

import dao.ConvocatoriaDao;

public class RevisionConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RevisionConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String forward = "";
		
		int idConvocatoria = Integer.parseInt(request.getParameter("idConvocatoria"));
		String action = request.getParameter("action");
		
		ConvocatoriaDao  convocatoriaDao = new ConvocatoriaDao();
		Convocatoria convocatoria = convocatoriaDao.getConvocatoria(idConvocatoria);
		
		DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		String fechaFinal = fecha.format(convocatoria.getFechaFinal());
		String fechaInicial = fecha.format(convocatoria.getFechaInicial());
		
		if (action.equals("revisar")) {
			request.setAttribute("fechaInicial", fechaInicial);
			request.setAttribute("fechaFinal", fechaFinal);
			request.setAttribute("convocatoria", convocatoria);
			request.setAttribute("idConvocatoria", idConvocatoria);
			forward = "/revisionConvocatoria.jsp";
		}else{
			
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		
		String action = request.getParameter("action");
		int idConvocatoria = Integer.parseInt(request.getParameter("idConvocatoria"));
		
		if (action.equals("Autorizar")){
			Convocatoria convocatoria = new Convocatoria();
			
			convocatoria.setIdConvocatoria(idConvocatoria);
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
			convocatoria.setEstado("Autorizada");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			try {
				convocatoria.setFechaInicial(dateFormat.parse(request.getParameter("fechaInicioConv").replace('-', '/')));
				convocatoria.setFechaFinal(dateFormat.parse(request.getParameter("fechaFinalConv").replace('-', '/')));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			ConvocatoriaDao convocatoriaDao = new ConvocatoriaDao();
			if (convocatoriaDao.updateConvocatoria(convocatoria)) {
				request.setAttribute("mensaje", "1");
				request.setAttribute("convocatorias", convocatoriaDao.getAllConvocatorias());
				
				forward = "/adminConvocatorias.jsp";
				convocatoriaDao.cerrarfactory();
			}else{
				request.setAttribute("mensaje", "2");
				request.setAttribute("convocatorias", convocatoriaDao.getAllConvocatorias());
				
				forward = "/adminConvocatorias.jsp";
				convocatoriaDao.cerrarfactory();
			}
		}else {
			Convocatoria convocatoria = new Convocatoria();
			
			convocatoria.setIdConvocatoria(idConvocatoria);
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
			convocatoria.setEstado("Correccion");

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			try {
				convocatoria.setFechaInicial(dateFormat.parse(request.getParameter("fechaInicioConv").replace('-', '/')));
				convocatoria.setFechaFinal(dateFormat.parse(request.getParameter("fechaFinalConv").replace('-', '/')));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			ConvocatoriaDao convocatoriaDao = new ConvocatoriaDao();
			if (convocatoriaDao.updateConvocatoria(convocatoria)) {
				request.setAttribute("mensaje", "1");
				request.setAttribute("convocatorias", convocatoriaDao.getAllConvocatorias());
				
				forward = "/adminConvocatorias.jsp";
				convocatoriaDao.cerrarfactory();
			}else{
				request.setAttribute("mensaje", "2");
				request.setAttribute("convocatorias", convocatoriaDao.getAllConvocatorias());
				
				forward = "/adminConvocatorias.jsp";
				convocatoriaDao.cerrarfactory();
			}
			 /*
			String comentarioDatos = request.getParameter("datosComentario");
			String comentarioDatos = request.getParameter("datosComentario");
			Comentario comentario = new Comentario();
			*/
			
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
