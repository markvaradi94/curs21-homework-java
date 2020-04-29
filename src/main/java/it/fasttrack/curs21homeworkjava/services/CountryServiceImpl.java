package it.fasttrack.curs21homeworkjava.services;

import it.fasttrack.curs21homeworkjava.domain.Country;
import it.fasttrack.curs21homeworkjava.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.*;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> allCountries() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }

    @Override
    public List<String> countryNames() {
        List<String> countryNames = new ArrayList<>();
        countryRepository.findAll().forEach(country -> countryNames.add(country.getName()));
        return countryNames;
    }

    @Override
    public String countryCapital(String countryName) {
        return countryRepository.findByName(countryName).getCapital();
    }

    @Override
    public Long countryPopulation(String countryName) {
        return countryRepository.findByName(countryName).getPopulation();
    }

    @Override
    public List<Country> countriesFromContinent(String continent) {
        return allCountries().stream()
                .filter(country -> isFromContinent(country, continent))
                .collect(toList());
    }

    @Override
    public String countryNeighbours(String countryName) {
        return countryRepository.findByName(countryName).getNeighbours();
    }

    @Override
    public List<Country> countriesFromContinentWithMinimumPopulation(String continent, Long minPopulation) {
        return allCountries().stream()
                .filter(country -> isFromContinent(country, continent))
                .filter(country -> country.getPopulation() >= minPopulation)
                .collect(toList());
    }

    @Override
    public List<Country> countriesByNeighbours(String neighbouring, String avoiding) {
        return allCountries().stream()
                .filter(country -> country.getNeighbours().toLowerCase().contains(neighbouring.toLowerCase()))
                .filter(country -> !country.getNeighbours().toLowerCase().contains(avoiding.toLowerCase()))
                .collect(toList());
    }

    @Override
    public Map<String, Long> countryNamesToPopulation() {
        return allCountries().stream()
                .collect(toMap(Country::getName, Country::getPopulation));
    }

    @Override
    public Map<String, List<Country>> continentsToCountries() {
        return allCountries().stream()
                .collect(groupingBy(Country::getContinent));
    }

    @Override
    public Set<Country> findAll() {
        Set<Country> countries = new HashSet<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    private boolean isFromContinent(Country country, String continent) {
        return country.getContinent().equalsIgnoreCase(continent);
    }
}
