package pl.accepted.challenge.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import pl.accepted.challenge.model.challenges.FirstWinChallenge;
import pl.accepted.challenge.model.challenges.QuantityChallenge;
import pl.accepted.challenge.model.users.User;

import java.io.File;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;

	private static Class[] classes = {User.class, FirstWinChallenge.class, QuantityChallenge.class};
	
	static
	{
		Configuration configuration = new Configuration();
		configuration.configure(new File("hibernate.cfg.xml"));
		for(Class c: classes) {
			configuration.addAnnotatedClass(c);
		}
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
