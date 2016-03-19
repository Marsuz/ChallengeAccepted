package pl.accepted.challenge.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import pl.accepted.challenge.model.challenges.FirstWinChallenge;
import pl.accepted.challenge.model.users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2016-03-18.
 */

@Repository
public class FirstWinChallengeDAO{

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


}
