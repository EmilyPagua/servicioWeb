package modelo;


import java.io.*;
import java.util.*;

import org.hibernate.*;

import entidad.Usuario;

@SuppressWarnings("unchecked")
public abstract class AbstractModel<T> {

    private Class<T> entityClass;
    protected final SessionFactory sessionFactory = HibernateUtil
            .getSessionFactory();

    public AbstractModel(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractModel() {
    }

    public List<T> findAll() {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive())
                sessionFactory.getCurrentSession().getTransaction().begin();

            return sessionFactory.getCurrentSession()
                    .createQuery("from " + entityClass.getName()).list();
            
        } catch (RuntimeException re) {
        	System.out.println(re.getMessage());
            return null;
        }
    }

    public Boolean update(T instance) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive())
                sessionFactory.getCurrentSession().getTransaction().begin();            

            sessionFactory.getCurrentSession().merge(instance);
            sessionFactory.getCurrentSession().getTransaction().commit();
            return true;

        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            System.out.println(re.getMessage());
            throw re;
        }
    }

    public Boolean delete(T instance) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive())
                sessionFactory.getCurrentSession().getTransaction().begin();            

            sessionFactory.getCurrentSession().delete(instance);
            sessionFactory.getCurrentSession().getTransaction().commit();
            return true;

        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            System.out.println(re.getMessage());
            throw re;
        }
    }

    public Boolean create(T instance) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive())
                sessionFactory.getCurrentSession().getTransaction().begin();    
            
            sessionFactory.getCurrentSession().persist(instance);           
            sessionFactory.getCurrentSession().getTransaction().commit();
            return true;
        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            System.out.println(re.getMessage());
            throw re;
        }
    }

    public T find(Object primarykey) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive())
                sessionFactory.getCurrentSession().getTransaction().begin();
                    	
            return (T) sessionFactory.getCurrentSession().get(entityClass,
                    (Serializable) primarykey);
        } catch (RuntimeException re) {
        	System.out.println("Metodo find " + re.getMessage());
            return null;
        }
    }    
       
        
   public Boolean checkLogin(String uname, String pwd) {
    	Boolean isUserAvailable;
    	
    	if (!sessionFactory.getCurrentSession().getTransaction().isActive())
            sessionFactory.getCurrentSession().getTransaction().begin();
    	
    	Query query = sessionFactory.getCurrentSession()
    			.createSQLQuery("SELECT * FROM USUARIO u "
    					+ "WHERE "
    					+ "u.USUARIO = :usuario and "
    					+ "u.CLAVE = :clave ")
    			.addEntity(Usuario.class)
    			.setParameter("usuario", uname)
		        .setParameter("clave", pwd);    		
    	
    	Usuario result = (Usuario) query.uniqueResult();
    	
    	System.out.println("RESULTADO  " +result.getCorreo());
    	
    	if (result != null){
            System.out.println("checkLogin true");
    		isUserAvailable=true;    		
    	}else{
            System.out.println("checkLogin false");
    		isUserAvailable=false;
    		}
    	
    	return isUserAvailable ;    		
	}
}
