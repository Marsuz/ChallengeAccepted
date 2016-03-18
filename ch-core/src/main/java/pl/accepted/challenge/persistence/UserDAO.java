package pl.accepted.challenge.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import pl.accepted.challenge.model.users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2016-03-18.
 */

@Repository
public class UserDAO {

    public List<User> findByIds(long... ids) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = new ArrayList<User>();
        for(long x : ids) {
            users.add(session.get(User.class, x));
        }

        transaction.commit();
        session.close();

        return users;

    }

    public void removeByIds(long... ids) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = new ArrayList<User>();
        for(long x : ids) {
            User toDelete = session.get(User.class, x);
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
            session.persist(x);
        }

        transaction.commit();
        session.close();

    }

    public List<User> findAll() {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = session.createCriteria(User.class).list();

        transaction.commit();
        session.close();

        return users;

    }

}
