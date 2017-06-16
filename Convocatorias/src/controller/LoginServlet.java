package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Usuario;

import dao.ConvocatoriaDao;
import dao.UsuariosDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		
		request.setAttribute("msjErrorUser", "");
		request.setAttribute("msjErrorPass", "");
		
		ConvocatoriaDao convocatoriasDao = new ConvocatoriaDao();
		request.setAttribute("convocatorias", convocatoriasDao.getAllConvocatorias());
		
		forward = "/home.jsp";
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		try {
			UsuariosDao usuarioDao = new UsuariosDao();
			Usuario user = usuarioDao.validarUsuario(usuario, password);
			
			if(user.getUsuario() == null){
				user.setUsuario(" ");
			}
			if(user.getPassword() == null){
				user.setPassword(" ");
			}
			
			if(!user.getPassword().equals(password) && !user.getUsuario().equals(usuario)){
				request.setAttribute("msjErrorUser", "1");
				request.setAttribute("msjErrorPass", "1");
				ConvocatoriaDao convocatoriasDao = new ConvocatoriaDao();
				request.setAttribute("convocatorias", convocatoriasDao.getAllConvocatorias());
				forward = "/home.jsp";
			}else if(!user.getPassword().equals(password) && user.getUsuario().equals(usuario)){
				request.setAttribute("msjErrorUser", usuario);
				request.setAttribute("msjErrorPass", "1");
				ConvocatoriaDao convocatoriasDao = new ConvocatoriaDao();
				request.setAttribute("convocatorias", convocatoriasDao.getAllConvocatorias());
				forward = "/home.jsp";
			}else if(user.getPassword().equals(password) && !user.getUsuario().equals(usuario)){
				request.setAttribute("msjErrorUser", "1");
				request.setAttribute("msjErrorPass", "");
				ConvocatoriaDao convocatoriasDao = new ConvocatoriaDao();
				request.setAttribute("convocatorias", convocatoriasDao.getAllConvocatorias());
				forward = "/home.jsp";
			}else if (user.getPassword().equals(password) && user.getUsuario().equals(usuario)){
				request.setAttribute("msjErrorUser", "");
				request.setAttribute("msjErrorPass", "");
				forward = "/AdminServlet";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
