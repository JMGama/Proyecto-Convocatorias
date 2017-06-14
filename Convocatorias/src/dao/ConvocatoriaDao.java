package dao;

import java.util.List;

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
			Transaction tx = ses.beginTransaction();
			ses.save(convocatoria);
			tx.commit();
			cerrarSesion();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			cerrarSesion();
		}
		return false;
	}
	
	public List<Convocatoria> getAllConvocatorias(){
		List<Convocatoria> lista = null;
		try {
			abrirSesion();
			lista = ses.createCriteria(Convocatoria.class).list();
			cerrarSesion();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			cerrarSesion();
		}
		return lista;
	}
}
