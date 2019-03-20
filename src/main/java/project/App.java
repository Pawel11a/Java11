package project;

import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        var sessionFactory = Persistence.createEntityManagerFactory("MY_PROJECT_HIBERNATE");

        var session = sessionFactory.createEntityManager();

        var trans = session.getTransaction();

//        try {
//            trans.begin();
//
//            System.out.println("w transakcji");
//            trans.commit();
//        } catch (Exception ex) {
//            if (trans != null) {
//                trans.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//
//            if (sessionFactory != null) {
//                sessionFactory.close();
//            }
//        }

    }
}
