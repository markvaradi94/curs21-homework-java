package it.fasttrack.curs21homeworkjava.bootstrap;

import it.fasttrack.curs21homeworkjava.CountryReader;
import it.fasttrack.curs21homeworkjava.domain.Country;
import it.fasttrack.curs21homeworkjava.services.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final CountryService countryService;

    public DataLoader(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = countryService.findAll().size();
        if (count == 0) loadData();
    }

    private void loadData() throws FileNotFoundException {
        File countryFile = new File("src\\main\\resources\\countries2.txt");
        CountryReader reader = new CountryReader();
        List<Country> countries = reader.readCountries(countryFile);
        countries.forEach(countryService::save);

        System.out.println("Loaded Countries");

    }
}
