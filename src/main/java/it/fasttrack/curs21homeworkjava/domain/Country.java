package it.fasttrack.curs21homeworkjava.domain;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "capital")
    private String capital;

    @Column(name = "population")
    private Long population;

    @Column(name = "area")
    private Long area;

    @Column(name = "continent")
    private String continent;

    @Column(name = "neighbours")
    private String neighbours;

    public Country() {
    }

    public Country(String name, String capital, Long population, Long area, String continent, String neighbours) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public Long getPopulation() {
        return population;
    }

    public Long getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public String getNeighbours() {
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (capital != null ? !capital.equals(country.capital) : country.capital != null) return false;
        if (population != null ? !population.equals(country.population) : country.population != null) return false;
        if (area != null ? !area.equals(country.area) : country.area != null) return false;
        if (continent != null ? !continent.equals(country.continent) : country.continent != null) return false;
        return neighbours != null ? neighbours.equals(country.neighbours) : country.neighbours == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name = " + name + '\'' +
                ", capital = " + capital + '\'' +
                ", population = " + population +
                ", area = " + area +
                ", continent = " + continent + '\'' +
                ", neighbours = " + neighbours + '\'' +
                '}';
    }
}
