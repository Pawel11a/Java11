package project.repository;

import project.model.Country;
import project.repository.generic.CrudGenericRepository;

import java.util.Optional;

public interface CountryRepository extends CrudGenericRepository<Country, Long> {

    Optional<Country> findByName(String name);
}
