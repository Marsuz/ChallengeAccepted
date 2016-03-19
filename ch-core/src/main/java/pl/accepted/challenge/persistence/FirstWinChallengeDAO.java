package pl.accepted.challenge.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import pl.accepted.challenge.model.challenges.FirstWinChallenge;
import pl.accepted.challenge.model.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Marcin on 2016-03-18.
 */

@Repository
public class FirstWinChallengeDAO{

   /* private static AtomicLong idCounter = new AtomicLong(1);*/

    public List<FirstWinChallenge> findByIds(long... ids) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<FirstWinChallenge> challenges = new ArrayList<>();
        for(long x : ids) {
            FirstWinChallenge challenge =  session.get(FirstWinChallenge.class, x);
            challenges.add(challenge);
        }

        transaction.commit();
        session.close();

        return challenges;

    }

    public void removeByIds(long... ids) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        for(long x : ids) {

            FirstWinChallenge toDelete = session.get(FirstWinChallenge.class, x);
            if(toDelete != null) {
                session.delete(toDelete);
            }

        }

        transaction.commit();
        session.close();

    }

    public void updateChallenge(FirstWinChallenge... challenges) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        for(FirstWinChallenge x : challenges) {
            session.save(x);
        }

        transaction.commit();
        session.close();

    }

    public List<FirstWinChallenge> findAll() {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<FirstWinChallenge> challenges = session.createQuery("from FirstWinChallenge").list();

        transaction.commit();
        session.close();

        return challenges;

    }

    public FirstWinChallenge findByName(String name) {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        List<FirstWinChallenge> challenges = session.createQuery("from FirstWinChallenge ch where ch.name = :chname").setParameter("chname", name).list();

        transaction.commit();
        session.close();

        if(challenges.size() == 0) return null;
        return challenges.get(0);


    }

    /*public static long getNextId() {

        return idCounter.getAndIncrement();

    }*/


}
