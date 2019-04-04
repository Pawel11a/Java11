package project.repository.impl;

import project.exceptions.AppException;
import project.model.Country;
import project.repository.CountryRepository;
import project.repository.generic.AbstractCrudGenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryRepositoryImpl extends AbstractCrudGenericRepository<Country, Long> implements CountryRepository {

    @Override
    public Optional<Country> findByName(String name) {
        Optional<Country> country = Optional.empty();
        EntityManager entityManager = null;
        EntityTransaction tx = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            List<Country> countries = entityManager
                    .createQuery("select c from Country c where c.name = :name", Country.class)
                    .setParameter("name", name)
                    .getResultList();
            country = Optional.ofNullable(countries.isEmpty() ? null : countries.get(0));
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

        return country;
    }
}
