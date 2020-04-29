package it.fasttrack.curs21homeworkjava.repositories;

import it.fasttrack.curs21homeworkjava.domain.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
    Country findByName(String countryName);


}
