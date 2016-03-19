package pl.accepted.challenge.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import pl.accepted.challenge.model.users.User;

import java.io.File;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	static
	{
		Configuration configuration = new Configuration();
		configuration.configure(new File("ch-core/src/main/resources/hibernate.cfg.xml"));
		configuration.addAnnotatedClass(User.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
	
	public static void shutdown() {
		getSessionFactory().close();
	}
}
