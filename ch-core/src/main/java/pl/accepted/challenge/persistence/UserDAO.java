package pl.accepted.challenge.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.accepted.challenge.model.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Marcin on 2016-03-18.
 */

@Repository
public class UserDAO {

    /*private static AtomicLong idCounter = new AtomicLong(1);*/

    public List<User> findByIds(long... ids) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = new ArrayList<User>();
        for(long x : ids) {
            User user = (User) session.get(User.class, x);
            users.add(user);
        }

        transaction.commit();
        session.close();

        return users;
    }

    public void removeByIds(long... ids) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        for(long x : ids) {
            User toDelete = (User) session.get(User.class, x);
            if(toDelete != null) {
                session.delete(toDelete);
            }
        }

        transaction.commit();
        session.close();

    }

    public void updateUsers(User... users) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        for(User x : users) {
            List<User> usersWithGivenNick = session.createQuery("from User u where u.nick = :uname").setParameter("uname", x.getNick()).list();
            if(usersWithGivenNick.size() != 0) continue;
            session.persist(x);
        }

        transaction.commit();
        session.close();

    }

    public List<User> findAll() {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = session.createQuery("from User").list();

        transaction.commit();
        session.close();

        return users;

    }

    public User findByNickAndPass(String username, String pass) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = session.createQuery("from User u where u.nick = :uname " +
                        "and u.hashedPass = :pass").setParameter("uname", username).setParameter("pass", pass).list();

        transaction.commit();
        session.close();

        if(users.size() == 0) return null;
        return users.get(0);


    }

    public User findByNick(String username) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = session.createQuery("from User u where u.nick = :uname").setParameter("uname", username).list();

        transaction.commit();
        session.close();

        if(users.size() == 0) return null;
        return users.get(0);


    }

    /*public static long getNextId() {

        return idCounter.getAndIncrement();

    }*/

}
