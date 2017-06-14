package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nt.domain.Usuario;

public class UsuariosDao {

	private Configuration cfg = null;
	private SessionFactory factory = null;
	private Session ses = null;
	private Transaction tx = null;

	public UsuariosDao() {
		cfg = new Configuration();
		cfg = cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
	}

	public void abrirSesion() {
		factory = cfg.buildSessionFactory();
		ses = factory.openSession();
	}

	public void cerrarSesion() {
		ses.close();
		factory.close();
	}

	public Usuario validarUsuario(String usuario, String password) {
		Usuario user = new Usuario();

		try {
			abrirSesion();

			String sql = "FROM Usuario WHERE usuario = '" + usuario + "' AND password = '" + password + "'";
			Query query = ses.createQuery(sql);

			if (!query.list().isEmpty()) {
				user = (Usuario) query.list().get(0);
			}else{
				 sql = "FROM Usuario WHERE usuario = '" + usuario + "'";
				 query = ses.createQuery(sql);
				 if (!query.list().isEmpty()) {
						user = (Usuario) query.list().get(0);
				 }
			}
			cerrarSesion();
		} catch (Exception e) {
			e.printStackTrace();
			cerrarSesion();
		}

		return user;
	}

}
