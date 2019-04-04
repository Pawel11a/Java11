package project;

import project.repository.impl.CountryRepositoryImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        var countryRepository = new CountryRepositoryImpl();

        // countryRepository.saveOrUpdate(Country.builder().name("GER").capital("BER").build());
        // countryRepository.saveOrUpdate(Country.builder().name("UK").capital("LON").build());

        // countryRepository.saveOrUpdate(Country.builder().id(1L).name("FRA").capital("PAR").build());

        // countryRepository.findAll().forEach(System.out::println);

        // countryRepository.findById(1L).ifPresent(System.out::println);

        // countryRepository.delete(1L);

        countryRepository.findByName("GER").ifPresent(System.out::println);

    }
}
