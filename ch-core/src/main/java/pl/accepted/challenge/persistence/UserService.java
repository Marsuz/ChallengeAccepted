package pl.accepted.challenge.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import users.User;

public interface UserService extends JpaRepository<User,String> {

//    /*private static AtomicLong idCounter = new AtomicLong(1);*/
//
//    public List<User> findByIds(String... ids) {
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<User> users = new ArrayList<>();
//        for(String x : ids) {
//            User user = session.get(User.class, x);
//            users.add(user);
//        }
//
//        transaction.commit();
//        session.close();
//
//        return users;
//    }
//
//    public void removeByIds(String... ids) {
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        for(String x : ids) {
//            User toDelete = session.get(User.class, x);
//            if(toDelete != null) {
//                session.delete(toDelete);
//            }
//        }
//
//        transaction.commit();
//        session.close();
//
//    }
//
//    public void updateUsers(User... users) {
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        for(User x : users) {
//            //User user = session.get(User.class, x.getNick());
//            //session.saveOrUpdate(x);
//            User oldUser = session.get(User.class, x.getNick());
//            if(oldUser != null) {
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
//    public List<User> findAll() {
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<User> users = session.createQuery("from User").list();
//
//        transaction.commit();
//        session.close();
//
//        return users;
//
//    }
//
//    public User findByNickAndPass(String username, String pass) {
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<User> users = session.createQuery("from User u where u.nick = :uname " +
//                        "and u.hashedPass = :pass").setParameter("uname", username).setParameter("pass", pass).list();
//
//        transaction.commit();
//        session.close();
//
//        if(users.size() == 0) return null;
//        return users.get(0);
//
//
//    }
//
//    public User findByNick(String username) {
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<User> users = session.createQuery("from User u where u.nick = :uname").setParameter("uname", username).list();
//
//        transaction.commit();
//        session.close();
//
//        if(users.size() == 0) return null;
//        return users.get(0);
//
//
//    }

    /*public static long getNextId() {

        return idCounter.getAndIncrement();

    }*/

}
