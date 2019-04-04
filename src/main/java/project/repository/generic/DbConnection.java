package project.repository.generic;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class DbConnection {

    private static DbConnection ourInstance = new DbConnection();

    public static DbConnection getInstance() {
        return ourInstance;
    }

    private DbConnection() {
    }

    private EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("MY_PROJECT_HIBERNATE");

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void close() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
