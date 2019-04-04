package project.repository.generic;

import project.exceptions.AppException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AbstractCrudGenericRepository<T, ID> implements CrudGenericRepository<T, ID> {

    protected final EntityManagerFactory entityManagerFactory
            = DbConnection.getInstance().getEntityManagerFactory();

    private final Class<T> entityType = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    private final Class<T> idType = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];

    @Override
    public void saveOrUpdate(T data) {

        if (data == null) {
            throw new AppException("Repository - saveOrUpdate method exception");
        }

        EntityManager entityManager = null;
        EntityTransaction tx = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(data);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new AppException("Repository - saveOrUpdate method exception 2");
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        if (id == null) {
            throw new AppException("Repository - findById method exception");
        }

        Optional<T> element = Optional.empty();
        EntityManager entityManager = null;
        EntityTransaction tx = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            element = Optional.ofNullable(entityManager.find(entityType, id));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new AppException("Repository - findById method exception 2");
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return element;
    }

    @Override
    public List<T> findAll() {

        List<T> elements = new ArrayList<>();
        EntityManager entityManager = null;
        EntityTransaction tx = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            elements = entityManager
                    .createQuery("select e from " + entityType.getCanonicalName() + " e", entityType)
                    .getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new AppException("Repository - findAll method exception 2");
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return elements;
    }

    @Override
    public void delete(ID id) {

        if (id == null) {
            throw new AppException("Repository - delete method exception");
        }

        EntityManager entityManager = null;
        EntityTransaction tx = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            T entity = entityManager.find(entityType, id);
            entityManager.remove(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new AppException("Repository - delete method exception 2");
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
