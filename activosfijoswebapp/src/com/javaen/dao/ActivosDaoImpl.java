/**
 * 
 */
package com.javaen.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaen.model.Activo;
import com.javaen.model.Filtro;
import com.javaen.model.TipoActivo;

/**
 * @author giovanni
 *
 */
public class ActivosDaoImpl implements ActivosDao {

	private static final Logger logger = LoggerFactory
			.getLogger(ActivosDaoImpl.class);

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addActivo(Activo a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(a);
		logger.info("Activo saved successfully, Activo Details=" + a);
	}

	@Override
	public void updateActivo(Activo a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(a);
		logger.info("Activo updated successfully, Activo Details=" + a);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activo> listActivos() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Activo");
		List<Activo> activoList = (List<Activo>) query.list();
		return activoList;
	}

	@Override
	public Activo getActivoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Activo a where a.id = :id");
		query.setParameter("id", id);
		Activo a = (Activo) query.uniqueResult();
		logger.info("Activo loaded successfully, activo details=" + a);
		return a;
	}

	@Override
	public void removeActivo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Activo a where a.id = :id");
		query.setParameter("id", id);
		Activo a = (Activo) query.uniqueResult();
		if (a != null) {
			session.delete(a);
		}
		logger.info("Activo deleted successfully, activo details=" + a);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoActivo> listTipoActivos() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TipoActivo");
		List<TipoActivo> activoList = query.list();
		for (TipoActivo p : activoList) {
			logger.info("TipoActivo List::" + p);
			System.out.println("TipoActivo List::" + p);
		}

		return activoList;
	}

	@Override
	public Activo getActivoByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Activo a where a.activo = :nombre");
		query.setParameter("nombre", name);
		Activo a = (Activo) query.uniqueResult();
		if (a != null) {
			return a;
		}
		return null;
	}

	@Override
	public TipoActivo getTipoById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TipoActivo t where t.id = :id");
		query.setParameter("id", Integer.parseInt(id));
		return (TipoActivo) query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Activo> filtrar(Filtro filtro) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Activo a where ";
		int i = 0;
		if (filtro.getSerial() != null && !filtro.getSerial().isEmpty()) {
			if (i == 0) {
				hql += "a.serial = :serial";
			} else {
				hql += " and a.serial = :serial";
			}
			i++;
		}
		if (filtro.getFechaCompra() != null && !filtro.getFechaCompra().isEmpty()) {
			if (i == 0) {
				hql += "a.fechaCompra = :fecha";
			} else {
				hql += " and a.fechaCompra = :fecha";
			}
			i++;
		}
		if (filtro.getTipo() != null && !filtro.getTipo().toString().equalsIgnoreCase("0")) {
			
			if (i == 0) {
				hql += "a.tipo = :tipo";
			} else {
				hql += " and a.tipo = :tipo";
			}
			i++;
		}
		
		Query query = session.createQuery(hql);		
		if (filtro.getSerial() != null && !filtro.getSerial().isEmpty()) {
			query.setParameter("serial", filtro.getSerial());
		}
		if (filtro.getFechaCompra() != null && !filtro.getFechaCompra().isEmpty()) {
			query.setParameter("fecha", this.convertirStringToDate(filtro.getFechaCompra()));
		}
		if (filtro.getTipo() != null && !filtro.getTipo().toString().equalsIgnoreCase("0")) {
			query.setParameter("tipo", this.getTipoById(filtro.getTipo()));
		}
		List<Activo> activoList = (List<Activo>) query.list();
		return activoList;		
	}

	@Override
	public Date convertirStringToDate(String fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");        
		Date date = null;
		if(fecha != null){
			try {
	            date = formatter.parse(fecha);
	            System.out.println(date);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return date;
		}
        return null;
	}

}
