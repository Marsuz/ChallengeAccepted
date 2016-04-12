package pl.accepted.challenge.persistence;

import model.FirstWinChallenge;
import org.springframework.data.repository.CrudRepository;

public interface FirstWinRepository extends CrudRepository<FirstWinChallenge, String> {

   /* private static AtomicLong idCounter = new AtomicLong(1);*/
	//
	//    public List<FirstWinChallenge> findByIds(String... ids) {
	//
	//        Session session = HibernateUtils.getSession();
	//        Transaction transaction = session.beginTransaction();
	//
    //        List<FirstWinChallenge> model.challenges = new ArrayList<>();
    //        for(String x : ids) {
	//            FirstWinChallenge challenge =  session.get(FirstWinChallenge.class, x);
    //            model.challenges.add(challenge);
    //        }
	//
	//        transaction.commit();
	//        session.close();
	//
    //        return model.challenges;
    //
	//    }
	//
	//    public void removeByIds(String... ids) {
	//
	//        Session session = HibernateUtils.getSession();
	//        Transaction transaction = session.beginTransaction();
	//
	//        for(String x : ids) {
	//
	//            FirstWinChallenge toDelete = session.get(FirstWinChallenge.class, x);
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
    //    public void updateChallenge(FirstWinChallenge... model.challenges) {
    //
	//        Session session = HibernateUtils.getSession();
	//        Transaction transaction = session.beginTransaction();
	//
    //        for(FirstWinChallenge x : model.challenges) {
    //            FirstWinChallenge oldChallenge = session.get(FirstWinChallenge.class, x.getName());
	//            if(oldChallenge != null) {
	//                session.merge(x);
	//            } else {
	//                session.persist(x);
	//            }
	//        }
	//
	//        transaction.commit();
	//        session.close();
	//
	//    }
	//
	//    public List<FirstWinChallenge> findAll() {
	//
	//        Session session = HibernateUtils.getSession();
	//        Transaction transaction = session.beginTransaction();
	//
    //        List<FirstWinChallenge> model.challenges = session.createQuery("from FirstWinChallenge").list();
    //
	//        transaction.commit();
	//        session.close();
	//
    //        return model.challenges;
    //
	//    }
	//
	//    public FirstWinChallenge findByName(String name) {
	//
	//        Session session = HibernateUtils.getSession();
	//        Transaction transaction = session.beginTransaction();
	//
	//        FirstWinChallenge challenge = session.get(FirstWinChallenge.class, name);
	//
	//        transaction.commit();
	//        session.close();
	//
	//        return challenge;
	//
	//
	//    }
	//
	//    /*public static long getNextId() {
	//
	//        return idCounter.getAndIncrement();
	//
	//    }*/

}
