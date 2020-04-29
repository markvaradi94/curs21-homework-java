package it.fasttrack.curs21homeworkjava.controllers;

import it.fasttrack.curs21homeworkjava.domain.Country;
import it.fasttrack.curs21homeworkjava.services.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    List<Country> countriesByNeighbours(@RequestParam(required = false) String neighbouring,
                                        @RequestParam(required = false) String avoiding) {
        if (neighbouring == null || avoiding == null) {
            return countryService.allCountries();
        } else {
            return countryService.countriesByNeighbours(neighbouring, avoiding);

        }
    }

    @GetMapping("/countries/names")
    List<String> countryNames() {
        return countryService.countryNames();
    }

    @GetMapping("/countries/{id}/capital")
    String countryCapital(@PathVariable Long id) {
        return countryService.countryCapital(countryService.findById(id).getName());
    }

    @GetMapping("/countries/{id}/population")
    Long countryPopulation(@PathVariable Long id) {
        return countryService.countryPopulation(countryService.findById(id).getName());
    }

    @GetMapping("/continents/{continentName}/countries")
    List<Country> continentCountriesWithMinimumPopulation(@PathVariable String continentName,
                                                          @RequestParam(required = false) Long minPopulation) {
        if (minPopulation == null) {
            return countryService.countriesFromContinent(continentName);
        } else {
            return countryService.countriesFromContinentWithMinimumPopulation(continentName, minPopulation);
        }
    }

    @GetMapping("/countries/{id}/neighbours")
    String countryNeighbours(@PathVariable Long id) {
        return countryService.countryNeighbours(countryService.findById(id).getName());
    }

    @GetMapping("/countries/population")
    Map<String, Long> countryNamesToPopulation() {
        return countryService.countryNamesToPopulation();
    }

    @GetMapping("/continents/countries")
    Map<String, List<Country>> continentsToCountries() {
        return countryService.continentsToCountries();
    }
}
