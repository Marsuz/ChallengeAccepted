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

    private static AtomicLong idCounter = new AtomicLong(1);

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
            session.save(x);
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

    public static long getNextId() {

        return idCounter.getAndIncrement();

    }

}
