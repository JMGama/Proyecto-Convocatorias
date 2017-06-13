package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Convocatoria;

public class ConvocatoriaDao {
	
	private Configuration cfg = null;
	private SessionFactory factory = null;
	private Session ses = null;
	private Transaction tx = null;

	public ConvocatoriaDao() {
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
	
	public boolean addConvocatoria(Convocatoria convocatoria){
		try {
			abrirSesion();
			ses.save(convocatoria);
			cerrarSesion();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			cerrarSesion();
		}
		return false;
	}
}
