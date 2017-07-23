package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.domain.Convocatoria;

import dao.ConvocatoriaDao;
import util.ManejadorCorreos;

public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		
		int idConvocatoria = Integer.parseInt(request.getParameter("idConvocatoria"));
		String email = request.getParameter("email");
		
		ManejadorCorreos manejadorCorreos = new ManejadorCorreos();
		
		Convocatoria convocatoria = new Convocatoria();
		ConvocatoriaDao convocatoriaDao = new ConvocatoriaDao();
		convocatoria = convocatoriaDao.getConvocatoria(idConvocatoria);
		String asunto = "Convocatoria: " + convocatoria.getTitulo();
		String mensaje = "<h1>"+convocatoria.getTitulo()+"</h1>" +
				"\n <h1>Objetivo:</h1> "+
				"\n <p>" + convocatoria.getObjetivo() + "</p>" +
				"\n <h1>Bases:</h1> "+
				"\n <p>" + convocatoria.getBases() + "</p>" +
				"\n <h1>Requisitos:</h1> " + 
				"\n <p>" + convocatoria.getRequisitos() + "</p>" +
				"\n <h1>Informes:</h1> " + 
				"\n <h2>Telefono: " + convocatoria.getTelefono() +
				"\n Correo: " + convocatoria.getCorreo() + 
				"\n Pagina Web: " + convocatoria.getPaginaWeb() +
				"\n Direccion: " + convocatoria.getDireccion() + 
				"\n Responsable: " + convocatoria.getResponsable() +
				"\n Fecha inicial: " + convocatoria.getFechaInicial() +
				"\n Fecha final: " + convocatoria.getFechaFinal() + "</h2>" +
				"\n <h1>Redes Sociales:</h1> " + 
				"\n <h2>Facebook: " + convocatoria.getFacebook() + 
				"\n Twitter: " + convocatoria.getTwitter() + 
				"\n Youtube: " + convocatoria.getYoutube() + 
				"\n Instagram: " + convocatoria.getInstagram() + "</h2>";
		

			try {
				manejadorCorreos.enviarCorreo(email,asunto,mensaje);
			} catch (NoSuchProviderException e) {
				System.out.println("error aqui");
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		
		forward = "/index.jsp";
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
