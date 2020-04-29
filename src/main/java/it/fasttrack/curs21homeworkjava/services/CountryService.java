package it.fasttrack.curs21homeworkjava.services;

import it.fasttrack.curs21homeworkjava.domain.Country;

import java.util.List;
import java.util.Map;

public interface CountryService extends CrudService<Country, Long> {

    List<Country> allCountries();

    List<String> countryNames();

    String countryCapital(String countryName);

    Long countryPopulation(String countryName);

    List<Country> countriesFromContinent(String continent);

    String countryNeighbours(String countryName);

    List<Country> countriesFromContinentWithMinimumPopulation(String continent, Long minPopulation);

    List<Country> countriesByNeighbours(String neighbouring, String avoiding);

    Map<String, Long> countryNamesToPopulation();

    Map<String, List<Country>> continentsToCountries();

}
