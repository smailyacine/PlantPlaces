package com.plantplaces.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		try{
			//create the session factory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		}
		catch(Throwable ex){
			//make sure you log the exception as it might be swallowed
			System.err.println("initial sessionfactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}		
	}	
	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}
	public static void shutdown(){
		//close cache and connnection pools
		getSessionFactory().close();
	}
}
