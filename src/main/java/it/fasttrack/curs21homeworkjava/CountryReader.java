package it.fasttrack.curs21homeworkjava;

import it.fasttrack.curs21homeworkjava.domain.Country;
import org.apache.logging.log4j.util.Strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CountryReader {

    public List<Country> readCountries(File file) throws FileNotFoundException {
        return new BufferedReader(new FileReader(file))
                .lines()
                .map(this::readCountry)
                .collect(toList());
    }

    private Country readCountry(String line) {
        String[] elements = line.split("\\|");
        return new Country(
                elements[0],
                elements[1],
                Long.parseLong(elements[2]),
                Long.parseLong(elements[3]),
                elements[4],
                elements.length > 5 ? readNeighbours(elements[5]) : Strings.EMPTY
        );
    }

    private String readNeighbours(String neighbours) {
        String[] elements = neighbours.split("~");
        StringBuilder builder = new StringBuilder(Arrays.asList(elements).toString());
        builder.replace(0, 1, "");
        builder.replace(builder.length() - 1, builder.length(), "");
        return builder.toString().trim();
    }
}
