//package pl.accepted.challenge.persistence;
//
//import challenges.QuantityChallenge;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class QuantityChallengeService {
//
//    public List<QuantityChallenge> findByIds(long... ids) {
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<QuantityChallenge> challenges = new ArrayList<>();
//        for(long x : ids) {
//            QuantityChallenge challenge =  session.get(QuantityChallenge.class, x);
//            challenges.add(challenge);
//        }
//
//
//        transaction.commit();
//        session.close();
//
//        return challenges;
//
//    }
//
//    public void removeByIds(long... ids) {
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        for(long x : ids) {
//
//            QuantityChallenge toDelete = session.get(QuantityChallenge.class, x);
//            if(toDelete != null) {
//                session.delete(toDelete);
//            }
//
//        }
//
//        transaction.commit();
//        session.close();
//
//    }
//
//    public void updateChallenge(QuantityChallenge... challenges) {
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        for(QuantityChallenge x : challenges) {
//            session.save(x);
//        }
//
//        transaction.commit();
//        session.close();
//
//    }
//
//    public List<QuantityChallenge> findAll() {
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<QuantityChallenge> challenges = session.createQuery("from QuantityChallenge").list();
//
//        transaction.commit();
//        session.close();
//
//        return challenges;
//
//    }
//}
